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
public class RemoveDuplicates {
    
    public RemoveDuplicates()
    {
        
    }
    
    //This method takes a sorted list of integers and returns a integer list without any duplicate values in it.
    public int[] removeDuplicates(int[] duplicateList)
    {
        int[] resultList = new int[duplicateList.length];
        int current = 0;
        resultList[current]=duplicateList[current];
        for(int a=1;a<duplicateList.length;a++)
        {
            if(duplicateList[a]!=resultList[current])
            {
                resultList[current+1]=duplicateList[a];
                current++;
            }
        }
        int[] resizedResultList = new int[current+1];
        System.arraycopy(resultList, 0, resizedResultList, 0, resizedResultList.length);
        
        return resizedResultList;
    }
}
