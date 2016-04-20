/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impactradiustest1;

import java.util.Arrays;

/**
 *
 * @author Michael
 */
public class GroupNumbers {
    CalculateSymbol instanceCalcSym = new CalculateSymbol();
    RemoveDuplicates instanceRemDup = new RemoveDuplicates();
    public GroupNumbers()
    {
        
    }
    
    public String groupList()
    {
        
        return "";
    }
    //This method takes a String of values delimited by commas and converts it to a array of integer values. It then calls the groupNumbers(int []) method to group the values
    public String groupNumbers(String stringData)
    {
        //Split the numberList into an string array
        String[] stringDataSet = stringData.split(",");

        //Convert the string array to a int array
        StringArrayToIntArray instanceSTI = new StringArrayToIntArray(); 
        int[] intDataSet = instanceSTI.stringArrayToIntArray(stringDataSet);
        
        //Group the array of integers into a string value
        return groupNumbers(intDataSet);
    }

    //Group the array of integers into a string value
    public String groupNumbers(int[] intDataSet)
    {     
        String resultData = "";
        int dataSetLength = intDataSet.length;
        int currentValue;
        if(dataSetLength>0)
        {  
            //Order the list
            Arrays.sort(intDataSet);
            //Remove duplicate values from the list
            intDataSet = instanceRemDup.removeDuplicates(intDataSet);
            dataSetLength = intDataSet.length;  
            //Build the list
            for(int b=0;b<dataSetLength;b++)
            {  
                resultData += intDataSet[b];                    //Add first value of the group, even if it is only a group of 1
                currentValue = b;                               //Save the position of the first value in the group
                resultData += instanceCalcSym.calculateSymbol(intDataSet,b);//Determine the symbol to be used
                while((b+1)<dataSetLength && (intDataSet[b+1] == intDataSet[b]+1 ||intDataSet[b+1] == intDataSet[b]))
                {                                               //Find the end of the group                    
                    b++;
                } 
                if(b != currentValue)                           //If the position is not the same as before the while, hence a group was detected
                {
                    resultData += intDataSet[b];                //Add the value                    
                    if(intDataSet[b]!=intDataSet[dataSetLength-1])
                    {                                           //Append a comma unless this is the last value
                        resultData += ", ";             
                    }
                }                 
            }
        }
        else
        {
            System.out.println("The list does not contain values");
        }        
        return resultData;
    }
}
