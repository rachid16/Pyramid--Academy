package com.pyramid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Land {

    HashMap<Humans, int[]> humansMap = new HashMap<>();
    List<Goblins> goblinsList = new ArrayList<>();
    Players [][] grid ;




    public Land(){

        grid = new Players[10][10];
        for(int i=3; i<6; i++){
            humansMap.put(new Humans("name"+(i+1)), new int[]{9,i});
        }


        for(int i=0; i< 9; i++){
            goblinsList.add(new Goblins("name"+(i+1)));
        }

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                grid[i][j] = null;
            }
        }

        int [] temp;
        for (Humans humans : humansMap.keySet()) {
            temp = humansMap.get(humans);
            grid[temp[0]][temp[1]] = humans;
        }

        for(int i=0; i<1; i++){
            for(int j=0; j<9; j++){
                grid[i][j] = goblinsList.get(j);
            }
        }
    }

    public int aliveGoblins(){
        int alives = 0;
        for(Goblins goblin : goblinsList){
            if(goblin.isAlive())
                alives++;
        }

        return alives;
    }
    public int aliveHumans(){
        return humansMap.size();
    }

    public void disply(){

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(grid[i][j] == null)
                    System.out.print("   ");
                else
                    if (grid[i][j].isAlive() == false){
                        System.out.print("   ");
                        humansMap.remove(grid[i][j]);
                    }
                    else
                        System.out.print(grid[i][j].toString());

            }
            System.out.println();
        }

    }

    public void moveHumans(String str){
        if(str.equals("n")){
           int [] temp ;
            for (Humans humans : humansMap.keySet()) {
                temp = (humansMap.get(humans));
                grid[temp[0]][temp[1]] = null;
                temp[0] = temp[0] - 8 ;
                humansMap.replace(humans, temp);
            }
        }
        else if(str.equals("w")){
            int [] temp ;
            for (Humans humans : humansMap.keySet()) {
                temp = (humansMap.get(humans));
                grid[temp[0]][temp[1]] = null;
                temp[1] = temp[1] + 1;
                humansMap.replace(humans, temp);
            }
        }
        else if(str.equals("e")){
            int [] temp ;
            for (Humans humans : humansMap.keySet()) {
                temp = (humansMap.get(humans));
                grid[temp[0]][temp[1]] = null;
                temp[1] = temp[1] - 1;
                humansMap.replace(humans, temp);
            }
        }

        int [] temp;
        for (Humans humans : humansMap.keySet()) {
            temp = humansMap.get(humans);
            grid[temp[0]][temp[1]] = humans;
        }

    }

    public void startAttack(){
        for(int i=1; i<2; i++){
            for(int j=0; j<9; j++){
                if((grid[i][j] != null && grid[i-1][j] != null))
                    grid[i][j].attack(grid[i-1][j]);
            }
        }

    }

}
