
package impactradiustest1;

import java.util.Arrays;

/**
 *
 * @author      Michael Fouche
 * @cellphone   072 485 7747
 * @email:      fouche.sa@gmail.com
 */
public class ImpactRadiusTest1 {

    /**
     * @param args the command line arguments
     */
    
    /*
    REQUIREMENTS:
    Implement code which has the ability to produce a comma delimited list of numbers, grouping the numbers into a range when they are sequential. 

    For example:  

    When the following input is given: "1,3,6,7,8,12,13,14,15,21,22,23,24,31

    The application needs to have the ability to produce the following output: "1, 3, 6-8, 13-15, 21-24, 31"

    Keep in mind that the input might be out of order as well.

    The items being evaluated are: 
     - your ability to understand / interpret a requirement.
     - your coding ability.
     - optimization of your code.
     - your ability to compile a structured solution.

    The solution should be provided in Java, saved as a Java file and e - mailed back to me 
    
    ASSUMPTIONS
    Based on the requirements the asumption was made that the 4th set of values should be 12-15. Not 13-15 as stated.
    */
    
    
    
    public static void main(String[] args) 
    {
        try
        {
            //Test Data
            String testData = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";//From Requirements 
            String testData2 = "31,3,6,8,15,13,14,15,21,22,23,24,4,4";
            String testData3 = "12,3,47,33,11,16,44,31,25,15,29,5,37,29,8,9,47,25,44,3,24,25,35,33,39,25,47,45,35,13,37,26,41,15,10,37,3,9,23,29,44,33,7,36,18,39,5,33,10,23,19,21,26,39,45,40,14,41,15,31,40,12,50,32,21,19,20,17,13,45,15,10,21,37,10,6,11,21,8,33,41,28,10,50,38,14,49,3,45,50,22,49,34,16,24,40,31,40,15,11";
                       
            //Takes the string dataset, converts it to a int array of values, sorts the list, groups the values based on sequential order
            //This method can also be called with a int[] as parameter to only apply the group functionality to a list of integer values in an array.
            GroupNumbers instanceGN = new GroupNumbers();
            String resultData = instanceGN.groupNumbers(testData);

            //Display the list
            System.out.println(resultData);
            
            //=================================================================
            //Extended functionality to use the methods from a GUI interface
            GraphicalUserInterface instanceGUI = new GraphicalUserInterface();
            instanceGUI.graphicalUserInterface();            
            //=================================================================
        }
        catch(Exception error)
        {
            System.out.println("The program encountered an error while executing, please try again\n"+error);
        }        
    }
    
    
    
    
    
    
    
}
