package com.pyramid;

import java.util.*;

public class Main {
    static ArrayList<Integer> toUse = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static String[] table = new String[9];
    static String winner ="";
    static String player = "";
    static String computer = "";
    public static void main(String[] args) {

        System.out.println("Welcome to Tic-Tac-Toe!");

        do {

            reset();

            System.out.println("Do you want to be X or O?");
            player = input.nextLine().toUpperCase();
            if(player.equals("X"))
                computer = "O";
            else
                computer = "X";

            System.out.println("The computer will go first.");
            int a = computerTurn();
            table[a-1] = computer;
            toUse.remove(new Integer(a));
            printBoard();


            while(winner.equals("")){

                System.out.println("What is your next move? (1-9)");
                int nextMove = Integer.parseInt(input.nextLine());

                if ((table[nextMove-1].equals("X")) || (table[nextMove-1].equals("O"))) {
                    System.out.println("this number already token");
                }
                else {
                    table[nextMove - 1] = player;
                    toUse.remove(new Integer(nextMove));
                }

                printBoard();

                a = computerTurn();
                table[a-1] = computer;
                toUse.remove(new Integer(a));


                if(findWinner("XXX")){
                    if(player.equals("X"))
                        System.out.println("you have beaten the computer! You won.");
                    else
                        System.out.println("The computer has beaten you! You lose.");
                    winner = "X";
                }
                else if(findWinner("OOO")){
                    if(player.equals("O"))
                        System.out.println("you have beaten the computer! You won.");
                    else
                        System.out.println("The computer has beaten you! You lose.");
                    winner = "O";
                }
                else
                    winner ="";
            }

        }while (promptTryAgain());


    }

    static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + table[6] + " | "
                + table[7] + " | " + table[8]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + table[3] + " | "
                + table[4] + " | " + table[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + table[0] + " | "
                + table[1] + " | " + table[2]
                + " |");
        System.out.println("|---|---|---|");
    }

    static boolean findWinner(String line) {

        if ((table[0] + table[1] + table[2]).equals(line))
            return true;
        else if ((table[3] + table[4] + table[5]).equals(line))
            return true;
        else if ((table[6] + table[7] + table[8]).equals(line))
            return true;
        else if ((table[0] + table[3] + table[6]).equals(line))
            return true;
        else if ((table[1] + table[4] + table[7]).equals(line))
            return true;
        else if ((table[2] + table[5] + table[8]).equals(line))
            return true;
        else if ((table[0] + table[4] + table[8]).equals(line))
            return true;
        else if ((table[2] + table[4] + table[6]).equals(line))
            return true;
        else
            return false;
    }
    static boolean promptTryAgain () {
        while (true) {
            System.out.print("Do you want to play again? (yes or no)");
            String response = input.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                return true;
            } else if (response.equalsIgnoreCase("no")) {
                return false;
            }
            System.out.println("Invalid input.");
        }
    }

    static int computerTurn(){
        int randomElement;
        do{
            Random rand = new Random();
            randomElement = rand.nextInt(9)+1;

        }while(!(toUse.contains(randomElement)));

        return randomElement;
    }
    static void reset(){
        winner ="";
        player = "";
        computer = "";
        for (int i= 0; i<9; i++)
            table[i]=" ";

        toUse.clear();
        for (int i=1 ; i<= 9; i++)
            toUse.add(i);

    }
}

