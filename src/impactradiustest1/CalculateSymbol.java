/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impactradiustest1;

/**
 *
 * @author Michael
 */
public class CalculateSymbol {
    
    public CalculateSymbol()
    {
        
    }    
    //Function to determine which symbol to use after a number
    public String calculateSymbol(int[] dataSet, int current)
    {        
        if(dataSet.length==current+1)
        {//if it's the last value
            return "";
        }
        else if(dataSet[current+1]==dataSet[current]+1)
        {//if the next value is forming a group with the current value
            return "-";
        }
        else
        {//if the value is not grouped
            return ", ";
        }
    }
}
