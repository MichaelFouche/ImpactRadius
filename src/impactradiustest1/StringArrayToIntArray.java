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
public class StringArrayToIntArray {
    
    public StringArrayToIntArray()
    {
        
    }
    
    //This function converts a string array into a integer array
    public int[] stringArrayToIntArray(String[] stringDataSet)
    {        
        int dataSetLength = stringDataSet.length;
        int[] intDataSet = new int[dataSetLength];
        
        //Transfer the String array to an Int Array by using a loop
        for(int a=0;a<dataSetLength;a++)
        {  
            try
            { 
                intDataSet[a] = Integer.parseInt(stringDataSet[a]); 
            }
            catch(NumberFormatException numericError)
            {
                System.out.println("A value that is not numeric has been detected in the list at position "+ (a+1));                 
            }
            catch(Exception genericError)
            {
                System.out.println("An Error occured while processing the value at position " + (a+1) + "\n"+genericError);
            }
        }
        return intDataSet;
    }
}
