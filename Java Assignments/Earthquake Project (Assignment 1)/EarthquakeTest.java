
/**
 * This class creates two Earthquake objects, and has methods
 * to test that each get and set method works on either one.
 * 
 * @author (Mark Millward) 
 * @version (1.0)
 */
public class EarthquakeTest
{
    // instance variables - replace the example below with your own
    private Earthquake earthquake;
    private Earthquake earthquake2;

    /**
     * Constructor for objects of class test
     */
    public EarthquakeTest()
    {
        // initialise instance variables
        
    }

     /**
     * This method creates an earthquake with strings indicating that the test
     * has worked. It calls each get method, and will print that each method has worked.
     * Any missing will not have worked.
     * 
     * @param  
     * @return 
     */
    public void testGetMethods()
    {
        // put your code here
        earthquake = new Earthquake("Get Name has worked", "Get Latitude has worked", 
        "Get Longitude has worked", "Get Year has worked. Below this will be 5.", 5);
        System.out.println(earthquake.showName());
        System.out.println(earthquake.getLatitude());
        System.out.println(earthquake.getLongitude());
        System.out.println(earthquake.getYear());
        System.out.println(earthquake.getMagnitude());
    }
    
     /**
     * This method creates an earthquake, then uses each set method
     * to create strings indicating the test has worked.
     * It then calls each get method, and will print that each method has worked.
     * Any missing will not have worked.
     * 
     * @param  
     * @return 
     */
    public void testSetMethods() {
       earthquake2 = new Earthquake("Step one", "Step two", "Step three", "Step four", 5);
       earthquake2.setName("Name Changed");
       earthquake2.setLatitude("Latitude Changed");
       earthquake2.setLongitude("Longitude Changed");
       earthquake2.setYear("Year Changed. Value below will not be 5");
       earthquake2.setMagnitude(1);
        System.out.println(earthquake2.showName());
        System.out.println(earthquake2.getLatitude());
        System.out.println(earthquake2.getLongitude());
        System.out.println(earthquake2.getYear());
        System.out.println(earthquake2.getMagnitude());
    }
}
