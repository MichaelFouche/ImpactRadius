/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impactradiustest1;

import java.util.Random;

/**
 *
 * @author Michael
 */
public class GenerateListOfNumbers {
    Random instanceRandomGenerator = new Random();
    
    public GenerateListOfNumbers()
    {
        
    }
    //This method receives input of the lowest value, highest value and amount of values to be generated. 
    //This input is used to generate random values into a integer array that is returned
    public String generateListOfNumbers(int length, int min, int max)
    {
        String list= "";
        for(int a=0;a<length;a++)
        {
            list += min+(instanceRandomGenerator.nextInt((max+1)-min));
            if(a!=length-1)
            {
                list +=",";
            }
        }
        return list;
    }
}
