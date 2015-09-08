import java.io.*;
import java.util.*;

/**
 * The Start class contains the main method and menu loop to start the Library
 * program.
 * 
 * @author (Mark Millward) 
 * @version (1.0)
 */
public class Start
{
   private char ch;
   private Library library;
   private Scanner reader;
   /**
    * Main method - creates and starts the Start object.
    * 
    *     
    */
   public static void main (String[] args) throws FileNotFoundException
   {
      Start start = new Start();
      start.Menu();
   }
   
   /**
    * Constructor for Start object - creates a library object and sets up a
    * scanner to read user input.
    * 
    *     
    */
   public Start() throws FileNotFoundException
   {
      reader = new Scanner(System.in);
      library = new Library();
      ch = 'a';
   }
   
   /**
    * Main menu loop - reads user input and calls the appropriate method from
    * the library class.
    * 
    *     
    */
   private void Menu() throws FileNotFoundException
   {
      library.ReadAll();
      printMenu();
      ch = reader.next().charAt(0);
      reader.nextLine();
      library.setCh(ch);
      while (ch != 'f')
      {
        switch(ch)
        {
            case 'b':   library.printallBooks();
                        break;
            case 'u':   library.printallUsers();
                        break;
            case 'i':   library.checkIfBorrowed();
                        break;
            case 'r':   library.checkIfBorrowed();
                        break;
            default:    System.out.println("Invalid entry, please try again.");
        }
        printMenu();
        ch = reader.next().charAt(0);
        reader.nextLine();
        library.setCh(ch);
      }
      System.out.println("");
      System.out.println("Bye for now");
   }
   
   /**
    * Prints the menu options for the user to reference.
    * 
    *    
    */
   private void printMenu()
   {
       System.out.println("");
       System.out.println("MENU");
       System.out.println("----");
       System.out.println("Please type character as seen in order to select an action");
       System.out.println("");  
       System.out.println("f: Finish");
       System.out.println("b: Display all books in library");
       System.out.println("u: Display all users registered to library");
       System.out.println("i: Update when a book is issued");
       System.out.println("r: Update when a book is returned");  
       System.out.println("");
   }
   
   /**
    * Returns the user input character.
    * 
    * @return character value
    *     
    */
   public char getCh()
   {
       return ch;
   }
}