import java.io.*;

/**
 * The printer class contains methods for the library to print out information
 * to the user, and send return messages to users.
 * 
 * @author (Mark Millward) 
 * @version (1.0)
 */
public class Printer
{
   private PrintWriter outFile;
    
   /**
    * Constructor for objects of class Printer - initializes PrintWriter
    * for messages to users.
    * 
    * 
    */
   public Printer() throws FileNotFoundException
   {
       outFile = new PrintWriter("/Users/Mmillward89/Desktop/SampleOutputFile.txt");
   }
   
   /**
    * Prints the main menu prompt
    * 
    * @param  
    * @return     
    */
   public static void printMenu()
   {
    System.out.println("MENU");
    System.out.println("----");
    System.out.println("Please type character as seen in order to select an action");
    System.out.println("");  
    System.out.println("f: Finish");
    System.out.println("b: Display all books in library");
    System.out.println("u: Display all users registered to library");
    System.out.println("i: Update when a book is issued");
    System.out.println("r: Update when a book is returned");  
   }
   
   /**
    * Prints a prompt asking the user to type book name and author
    * 
    * @param  
    * @return     
    */
   public void BookPrompt()
   {
       System.out.println("Please type the name of the book"); 
       System.out.println("followed by the author's name in the following format:");
       System.out.println("Java Gently Judith Bishop");
       System.out.println("");
   }
    
   /**
    * Prints a prompt asking the user to type in a username.
    * 
    * @param  
    * @return     
    */
   public void printUserPrompt()
   {
       System.out.println("Please enter your username in the format");
       System.out.println("First name space last name");
       System.out.println("e.g. John Smith");
       System.out.println("");
   }
   
   /**
    * Prints a prompt to let user know their input does not match
    * information in the library system.
    * 
    * @param  
    * @return     
    */
   public void printInputNotFound()
   {
       System.out.println("Input not found.");
       System.out.println("Please refer to 'print all books/users' functions");
       System.out.println("if you wish to check that your input is currently stored.");
       System.out.println("");
    }
   
    /**
    * Prints a prompt to let the user know the book they want
    * is currently on loan.
    * 
    * @param  
    * @return     
    */
   public void printCurrentlyLoaned()
   {
       System.out.println("This book is currently on loan");
       System.out.println("We will send the user a reminder");
       System.out.println("to return the book as soon as possible.");
       System.out.println("");
   }
   
   /**
    * Prints a reminder to the user that specified book
    * is in demand and they need to return it.
    * 
    * @param  
    * @return     
    */
   public void printReminder(String book)
   {
        outFile.println(book + "is in demand");
        outFile.println("Please return it as soon as possible");
        System.out.println("");
   }
}
