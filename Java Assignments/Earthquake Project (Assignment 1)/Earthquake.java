
/**
 * This class will create an Earthquake instance and ask the user to record
 * the details of that instance. There are methods to get and set the values
 * of the earthquake - magnitude, latitude, longitude, year and name.
 * @author (Mark Millward)
 * @version (1.0)
 */
public class Earthquake
{
    private String latitude;
    private String longitude;
    private String year;
    private String name;
    private int magnitude;
    
    /**
     * Constructor for objects of class Earthquakes. Asks the user to input the values for
     * each earthquake and give it a reference name.
     */
    public Earthquake(String name, String latitude, String longitude, String year, int magnitude)
    {
        setName(name);
        setLatitude(latitude);
        setLongitude(longitude);
        setYear(year);
        setMagnitude(magnitude);
    }
    
     /**
     * This method returns the name of the earthquake.
     * 
     * @return name 
     */
    public String showName()
    {
        return name;
    }
    
     /**
     * This method allows the user to set the name of an earthquake.
     * 
     * @param string value of name 
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
        /**
     * This method returns the magnitude value of the earthquake.
     * 
     * @return magnitude value 
     */

    public int getMagnitude()
    {
        return magnitude;
    }
    
    /**
     * This method allows the user to set the magnitude value of an earthquake.
     * 
     * @param int value of magnitude 
     */
    
    public void setMagnitude(int magnitude)
    {
        this.magnitude = magnitude;          
    }
    
    /**
     * This method returns the latitude value of the earthquake.
     * 
     * @return latitude value 
     */
    
    public String getLatitude()
    {
        return latitude;
    }
    
    /**
     * This method allows the user to set the latitude value of the earthquake.
     * 
     * @param string latitude value 
     */
    
    public void setLatitude(String latitude)
    {
         this.latitude = latitude;
    }
    
    /**
     * This method returns the longitude value of the earthquake.
     * 
     * @return longitude value 
     */
    
    public String getLongitude()
    {
        return longitude;
    }
    
    /**
     * This method allows the user to set the longitude value of the earthquake.
     * 
     * @param string longitude value 
     */
    
    public void setLongitude(String longitude)
    {
         this.longitude = longitude;      
    }
  
     /**
     * This method returns the year the earthquake is recorded.
     * 
     * @return year value 
     */
    
    public String getYear()
    {
        return year;
    }
   
    /**
     * This method allows the user to set the year the earthquake is recorded.
     * 
     * @param string year value 
     */
    
    public void setYear(String year)
    {
         this.year = year;    
    }
}