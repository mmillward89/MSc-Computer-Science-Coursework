import java.util.ArrayList;                                      
import java.util.Iterator;

/**
 * Observatory class will store information on the observatory,
 * and contains an array list that allows users to store all earthquake objects
 * recorded at the observatory, can call various methods to gain information
 * on them.
 * 
 * @author (Mark Millward) 
 * @version (1.0)
 */
public class Observatory
{
    private String observatory;
    private String country;
    private String year;
    private String area;
    private String largest;
    private int largestvalue;
    private ArrayList<Earthquake> eventsrecorded;
    private int [] averagecalculator;

    /**
     * Constructor for objects of class Observatory. Creates instance variables to store
     * information on observatory, one each to store the name and value of the largest earthquake
     * recorded, and an array list to store Earthquake objects.
     */
    public Observatory(String observatory, String country, String year, String area)
    {
        // initialise instance variables
        setObservatory(observatory);
        setCountry(country);
        setYear(year);
        setArea(area);
        largest = "none available";
        largestvalue = 0;
        eventsrecorded = new ArrayList<Earthquake>();
    }
    
    /**
     * This method will return the name of the observatory.
     * 
     * 
     * @return     Observatory name 
     */
    public String getObservatory()
    {
        return observatory;
    }
    
    /**
     * This method allows the user to to set the name of the observatory.
     * 
     * 
     * @param     Observatory name 
     */
    public void setObservatory(String observatory) {
        this.observatory = observatory;
    }
    
    /**
     * This method will return the name of the country the observatory is located in.
     * 
     * 
     * @return     country located in. 
     */
    public String getCountry()
    {
        return country;
    }
    
    /**
     * This method allows the user to to set the country the observatory is located in.
     * 
     * 
     * @param     country name 
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * This method will return the year the observatory was founded.
     * 
     * 
     * @return     year founded. 
     */
    public String getYear()
    {
        return year;
    } 
    
    /**
     * This method allows the user to to set the year the observatory was founded.
     * 
     * 
     * @param     year founded 
     */
    public void setYear(String year) {
        this.year = year;
    }
    
    /**
     * This method will return the area value.
     * 
     * 
     * @return     area in square meters 
     */
    public String getArea()
    {
        return area;
    } 
    
    /**
     * This method allows the user to to set the area the observatory was covers.
     * 
     * 
     * @param     area in square meters
     */
    public void setArea(String area) {
        this.area = area;
    }
    
    /**
     * This method will allow users to add Earthquake objects to the array list.
     * 
     * @param  the name of an Earthquake instance
     * @return      
     */
    public void addEvent(Earthquake event)
    {
        // put your code here
        eventsrecorded.add(event);
    }
   
    /**
     * This method will allow users to list all Earthquakes recorded at the observatory
     * by checking all earthquakes stored in the array list, calling showName for each,
     * and printing the results to the console.
     * 
     * @param  
     * @return 
     */
    public void listAllEarthquakes()
   {
     if(eventsrecorded.size() != 0) {
      for(Earthquake event : eventsrecorded) {
          System.out.println(event.showName());
        }
    }
     else {
        System.out.println("No earthquakes added to observatory");
    }
   }

    /**
     * This method will call calcLargestMagnitude then return the name
     * of the Earthquake with the largest magnitude value.
     * 
     * @param  
     * @return name of Earthquake with largest magnitude value.
     */
    public String getLargestMagEarthquake()
   {
       calcLargestMagnitude();
       return largest;
    }
    
    /**
     * This method will call calcLargestMagnitude then return the magnitude value
     * of the earthquake with the largest magnitude value.
     * 
     * @param  
     * @return largest magnitude value available
     */
   public int getLargestMagnitudeValue()
   {
       calcLargestMagnitude();
       return largestvalue;
   }

     /**
     * This method will calculate the largest magnitude earthquake of all
     * Earthquakes stored in the array list. It compares each earthquake's magnitude
     * value, storing the name and number in seperate instance variables.
     * 
     * 
     * @param  
     * @return 
     */
   private void calcLargestMagnitude()
   {     
       for(Earthquake event : eventsrecorded) {
         int magnitude = event.getMagnitude();
         if(largestvalue < magnitude) {
             largestvalue = magnitude;
             largest = event.showName();
            }
         }
   }
      
   /**
     * This method will allow users to look at all earthquakes with a magnitude
     * above a user selected parameter. It looks at each earthquake in the 
     * array list, calling the getMagnitude method, and printing it to the console
     * if it is above the parameter.
     * 
     * @param  number value for magnitude
     * @return 
     */
   public void listAboveMagnitude(int magvalue)
   {
     if(eventsrecorded.size() != 0) {
       for(Earthquake event: eventsrecorded) {
         int getmagnitude = event.getMagnitude();
         if (getmagnitude > magvalue){
             System.out.println(event.showName());
            }
        }
    }
    else {
        System.out.println("No earthquakes available to measure");
    }
    }
   
   /**
    * This method will call addtoArray, then use that array to add each value
    * together. It then divides the total by the length of the array, which is always equal
    * to how many values are in it, and returns the average value.
    * 
    * @param  
    * @return the average of all magnitude values in this observatory.
    */
   public int findAverage()
   {
     addtoArray();
     int total = 0;
    if(averagecalculator.length != 0) {
     for(int i=0; i < averagecalculator.length; i++) {
     total = total + averagecalculator[i];
    }
    return total/averagecalculator.length;
    }
    else {
        return 0;
    }
}
    
/**
 * This method will add all magnitude values in the Observatory array list 
 * into an array, for ease of access and calculation, to allow other methods
 * to call as necessary. 
 * 
 * @param      
 * @return 
 */ 
private void addtoArray()
{ 
   averagecalculator = new int[eventsrecorded.size()];
   int i = 0;
     for(Earthquake event: eventsrecorded) {
         int magnitude = event.getMagnitude();
         averagecalculator[i] = magnitude;
         i ++;
     }
}
 
}