import java.util.*;

/**
 * Creates an ArrayList object with an added method to add an 
 * object to the list and sort the list in ascending order.
 * 
 * @author (Mark millward) 
 * @version (1.0)
 * 
 */
public class SortedArrayList<E> extends ArrayList
{
    /**
    * Constructor for SortedArrayList - calls the superclass constructor only.
    * 
    *     
    */
   public SortedArrayList()
   {
       super();
   }
   
   /**
    * Adds user selected object to the list, sorts the list in ascending order.
    * 
    * @param  user selected object, must include comparetTo method.
    *   
    */
   public <E extends Comparable> void SortandAdd(E a)
   {
       add(a);
       E temp;

       for(int i=0; i<size(); i++)
       {
           for(int j=i+1; j<size(); j++)
           {
               E b = (E) get(i);
               E c = (E) get(j);

               if(b.compareTo(c)>0)
               {
                   temp = b;
                   set(i, c);
                   set(j, temp);
               }
           }
       }   
   }
}
