/***************************************
 * Chris Carmine
 * https://adventofcode.com/2020/day/7
***************************************/

public class entry {

    String name;
    String rules;
    int ID;

    entry(String name[],int ID){

        this.name = name[0];
        rules = name[1];
        this.ID = ID;

    }

    public String getName(){
        return name;
    }

    public String getRules(){
        return rules;
    }

    public int ID(){
        return ID;
    }
    
}
