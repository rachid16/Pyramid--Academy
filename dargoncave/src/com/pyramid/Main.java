package com.pyramid;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Random random = new Random();

            System.out.println("You are in a land full of dragons. In front of you,\n" +
                    "\n" +
                    "you see two caves. In one cave, the dragon is friendly\n" +
                    "\n" +
                    "and will share his treasure with you. The other dragon\n" +
                    "\n" +
                    "is greedy and hungry and will eat you on sight.\n" );

            int entry;
            do{
                System.out.println("Which cave will you go into? (1 or 2)");
                while (!sc.hasNextInt()){
                    System.out.println("Wrong Entry");
                    sc.next();
                }
                entry = sc.nextInt();
            }while(!(entry ==1 || entry ==2));

            int x = random.nextInt(2)+1;
            if(x==entry)
                System.out.println("You approach the cave...\n" +
                        "\n" +
                        "It is dark and spooky...\n" +
                        "\n" +
                        "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                        "\n" +
                        "Gobbles you down in one bite!");
            else
                System.out.println("dragon is friendly and will share the treasure with you");

        }
}
