/***************************************
 * Chris Carmine
 * https://adventofcode.com/2020/day/7
***************************************/

import java.util.ArrayList;
import java.util.Stack;

public class AoC2020d7part2 {
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

        Stack<Integer> branch = new Stack<Integer>();
        Stack<Integer> multiples = new Stack<Integer>();
        Stack<Integer> rowSums = new Stack<Integer>();
        //int row = 479; //hard coded to start at shiny gold
        //int row = 4;
        int row = 0;
        int col = 0;
        int totalBags = 0; 
        int multiple = 1;
        int rowSum = 0;

        branch.clear();
        multiples.clear();
        branch.push(-1); //dummy entry to enter the loop
        multiples.push(1);

    
        while(!branch.isEmpty()){
            branch.pop(); //pop off inital dummy value and prior branch value
            //multiples.pop();
            rowSum = 0;
            multiple = 1;

            for (col = 0; col < rules[row].length;col++){

                rowSum = rowSum + rules[row][col];
                rowSums.push(rowSum);

                if (rules[row][col] != 0){
                    branch.push(col); 
                    multiples.push(rules[row][col]);
                }
            }

            for (Integer m : multiples){
                multiple = m* multiple;
            }

            totalBags = totalBags + multiple*rowSum;
            System.out.printf("Current Bag: %d, Current count: %d%n",row+1,totalBags);

            if (!branch.isEmpty()){
                row = branch.peek();
                multiple = multiples.peek();
            }
        }
    
        System.out.printf("Total bags: %d",totalBags);

    } //main
    
} //class
