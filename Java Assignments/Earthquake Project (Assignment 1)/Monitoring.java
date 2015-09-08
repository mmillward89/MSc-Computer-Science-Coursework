import java.util.ArrayList;

/**
 * Monitoring will store an array list of all observatories
 * and allow users to monitor specific measures related to them
 * and the earthquakes listed.
 * 
 * @author (Mark Millward) 
 * @version (1.0)
 */
public class Monitoring
{
    private ArrayList<Observatory> observatories;
    private int largestvalue;
    private String largest;
    private int largestaveragevalue;
    private String largestaverage;
    private Observatory selected;

    /**
     * Constructor for objects of class Monitoring
     * Creates an array list for observatories, and variables to store
     * the largest earthquake recorded value, largest average value,
     * and the name for both of these.
     */
    public Monitoring()
    {
        observatories = new ArrayList<Observatory>();
        largestvalue = 0;
        largest = "none available";
        largestaveragevalue = 0;
        largestaverage = "none available";
        selected = null;
    }

    /**
     * Method that allows Observatory objects to be added
     * to the array list.
     */ 
    public void addObservatory(Observatory observatory)
    {
        observatories.add(observatory);
    }
    
     /**
     * Method that lists all created observatories that have 
     * been added to the monitoring class.
     */ 
    public void ListAllObservatories() {
     if(observatories.size() != 0) {
       for(Observatory observatory : observatories) {
          System.out.println(observatory.getObservatory());
        }
     }
       else {
          System.out.println("No Observatories added to Monitoring");
     }
    }
    
    /**
     * This method finds the earthquake with the largest magnitude by
     * searching each observatory in its array list, 
     * storing the largest and returning its name.
     * 
     * @param  
     * @return The name of the earthquake with the largest magnitude.
     */
    public String findLargestMagnitude()
    {
        for(Observatory observatory : observatories) {  
            int magnitude = observatory.getLargestMagnitudeValue();
            if(largestvalue < magnitude) {
                largestvalue = magnitude;
                largest = observatory.getLargestMagEarthquake();
            }
        }
        return largest;
    }
    
    /**
     * This method finds the earthquake with the largest magnitude by
     * searching each observatory in its array list, 
     * storing the largest and returning its value.
     * 
     * @param  
     * @return     The value of the earthquake with the largest magnitude.
     */
    public int findLargestMagnitudeValue()
    {
        for(Observatory observatory : observatories) {  
            int magnitude = observatory.getLargestMagnitudeValue();
            if(largestvalue < magnitude) {
                largestvalue = magnitude;
                largest = observatory.getLargestMagEarthquake();
            }
        }
        return largestvalue;
    }
    
    /**
     * This method returns the observatory with the largest average earthquake magnitude
     * by comparing the average of each observatory, storing the largest
     * and returning its name.
     * 
     * @param  
     * @return The name of the observatory with the largest average magnitude value.    
     */
    public String findObsLargestAverage()
    { 
        for(Observatory observatory : observatories) {
          int average = observatory.findAverage();
          if(largestaveragevalue < average) {
              largestaveragevalue = average;
              largestaverage = observatory.getObservatory();
            }
        }
        return largestaverage;
    }
    
    /**
     * This method returns the observatory with the largest average earthquake magnitude
     * by comparing the average of each observatory, storing the largest
     * and returning its value.
     * 
     * @param  
     * @return The value of the observatory with the largest average magnitude value.    
     */
    public int findLargestAverageValue()
    { 
        for(Observatory observatory : observatories) {
          int average = observatory.findAverage();
          if(largestaveragevalue < average) {
              largestaveragevalue = average;
              largestaverage = observatory.getObservatory();
            }
        }
        return largestaveragevalue;
    }
    
    /**
     * This method looks at all observatories in its array list, calls
     * the Observatory method to list earthquakes above a user input parameter, 
     * and prints them to the console.
     * 
     * @param  Magnitude value selected by user
     * @return     
     */
    public void allAboveMagnitude(int value)
    {
        if(observatories.size() != 0) {
        for(Observatory observatory : observatories) {
            observatory.listAboveMagnitude(value);
        }
     }
     else {
         System.out.println("No observatories to measure");
        }
    }
    
    /**
     * This method is called by the chooseObservatory method in the Collections class, 
     * after the user has input an Observatory name, to check whether the name exists, 
     * storing the correct observatory if so, and, if not, printing a message to let them know.
     * 
     * @param 
     * @return  
     */
    public void checkObservatoryName(String name) 
    {
        for(Observatory observatory : observatories) {
           if(observatory.getObservatory().equals(name)) {
              selected = observatory;
            }
        }
        
        if(selected == null) {
          System.out.println("Observatory is not available, please input 'add' keyword");
          System.out.println("if you wish to try again, or input 'printobs' if you wish");
          System.out.println("to view all available observatories.");
        }
    }
    
    /**
     * This method returns the Observatory stored in the instance variable 'selected'.
     * It will be empty unless the user has input a parameter in the chooseObservatory
     * method in the Collections class.
     * 
     * @param 
     * @return  
     */
    public Observatory getSelected() {
       return selected; 
    }
}
