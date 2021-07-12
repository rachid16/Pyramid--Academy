package com.pyramid;

import java.util.*;

public class Main {
    static Scanner scanner= new Scanner(System.in);
    static List<String> dashes = new ArrayList<>();
    static String[][] drowing = { { "", "|" }, { "", "|" }, { "", "|" } };
    static Random random = new Random();
    static List<String> guess = new ArrayList<>();
    static List<String> correct = new ArrayList<>();;

    public static void main(String[] args) {
	// write your code here

        ArrayList<String> randomWord = new ArrayList<>();


        randomWord.add("cat");
        randomWord.add("dog");
        randomWord.add("lion");
        randomWord.add("bee");
        randomWord.add("fish");
        randomWord.add("horse");
        randomWord.add("deer");


        //split word into a List


        System.out.println("thinks of a word and then draws a blank line on the page for each letter in the word." +
                " The second player then tries to guess letters that might be in the word.");
        System.out.println("H A N G M A N");
        String again="yes";

        int man = 0;
        while(again.equals("yes")&& man<=2){
            reset();

            String word = randomWord.get(random.nextInt(randomWord.size()));
            man = 0;

            //correct= Arrays.asList(word.split(""));
            for (var s: Arrays.asList(word.split("")))
                correct.add(s);


            for(int i=0; i<word.length();i++)
                dashes.add("_");
            while(dashes.contains("_")){
                menu();
                System.out.println("Guess a letter.");
                String entry = scanner.nextLine();

                if(guess.contains(entry)){
                    System.out.println("You have already guessed that letter. Choose again.");
                    continue;
                }


                int i=-1;

                if(correct.contains(entry)){
                        i = correct.indexOf(entry);
                        dashes.set(i,entry);
                        i = correct.lastIndexOf(entry);
                        dashes.set(i,entry);

                }else {
                    guess.add(entry);
                    if(man == 0)
                        drowing[man][0]= "O";
                    else if(man >1){
                        System.out.println("you lost");
                        drowing[man][0]= "|";
                        man++;
                        break;
                    }else{
                        drowing[man][0]= "|";
                    }
                    man++;

                }
            }
            menu();
            if(!(dashes.contains("_"))){
                System.out.println("Yes! The secret word is \" "+ word + "\"! You have won!\n" +
                        "\n" +
                        "Do you want to play again? (yes or no)");
                again = scanner.nextLine();
            }
        }

    }

    public static void menu(){
        System.out.println("+---+");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(drowing[i][j] + " ");
            }

            System.out.println();
        }
        System.out.println("===");
        System.out.print(" Missed letters:");
        for(var d: guess)
            System.out.print(d);

        System.out.println("");
        for(var d: dashes)
            System.out.print(d);

        System.out.println("");
    }
    public static void reset(){
        //reset the arrays
        correct.clear();
        guess.clear();
        dashes.clear();
        for (int i=0; i<3;i++){
            drowing[i][0]= "";
        }
    }

}
