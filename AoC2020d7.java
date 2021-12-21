/***************************************
 * Chris Carmine
 * https://adventofcode.com/2020/day/7
***************************************/

import java.util.ArrayList;
import java.util.Stack;

public class AoC2020d7 {
    public static void main(String args[]){
        
        final int[][] rules = fileParse.ruleGen();

        // System.out.printf("%d%n",rules.length);
        // System.out.printf("%d%n",rules[1].length);
        
        // for (int row =0;row<rules.length;row++){
        //     for (int col = 0; col < rules[row].length;col++){
        //         System.out.printf("%d ",rules[row][col]);
        //     }
        //     System.out.println();
        // }

        // final int[][] rules = {{0,0,1,2,0,0,0,0,0},
        //                         {0,0,3,4,0,0,0,0,0},
        //                         {0,0,0,0,1,0,0,0,0},
        //                         {0,0,0,0,2,0,0,9,0}, 
        //                         {0,0,0,0,0,1,2,0,0},
        //                         {0,0,0,0,0,0,0,3,4},
        //                         {0,0,0,0,0,0,0,5,6},
        //                         {0,0,0,0,0,0,0,0,0},
        //                         {0,0,0,0,0,0,0,0,0}};



        boolean targetFound = false;
        int numShinyGold = 0;
        int row = 0;
        int bag = 0;
        int col = 0;
        ArrayList<Integer> shinyGolds = new ArrayList<Integer>();
        ArrayList<Integer> tree = new ArrayList<Integer>();
        Stack<Integer> branch = new Stack<Integer>();

        for (bag = 0; bag < rules.length; bag++){

            tree.clear();
            branch.clear();
            branch.push(-1); //dummy entry to enter the loop
            row = bag;
            tree.add(bag); //add yourself to the search tree

            //build the tree
            while(!branch.isEmpty()){
                branch.pop(); //pop off inital dummy value and prior branch value
                for (col = 0; col < rules[row].length;col++){
                    if (rules[row][col] != 0){
                        tree.add(col); 
                        branch.push(col); //branches I am not sure get added to search tree, they may be empty
                    }
                }
                if (!branch.isEmpty()){
                    row = branch.peek();
                }
            }

            //search the tree
            targetFound = false;
            for (Integer i : tree){
                //System.out.printf("Branch %d, Searching bag %d%n",bag,i);
                if (rules[i][479]!=0 && !targetFound){ //target is hard coded. target is 4 in the smoke test, 479 in real puzzle
                    targetFound = true;
                    shinyGolds.add(bag);
                    numShinyGold++;
                } 
            }

        } // main for

        System.out.printf("Number of shiny gold bags: %d%n",numShinyGold);
        for (Integer s : shinyGolds){
            System.out.printf("Bag %d%n",s);
        }


    } //main
    
} //class
