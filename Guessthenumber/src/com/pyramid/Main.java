package com.pyramid;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static  Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {

        String again = "y";
        System.out.println("Hello! What is your name?");
        String name = sc.nextLine();
        System.out.println("Well, "+ name +", I am thinking of a number between 1 and 20.");

        while(again.equals("y") || again.equals("Y")){

            int x = random.nextInt(20)+1;
            int nGuesses = 0;

            int guess = takeAguess();
            while(x!=guess){
                if(guess>x){
                    System.out.println("Your guess is too high.");
                }else{
                    System.out.println("Your guess is too low.");
                }
                guess = takeAguess();
                nGuesses++;
            }
            System.out.println("Good job, Abaddon! You guessed my number in "+ nGuesses +" guesses!");
            System.out.println("Would you like to play again? (y or n)");

            again = sc.nextLine();

        }


    }
    public static int takeAguess(){
        int entry=-1;
        System.out.println("Take a guess.");

        do{
            while (!sc.hasNextInt()){
                System.out.println("Wrong Entry");
                sc.nextLine();
            }
            entry = sc.nextInt();
            sc.nextLine();
            if(entry < 1 || entry > 20)
                System.out.println("Please enter a number between 1 and 20.");

        }while(entry < 1 || entry > 20);

        return entry;
    }
}
