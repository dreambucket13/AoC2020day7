public class node {

private int[] rules;
private int bagID;

    public node(int i,int...r){

        bagID = i;
        rules = r;
    }

    public int[] getRules(){

        return rules;
    }

    public int getID(){

        return bagID;
    }


}