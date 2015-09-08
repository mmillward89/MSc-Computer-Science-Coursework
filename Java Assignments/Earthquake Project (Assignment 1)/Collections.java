import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * This class is created by the MonitoringIO, and stores all collections
 * and methods for objects created by user input. The monitoring class,
 * any user created earthquakes and observatories will be stored here,
 * along with the methods that allow users to create them, add them
 * to the collections, and ask for certain measures e.g. largest average earthquake.
 * 
 * @author Mark Millward 
 * @version (1.0)
 */
public class Collections
{
    // instance variables - replace the example below with your own
    private Scanner reader;
    private Scanner intReader;
    private Monitoring monitor;
    private ArrayList<Monitoring> monitoring;
    private ArrayList<Earthquake> miscEarthquakes;
    private Earthquake selected;
    private String[] names;
    private int[] number;

    /**
     * Constructor for objects of class Collections. Creates two scanner objects,
     * one each for string and integer values. A Monitoring object and an array list
     * to store it, and an array list for earthquakes created by the user that aren't
     * yet stored in an observatory. 
     * 
     * It also creates two arrays for use when creating user inputted observatory and 
     * earthquake objects, and an instance variable to store an earthquake when adding it
     * to an observatory.
     */
    public Collections()
    {
        // initialise instance variables
        reader = new Scanner(System.in);
        intReader = new Scanner(System.in);
        monitor = new Monitoring();
        monitoring = new ArrayList<Monitoring>();
        miscEarthquakes = new ArrayList<Earthquake>();
        Earthquake selected = null;         
        names = new String[4];
        number = new int[1];
    
    }

    /**
     * Adds a Monitoring object to an array list, to allow the
     * Collections object to access it.
     * 
     * @param  a Monitoring object
     * @return 
     */
    public void addMonitoring(Monitoring monitor) {
        monitoring.add(monitor);
    }
    
    /**
     * Adds user created Earthquake objects to miscEarthquakes collection.
     * This will store the object, allowing the user to call the addtoObservatory method
     * to specify the earthquake and store it in a particular observatory.
     * 
     * @param  an Earthquake object
     * @return 
     */
    public void addEarthquake(Earthquake event) {
        miscEarthquakes.add(event);
    }
    
     /**
     * Prints all observatory objects stored in the array list to the console.
     * 
     * @param
     * @return 
     */
    public void ListAllObservatories() {
        monitor.ListAllObservatories();
    }
    
    /**
     * Prints all earthquake objects stored in the array list to the console.
     * 
     * @param
     * @return 
     */
    public void printAllEarthquakes() {
        for (Earthquake event: miscEarthquakes) {
            System.out.println(event.showName());
        }
    }
    
     /**
     * Creates an observatory by creating an array of string values,
     * asks the user to input a value for each observatory option, 
     * stores these in the array. It then constructs an observatory object
     * referencing the array values, adding it to the Monitor object's array list.
     * 
     * 
     * @param 
     * @return 
     */ 
    public void createObservatory() {
     String[] names = new String[4];
        
     System.out.println("Please enter a name for your Observatory");
     System.out.print("> ");
     names[0] = reader.nextLine().trim();
        
     System.out.println("Please enter the country the Observatory is located in");
     System.out.print("> ");
     names[1] = reader.nextLine().trim();
        
     System.out.println("Please enter the year the Observatory was founded");
     System.out.print("> ");
     names[2] = reader.nextLine().trim();
    
     System.out.println("Please enter the area in square meters the Observatory covers");
     System.out.print("> ");
     names[3] = reader.nextLine().trim();
      
     monitor.addObservatory(new Observatory(names[0], names[1], names[2], names[3]));
     System.out.println("Observatory created! You are now back at the main menu");
     System.out.println("");
    }
    
    /**
     * Creates an earthquake by creating an array of string values,
     * and a singular integer array for magnitude. It asks the user to input 
     * a value for each observatory option, storing these in the appropriate array. 
     * 
     * It then constructs an earthquake object referencing the array values, 
     * adding it to the Monitor object's array list.
     * 
     * 
     * @param 
     * @return 
     */
    public void createEarthquake(){  
     System.out.println("Please enter a name for your Earthquake");
     System.out.print("> ");
     names[0] = reader.nextLine().trim();
        
     System.out.println("Please enter a latitude value for your Earthquake");
     System.out.print("> ");
     names[1] = reader.nextLine().trim();
        
     System.out.println("Please enter a longitude value for your Earthquake");
     System.out.print("> ");
     names[2] = reader.nextLine().trim();
    
     System.out.println("Please enter the year the Earthquake occured");
     System.out.print("> ");
     names[3] = reader.nextLine().trim();
     
     // This method catches any incorrect user input with an exception, to ensure it is
     // a string. If it isn't, it ends the method and asks the user to try again.
     // It then checks to see if the input is correct, and if so, creates the earthquake.
     System.out.println("Please enter the magnitude of the Earthquake occured");
     System.out.print("> ");
     try {
         number[0] = intReader.nextInt();
     } catch(InputMismatchException e) {
          System.out.println("Please enter integer values only!");
          System.out.println("You are now back at the main menu");
          System.out.println("Type 'earthquake' if you wish to try again");
          System.out.println("");
          number[0] = 0;
          intReader.nextLine();
     }
     finally {
     if(number[0] != 0) {
         miscEarthquakes.add(new Earthquake(names[0], names[1], names[2], names[3], number[0]));
         System.out.println("Earthquake created! Remember to add it to an observatory");
         System.out.println("if you wish to compare it to other created earthquakes");
         System.out.println("You are now back at the main menu");
         System.out.println("");
        }
     }
    }
    
    /**
     * This method calls the findLargestAverageValue method located
     * in the Monitoring object and prints it to the console.
     * 
     * @param 
     * @return  
     */ 
    public void callLargestAverage() {
        int largestAverage = monitor.findLargestAverageValue();
        System.out.println(largestAverage);
    }
    
    /**
     * This method calls the findLargestMagnitude method located
     * in the Monitoring object and prints it to the console.
     * 
     * @param 
     * @return  
     */ 
    public void callLargestMagnitude() {
       String largestMagnitude = monitor.findLargestMagnitude();
       System.out.println(largestMagnitude);
    }
    
    /**
     * This method asks the user to enter a magnitude parameter,
     * then calls the allAboveMagnitude method located in the Monitoring object,
     * and prints the list to the console.
     * 
     * @param 
     * @return  
     */ 
    public void callAboveMagnitude() {
     System.out.print("Please enter a magnitude value");
     System.out.print("> ");
     int i = 0;
      try {
         i = intReader.nextInt();
       } 
        catch(InputMismatchException e) {
          System.out.println("Please enter integer values only!");
          System.out.println("You are now back at the main menu");
          System.out.println("Type 'above' if you wish to try again");
          System.out.println("");
          i = 0;
          intReader.nextLine();
       }
      finally {
       if (i != 0){
           monitor.allAboveMagnitude(i);
       }
    }
    }
    
    /**
     * This method allows the user to select a created earthquake from the misc
     * Earthquakes list, by asking for user input of earthquake name, looping through list
     * to see if it exists. If yes it stores the earthquake and calls chooseObservatory, if
     * not it sends user back to input and advises them to try again with correct name.
     * 
     * @param 
     * @return  
     */ 
    public void selectEarthquake() {
      System.out.println("Please enter the name of the earthquake you wish");
      System.out.println("to select, as it was originally entered");
      System.out.println("> ");
      String name = reader.nextLine();
      for (Earthquake event : miscEarthquakes) {
          if(name.equals(event.showName())) {
             selected = event;
             chooseObservatory();
            }
        }
      if(selected == null) {
          System.out.println("Earthquake is not available, please input 'add' keyword");
          System.out.println("if you wish to try again, or input 'printearth' to view");
          System.out.println("all earthquakes created");
          System.out.println("");
        }
    }
    
    /**
     * This method allows the user to select an Observatory object stored in the monitoring class.
     * The user inputs the name. The method then calls methods in the checkObservatoryName and
     * getSelected methods to determine whether the observatory exists, and if so, adds the selected 
     * Earthquake object to the selected Observatory array list. If not, a message is printed
     * and the user is taken back to the 'get input' screen.
     * 
     * @param 
     * @return  
     */ 
    public void chooseObservatory() {
     System.out.println("Please enter the name of the observatory you wish");
     System.out.println("to add your Earthquake to, as it was originally entered.");
     System.out.println("> ");
     
     String name = reader.nextLine();
     monitor.checkObservatoryName(name);
     Observatory chosen = monitor.getSelected();
     
     if (chosen == null) {
         System.out.print("");
        }
     else { 
         chosen.addEvent(selected);
         System.out.println("Earthquake has been added to the Observatory!");
         System.out.println("Please select another keyword from the menu");
         System.out.println("");
        }
    }
}
