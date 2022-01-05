/***************************************
 * Chris Carmine
 * https://adventofcode.com/2020/day/7
***************************************/

import java.util.ArrayList;
import java.util.Stack;

public class AoC2020d7part2 {
    public static void main(String args[]){

        int col = 0;
        int totalBags = -1; //starting with -1, problem doesn't count the first bag
        int bagNum = 479;         //hard coded to start at shiny gold
        
        final int[][] rules = fileParse.ruleGen();
        int[] contents;
        int bags;
        boolean end = false;

        // System.out.printf("%d%n",rules.length);
        // System.out.printf("%d%n",rules[1].length);
        
        // for (row =0;row<rules.length;row++){
        //     for (col = 0; col < rules[row].length;col++){
        //         System.out.printf("%d ",rules[row][col]);
        //     }
        //     System.out.println();
        // }




        Stack<node> currentLayer = new Stack<node>();
        Stack<node> nextLayer = new Stack<node>();
        currentLayer.push(new node(bagNum,fileParse.conv1D2D(bagNum, rules)));



        while (!currentLayer.isEmpty() && !end){

            //build next layer
            contents = currentLayer.peek().getRules();

            // for (col = 0; col < contents.length;col++){
            //     System.out.printf("%d ",rules[bagNum][col]);
            // }
            // System.out.println();

            for (col = 0; col < contents.length;col++){
                if (contents[col]!=0){

                    bags = contents[col];
                    while (bags > 0){
                        nextLayer.push(new node(col, fileParse.conv1D2D(col, rules)));
                        //System.out.println("pushed");
                        bags--;
                    }



                }
            }

            //destroy and count current layer
            currentLayer.pop();
            //System.out.println("popped");
            totalBags++;

            if (currentLayer.isEmpty() && !nextLayer.isEmpty()){
                //System.out.println("Layers transferred");

                for (node n : nextLayer){
                    currentLayer.add(n);
                }

                nextLayer.clear();
            } else if (currentLayer.isEmpty() && nextLayer.isEmpty()){
                //System.out.println("the end?");
                end = true;
            }

            

        }
        
        System.out.printf("Total bags: %d",totalBags);

    } //main




    
    
} //class

