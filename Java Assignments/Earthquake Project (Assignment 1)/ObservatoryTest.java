
/**
 * This class creates multiple observatory objects, testing
 * the observatory methods against each one, sometimes with different 
 * options, to check that each method works whether it does or doesn't
 * have the correct information.
 * 
 * @author (Mark Millward) 
 * @version (1.0)
 */
public class ObservatoryTest
{
    // instance variables - replace the example below with your own
    private Observatory observatory;
    private Observatory observatory2;
    private Observatory observatory3;
    private Observatory observatory4;
    private Observatory observatory5;
    private Observatory observatory6;
    /**
     * Constructor for objects of class ObservatoryTest
     */
    public ObservatoryTest()
    {
        // initialise instance variables
        observatory = new Observatory("getObservatory has worked", "getCountry has worked",
        "getYear has worked", "getArea has worked");
        observatory2 = new Observatory("Step one", "Step two", "Step three", "Step four");
        observatory3 = new Observatory("Step one", "Step two", "Step three", "Step four");
        observatory4 = new Observatory("Step one", "Step two", "Step three", "Step four");
        observatory5 = new Observatory("Step one", "Step two", "Step three", "Step four");
        observatory6 = new Observatory("Step one", "Step two", "Step three", "Step four");
    }
    
     /**
     * This method calls each get method for an observatory, then
     * prints a message to the console indicating it works. Any not listed
     * will not have worked.
     * 
     * @param  
     * @return 
     */
    public void testGetMethods()
    {
        // put your code here
        System.out.println(observatory.getObservatory());
        System.out.println(observatory.getCountry());
        System.out.println(observatory.getYear());
        System.out.println(observatory.getArea());
    }
    
     /**
     * This method calls each set method for an observatory, then
     * prints each change to the console indicating it works. Any not listed
     * will not have worked.
     * 
     * @param  
     * @return 
     */
    public void testSetMethods() {
       observatory2.setObservatory("setObservatory has worked");
       observatory2.setCountry("setCountry has worked");
       observatory2.setYear("setYear has worked");
       observatory2.setArea("setArea has worked");
       System.out.println(observatory2.getObservatory());
       System.out.println(observatory2.getCountry());
       System.out.println(observatory2.getYear());
       System.out.println(observatory2.getArea());
    }
    
     /**
     * This method creates an earthquake, adds it to an observatory, then
     * calls list all earthquakes to prove it has been added. The name is 'event added',
     * so this will show if the method has worked
     * 
     * @param  
     * @return 
     */
    public void testaddEvent() {
        Earthquake earthquake = new Earthquake("Event added", "Step two", "Step three", "Step four", 
        5);
        observatory.addEvent(earthquake);
        observatory.listAllEarthquakes();
    }
    
    /**
     * This method creates four earthquakes, adds them to an observatory, then
     * calls list all earthquakes. Each name will form a sentence showing the method
     * has worked. If the sentence doesn't end in a full stop, it hasn't worked.
     * 
     * Technically this has already been proven to have worked if testaddEvent works,
     * but this tests its efficacy with multiple earthquakes added.
     * 
     * @param  
     * @return 
     */
    public void testlistALLEarthquakes() {
        Earthquake earthquake = new Earthquake("List", "Step two", "Step three", "Step four", 
        5);
        Earthquake earthquake2 = new Earthquake("All", "Step two", "Step three", "Step four", 
        5);
        Earthquake earthquake3 = new Earthquake("Earthquakes", "Step two", "Step three", "Step four", 
        5);
        Earthquake earthquake4 = new Earthquake("Works.", "Step two", "Step three", "Step four", 
        5);
        observatory2.addEvent(earthquake);
        observatory2.addEvent(earthquake2);
        observatory2.addEvent(earthquake3);
        observatory2.addEvent(earthquake4);
        observatory2.listAllEarthquakes();
    }
    
    /**
     * This method lists all earthquakes in an observatory that none have been
     * added to. It should print, then confirm via the method that none have been added.
     * 
     * @param  
     * @return 
     */
    public void testlistAllEarthquakesNoneAdded() {
        System.out.println("This will print that none have been added");
        observatory3.listAllEarthquakes();
    }
    
    /**
     * This method creates two earthquakes, adds them to an observatory, and prints
     * the one with the larger magnitude, named 'test... has worked', while the
     * smaller has been named the same, but 'hasn't'.
     * 
     * @param  
     * @return name of earthquake with largest magnitude value
     */
    public String testgetLargestMagEarthquakeMultipleAdded() {
        Earthquake earthquake = new Earthquake("testLargestMagEarthquake has worked", "Step two", "Step three", "Step four", 
        5);
        Earthquake earthquake2 = new Earthquake("testLargestMagEarthquake hasn't worked", "Step two", "Step three", "Step four", 
        1);
        observatory4.addEvent(earthquake);
        observatory4.addEvent(earthquake2);
        return (observatory4.getLargestMagEarthquake());
    }
    
    /**
     * This method calls an observatory with no earthquakes added, and will print,
     * then confirm via the method, that none have been added, and therefore 
     * a largest earthquake cannot be found.
     * 
     * @param  
     * @return 
     */
    public String testgetLargestMagEarthquakeNoneAdded() {
       System.out.println("This will print that none have been added");
       return observatory3.getLargestMagEarthquake(); 
    }
    
    /**
     * This method creates two earthquakes, adds them to an observatory, and prints
     * the value of the one with the larger magnitude. It prints what the larger
     * value should be, then calls the method and returns the value, which should match.
     * 
     * @param  
     * @return integer value of largest magnitude available
     */
    public int testgetLargestMagnitudeValueMultipleAdded() {
        Earthquake earthquake = new Earthquake("testLargestMagEarthquake has worked", "Step two", "Step three", "Step four", 
        5);
        Earthquake earthquake2 = new Earthquake("testLargestMagEarthquake hasn't worked", "Step two", "Step three", "Step four", 
        1);
        observatory4.addEvent(earthquake);
        observatory4.addEvent(earthquake2);
        System.out.println("Value should read 5");
        return (observatory4.getLargestMagnitudeValue());
    }
    
    /**
     * This method calls an observatory with none added, and will suggest,
     * then confirm, that a value of zero will be returned, meaning no
     * values have been added.
     * 
     * @param  
     * @return integer value of largest magnitude available
     */
    public int testgetLargestMagnitudeValueNoneAdded() {
        System.out.println("This will return a value of zero");
        return (observatory3.getLargestMagnitudeValue());
    }
    
    /**
     * This method creates two earthquakes, magnitude values 1 and 5, adds them to an observatory, 
     * and calls the listAboveMagnitude method twice, parameters 3 and 0. The first will only 
     * return one earthquake, and the second two, showing that the method can accurately measure 
     * and compare a parameter.
     * 
     * @param user inputted magnitude value 
     * @return 
     */
    public void testlistAboveMagnitude() {
      Earthquake earthquake = new Earthquake("earthquake1", "Step two", "Step three", "Step four", 
        5);
      Earthquake earthquake2 = new Earthquake("earthquake2", "Step two", "Step three", "Step four", 
        1);
      observatory5.addEvent(earthquake);
      observatory5.addEvent(earthquake2);
      System.out.println("earthquake will be printed below this");
      observatory5.listAboveMagnitude(3);
      System.out.println("earthquake and earthquake2 will be printed below this");
      observatory5.listAboveMagnitude(0);
    }
    
    /**
     * This method tests an observatory without earthquakes added for an average value,
     * returning zero, as indicated.
     * 
     * @param  
     * @return integer value of average magnitude of available earthquakes
     */
    public int testFindAverageNoEarthquakes() {
        System.out.println("This will return a value of zero");
        return (observatory3.findAverage());
    }
    
    /**
     * This method creates three earthquakes, magnitude 5, 10, and 15,
     * adds them to an observatory, then calls for the average value.
     * It prints that it should return ten, which it then will do if
     * it works.
     * 
     * @param  
     * @return integer value of average magnitude of available earthquakes
     */
    public int testFindAverageMultipleEarthquake() {
      Earthquake earthquake = new Earthquake("earthquake1", "Step two", "Step three", "Step four", 
        5);
      Earthquake earthquake2 = new Earthquake("earthquake1", "Step two", "Step three", "Step four", 
        10);
      Earthquake earthquake3 = new Earthquake("earthquake1", "Step two", "Step three", "Step four", 
        15);
      observatory6.addEvent(earthquake);
      observatory6.addEvent(earthquake2);
      observatory6.addEvent(earthquake3);
      System.out.println("This will return a value of ten");
      return (observatory6.findAverage());
    }
}
