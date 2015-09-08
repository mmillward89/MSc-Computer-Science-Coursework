
/**
 * This class creates multiple monitoring classes, and tests each monitoring method
 * against them, using various specified conditions, to ensure that the methods work
 * with or without the correct information.
 * 
 * @author (Mark Millward) 
 * @version (1.0)
 */
public class MonitoringTest
{
    // instance variables - replace the example below with your own
    private Monitoring monitoring;
    private Monitoring monitoring2;
    private Monitoring monitoring3;
    private Monitoring monitoring4;
    private Monitoring monitoring5;
    private Monitoring monitoring6;
    private Monitoring monitoring7;
    private Monitoring monitoring8;
    private Monitoring monitoring9;
    private Monitoring monitoring10;
    private Monitoring monitoring11;
    /**
     * Constructor for objects of class MonitoringTest
     */
    public MonitoringTest()
    {
        // initialise instance variables
        monitoring = new Monitoring();
        monitoring2 = new Monitoring();
        monitoring3 = new Monitoring();
        monitoring4 = new Monitoring();
        monitoring5 = new Monitoring();
        monitoring6 = new Monitoring();
        monitoring7 = new Monitoring();
        monitoring8 = new Monitoring();
        monitoring9 = new Monitoring();
        monitoring10 = new Monitoring();
        monitoring11 = new Monitoring();
    }

    /**
     * This method creates an observatory, adds it to a monitoring object, then lists all observatories
     * to check if it has been added. The name will print and indicate that the test
     * has worked.
     */
    public void testaddObservatory()
    {
        // put your code here
        Observatory observatory = new Observatory ("This will show if test has worked", "two", 
        "three", "four");
        monitoring.addObservatory(observatory);
        monitoring.ListAllObservatories();
    }
    
    /** This method creates two observatories, adds them to a monitoring object, then
     * calls list all observatories. Each name will form a sentence showing the method
     * has worked. If the sentence doesn't end in a full stop, it hasn't worked.
     * 
     * Technically this has already ben proven to have worked if testaddObservatory works,
     * but this tests it's efficacy with multiple observatories added.
     */
    public void testListAllEarthquakesMultipleEarthquakes() {
        Observatory observatory = new Observatory ("This test..", "two", 
        "three", "four");
        Observatory observatory2 = new Observatory ("..has passed.", "two", 
        "three", "four");
        monitoring2.addObservatory(observatory);
        monitoring2.addObservatory(observatory2);
        monitoring2.ListAllObservatories();   
    }
    
    /**
     * This method lists all observatories in a monitoring object that none have been
     * added to. It should suggest, then confirm that none have been added.
     * 
     * @param  
     * @return 
     */
    public void testListAllEarthquakesNoEarthquakes() {       
        monitoring3.ListAllObservatories();   
    }
    
    /**
     * This method creates two earthquakes, adding each to an observatory, which is
     * then added to a monitoring object. It will find the largest magnitude,
     * with the printed name indicating whether the test has worked or not.
     * 
     * @param 
     * @return Name of the earthquake with the largest magnitude. 
     */
    public String testfindLargestMagnitudeMultipleEarthquakes() {
        Observatory observatory = new Observatory ("One", "two", 
        "three", "four");
        Earthquake earthquake = new Earthquake("This test has worked", "Step two", "Step three", 
        "Step four", 10);
        Earthquake earthquake2 = new Earthquake("This test hasn't worked", "Step two", "Step three", 
        "Step four", 5);
        observatory.addEvent(earthquake);
        observatory.addEvent(earthquake2);
        monitoring.addObservatory(observatory);
        return (monitoring.findLargestMagnitude());
    }
    
    /**
     * This method creates an observatory, adding it to a monitoring object. 
     * It will print, then call the method to confirm, that none are available
     * to measure.
     * 
     * @param 
     * @return Name of the earthquake with the largest magnitude.
     */
    public String testfindLargestMagnitudeNoEarthquakes() {
        Observatory observatory = new Observatory ("One", "two", 
        "three", "four");
        monitoring4.addObservatory(observatory);
        System.out.println("This will return 'none available'");
        return (monitoring4.findLargestMagnitude());
    }
    
    /**
     * This method creates two earthquakes, adding each to an observatory, which is
     * then added to a monitoring object. It will find the largest magnitude,
     * will print what the largest value should be, then return it if it has worked.
     * 
     * @param  
     * @return Largest magnitude value of all available earthquakes.
     */
    public int testfindLargestMagnitudeValueMultipleEarthquakes() {
        Observatory observatory = new Observatory ("One", "two", 
        "three", "four");
        Earthquake earthquake = new Earthquake("Step one", "Step two", "Step three", 
        "Step four", 10);
        Earthquake earthquake2 = new Earthquake("Step one", "Step two", "Step three", 
        "Step four", 5);
        observatory.addEvent(earthquake);
        observatory.addEvent(earthquake2);
        monitoring5.addObservatory(observatory);
        System.out.println("This will return a value of ten");
        return (monitoring5.findLargestMagnitudeValue());
    }
    
    /**
     * This method creates an observatory, adding it to a monitoring object. 
     * It will print, then call the method to confirm, that a value of
     * zero will be returned, as no values exist.
     * 
     * @param 
     * @return Name of the earthquake with the largest magnitude.
     */
    public int testfindLargestMagnitudeValueNoEarthquakes() {
        Observatory observatory = new Observatory ("One", "two", 
        "three", "four");
        monitoring6.addObservatory(observatory);
        System.out.println("This will return a value of zero");
        return (monitoring6.findLargestMagnitudeValue());
    }
    
    /**
     * This method creates four earthquakes, adding two each to two observatories, which are
     * then added to a monitoring object. It will find the larger average of the two observatories,
     * and print it's name, indicating whether the test has worked or not.
     * 
     * @param  
     * @return Name of the observatory with the largest average magnitude value.
     */
    public String testfindObsLargestAverageMultipleAdded() {
        Observatory observatory = new Observatory ("This test hasn't worked", "two", 
        "three", "four");
        Earthquake earthquake = new Earthquake("Step one", "Step two", "Step three", 
        "Step four", 10);
        Earthquake earthquake2 = new Earthquake("Step one", "Step two", "Step three", 
        "Step four", 5);
        Observatory observatory2 = new Observatory ("This test has worked", "two", 
        "three", "four");
        Earthquake earthquake3 = new Earthquake("Step one", "Step two", "Step three", 
        "Step four", 20);
        Earthquake earthquake4 = new Earthquake("Step one", "Step two", "Step three", 
        "Step four", 10);
        observatory.addEvent(earthquake);
        observatory.addEvent(earthquake2);
        observatory2.addEvent(earthquake3);
        observatory2.addEvent(earthquake4);
        monitoring7.addObservatory(observatory);
        monitoring7.addObservatory(observatory2);
        return (monitoring7.findObsLargestAverage());
    }
    
    /**
     * This method attempts to find the largest average value for a monitoring object
     * without added observatories. It will indicate, then hopefully return, a message
     * that none are available to measure.
     * 
     * @param  
     * @return Name of the observatory with the largest average magnitude value.
     */
    public String testfindObsLargestAverageNoneAdded() {
       System.out.println("This test will return 'none available'"); 
       return (monitoring3.findObsLargestAverage()); 
    }
    
    /**
     * This method attempts to find the largest average value for a monitoring object
     * without added observatories. It will indicate, then hopefully return,
     * a value of zero.
     * 
     * @param  
     * @return The largest average magnitude value of all available earthquakes.
     */
    public int testfindLargestAverageValueNoneAdded() {
       System.out.println("This test will return zero"); 
       return (monitoring3.findLargestAverageValue()); 
    }
    
    /**
     * This method creates four earthquakes, then adds two each to two created observatories.
     * It then adds both observatories to a monitoring object. The method prints what the largest
     * average value should be (15, from observatory2 20 and 10 values, as opposed to observatory1
     * 5 and 10 values), then return the value the method calculates.
     * 
     * @param  
     * @return The largest average magnitude value of all available earthquakes.
     */
    public int testfindLargestAverageValueMultipleAdded() {
       Observatory observatory = new Observatory ("Step one", "two", 
       "three", "four");
       Earthquake earthquake = new Earthquake("Step one", "Step two", "Step three", 
       "Step four", 10);
       Earthquake earthquake2 = new Earthquake("Step one", "Step two", "Step three", 
       "Step four", 5);
       Observatory observatory2 = new Observatory ("Step one", "two", 
       "three", "four");
       Earthquake earthquake3 = new Earthquake("Step one", "Step two", "Step three", 
       "Step four", 20);
       Earthquake earthquake4 = new Earthquake("Step one", "Step two", "Step three", 
       "Step four", 10);
     
       observatory.addEvent(earthquake);
       observatory.addEvent(earthquake2);
       observatory2.addEvent(earthquake3);
       observatory2.addEvent(earthquake4);
       monitoring9.addObservatory(observatory);
       monitoring9.addObservatory(observatory2);
     
       System.out.println("This test will return 15");
       return (monitoring10.findLargestAverageValue());   
    }
    
    /**
     * This method creates four earthquakes, then adds two each to two created observatories.
     * It then adds both observatories to a monitoring object. The method tests a parameter of 12
     * against the four earthquakes of 5, 10, 15 and 20 magnitude, with the names indicating
     * whether it should have been printed or not.
     * 
     * @param  
     * @return 
     */
    public void testallAboveMagnitudeMultipleAdded() {
       Observatory observatory = new Observatory ("Step one", "two", 
       "three", "four");
       Earthquake earthquake = new Earthquake("This one should show", "Step two", "Step three", 
       "Step four", 15);
       Earthquake earthquake2 = new Earthquake("This one shouldn't show", "Step two", "Step three", 
       "Step four", 5);
       Observatory observatory2 = new Observatory ("Step one", "two", 
       "three", "four");
       Earthquake earthquake3 = new Earthquake("This one should show", "Step two", "Step three", 
       "Step four", 20);
       Earthquake earthquake4 = new Earthquake("This one shouldn't show", "Step two", "Step three", 
       "Step four", 10); 
       
       observatory.addEvent(earthquake);
       observatory.addEvent(earthquake2);
       observatory2.addEvent(earthquake3);
       observatory2.addEvent(earthquake4);
       monitoring10.addObservatory(observatory);
       monitoring10.addObservatory(observatory2);
       monitoring10.allAboveMagnitude(12);
    }
    
    /**
     * This method tests that a monitoring object without observatories added will
     * show that none have been added, testing a parameter of 0.
     * 
     * @param  
     * @return 
     */
    public void testAllAboveMagnitudeNoneAdded() {
        System.out.println("This should print 'no observatories to measure'");
        monitoring3.allAboveMagnitude(0);
    }
    
}
