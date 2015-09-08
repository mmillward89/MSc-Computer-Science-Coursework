import java.util.Scanner;
import java.util.ArrayList;

/**
 * The MonitoringIO class prints a menu to the console that allows users
 * to input keywords to create observatory and earthquake objects. It creates
 * Keyword objects, confirms that the input matches the list of valid keywords,
 * and calls the appropriate method for the keyword.
 * 
 * The keyword checking process is contained in this class, whilst the storage
 * of monitoring, observatory and earthquake objects, as well as the methods to
 * interact with them, are stored in the Collections class, for ease of access
 * and readability.
 * 
 * @author (Mark Millward) 
 * @version (1.0)
 */
public class MonitoringIO
{
    // 
    private Scanner reader;
    private Collections collection;
    private String[] validKeywords = {
         "observatory", "earthquake", "printobs", "printearth","add", "average", 
         "largest", "above", "help", "quit"
    }; 
    
    /**
     * Main method. Creates a MonitoringIO object and calls the Start() method.
     */
    public static void main(String[] args)
    {
        MonitoringIO monitoringIO = new MonitoringIO();
        monitoringIO.Start();
    }
    
    /**
     * Constructor for objects of class MonitoringIO.
     * Creates the scanner for user input, and the collections class
     * to allow objects (monitoring, earthquakes etc.) to be stored.
     */
    public MonitoringIO()
    {
        // initialise instance variables
        reader = new Scanner(System.in);
        collection = new Collections();     
    }
    
    /**
     * Starts the program. Calls printWelcome and printMenu,
     * and starts a boolean loop that allows the user to input
     * a keyword after each previous method has been completed,
     * calling 'true', and thus ending the loop, and the program,
     * when the user enters the 'quit' keyword.
     * 
     * @param
     * @return 
     */
    public void Start()
    {
        printWelcome();
        printMenu();
        
        boolean finished = false;
        while (! finished) {
           Keyword keyword = getKeyword();
           finished = processKeyword(keyword);
        }
        System.out.println("Logging you out.");
    }
    
     /**
     * This method scans the user inputted keyword, stores it in a local variable,
     * and calls isKeyword to confirm it matches the available keywords.
     * If yes, it creates a Keyword string object containing that word,
     * if no, it creates a null Keyword object.
     * 
     * @param
     * @return 
     */
    public Keyword getKeyword() {
        String inputLine;
        String word1 = null;
        
        System.out.print("> ");
        
        inputLine = reader.nextLine().trim().toLowerCase();
        
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
        }
            
        if(isKeyword(word1)) {
           return new Keyword(word1); 
        }
        else {
            return new Keyword(null);
        }
    }
    
    /**
     * This method is called by getKeyword to confirm user input is valid.
     * It looks over each element in the array to confirm it matches, and
     * returns true if so, otherwise returning false.
     * 
     */
    private boolean isKeyword(String keyword)
    {
        for(int i = 0; i < validKeywords.length; i++) {
            if(validKeywords[i].equals(keyword))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
    
     /**
     * This method is called after the keyword has been checked for validity by getKeyword.
     * If the keyword is null, and thus isUnknown as confirmed by the Keyword object,
     * it asks the user to input a valid word. If it is known, it calls the appropriate
     * method by matching the keyword to the appropriate element in the loop.
     * 
     */
    private boolean processKeyword(Keyword keyword)
    {
      boolean Quit = false;
        
       if(keyword.isUnknown()) {
            System.out.println("Please enter a keyword from the menu. Type help if confused");
            return false;
       }
       
      String KeyWord = keyword.getKeyword();
       if (KeyWord.equals("observatory")) {
            collection.createObservatory();
       }   
        else if (KeyWord.equals("earthquake")){
            collection.createEarthquake();
       }
        else if (KeyWord.equals("printobs")) {
            collection.ListAllObservatories();
       }
        else if (KeyWord.equals("printearth")) {
            collection.printAllEarthquakes();
       }
        else if (KeyWord.equals("add")) {
            collection.selectEarthquake();
       }        
        else if (KeyWord.equals("average")) {
            collection.callLargestAverage();
       }
        else if (KeyWord.equals("largest")) {
            collection.callLargestMagnitude();
       }
        else if (KeyWord.equals("above")) {
            collection.callAboveMagnitude();
       }
        else if (KeyWord.equals("help")) {
            printMenu();
       }

        else if (KeyWord.equals("quit")) {
            Quit = true;
       }
            
      return Quit;
    }
         
    /**
     * Called once when the program is started, a welcome message printed to the console.
     * 
     */
    private void printWelcome() {
        System.out.println("Welcome to the Earthquake Project!");
        System.out.println("Please review the options below");
        System.out.println("and input the given keyword to select an option");
        System.out.println();
        System.out.println();
    }
    
    /**
     * Prints a list of keyword input options for the user to reference.
     * Can also be called by inputting the 'help' keyword.
     * 
     * @param
     * @return 
     */
    private void printMenu()
    {
        System.out.println("Create an observatory : observatory");
        System.out.println();
        System.out.println("Create an earthquake: earthquake");
        System.out.println();
        System.out.println("Add earthquake to observatory: add");
        System.out.println();
        System.out.println("View a list of all observatories created: printobs");
        System.out.println();
        System.out.println("View a list of all earthquakes created: printearth");
        System.out.println();        
        System.out.println("View largest average earthquake stored: average");
        System.out.println();
        System.out.println("View largest ever earthquake stored: largest");
        System.out.println();
        System.out.println("View all earthquakes larger than user input value: above");
        System.out.println();
        System.out.println("Close the application: quit");
        System.out.println();
        System.out.println();
    }
}