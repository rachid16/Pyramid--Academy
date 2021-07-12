package com.pyramid;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
	// write your code here
        Land land = new Land();
        land.disply();

        do{
            String entry = "";
            String attackEntry = "";
            while(!(entry.equals("n") || entry.equals("s" ) || entry.equals("e") || entry.equals("w"))){
                System.out.println("Where do want to go North tap: \'n\' South tap \'s\' East tap: \'e\' West tap: \'w\' ");
                entry = sc.nextLine().toLowerCase();

            }

                land.moveHumans(entry);
                land.disply();

            while(!(attackEntry.equals("y") || attackEntry.equals("n"))){
                System.out.println("Do you want to attack Goblins tap: \'y\' or \'n\' ");
                attackEntry = sc.nextLine().toLowerCase();
            }
            if(attackEntry.equals("y")){
                land.startAttack();
                land.disply();
            }

        }while(land.aliveGoblins()>0 && land.aliveHumans() > 0);

        if(land.aliveGoblins()==0)
            System.out.println("You won");
        else if (land.aliveHumans() ==0)
            System.out.println("You lost");


    }
}
