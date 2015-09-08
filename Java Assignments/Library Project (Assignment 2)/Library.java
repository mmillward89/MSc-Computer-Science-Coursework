import java.io.*;
import java.util.*;

/**
 * Library class reads input file, creates book and user objects and stores 
 * each in SortedArrayLists. Contains methods for users to call to issue, return and
 * view all books and users in the library.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Library
{ 
  private char ch;
  private Scanner reader;
  private Printer printer;
  private String Input;
  private SortedArrayList<Book> bookarraylist;
  private SortedArrayList<User> userarraylist;
  private Scanner inFile;

  /**
     * Constructor for objects of class Library. 
     * Creates scanner objects to read user input and an input file, lists to store 
     * created book and user objects, and a printer object.
     */
  public Library() throws FileNotFoundException
  {
       reader = new Scanner(System.in);
       printer = new Printer();
       Input = "none";
       ch = 'a';
       bookarraylist = new SortedArrayList<Book>();
       userarraylist = new SortedArrayList<User>();
       inFile = new Scanner(new FileReader("/Users/Mmillward89/Desktop/SampleInputFile.txt"));
  }
    
    /**
    * Uses FileReader to read all book and user information from the file,
    * taking it and converting it into an appropriate Book or User object
    * and storing each.
    * 
    *      
    */
  public void ReadAll() throws FileNotFoundException
  {
      int books = inFile.nextInt();
      inFile.nextLine();
      
      for(int i=0; i<books; i++)
      {
          String title = inFile.nextLine();
          String firstname = inFile.next();
          String lastname = inFile.next();
          //method might not work here, and below. Purely to differentiate names.
          Book book = new Book(firstname, lastname, title);
          bookarraylist.SortandAdd(book);
          inFile.nextLine();
      }
     
      int users = inFile.nextInt();
      inFile.nextLine();
      
      for(int j=0; j<users; j++)
      {
          String firstname = inFile.next();
          String lastname = inFile.next();
          User user = new User(firstname, lastname);
          userarraylist.SortandAdd(user);
      }
  }
    
   /**
    * Prints all stored book objects along with a notification if the book
    * is currently on loan.
    * 
    *      
    */
  public void printallBooks()
  {
       for(int i=0; i<bookarraylist.size(); i++)
       {
           Book book = (Book) bookarraylist.get(i);
           System.out.println(book.toString());
           if(book.isOnLoan() == true)
           {
               System.out.println("(The above is currently on loan to");
               System.out.println(book.getBorrower()+")");
            }
           System.out.println("");
        }
  }
   
    /**
    * Prints all stored user objects along with a notification
    * listing how many books the user currently has on loan.
    * 
    *     
    */
  public void printallUsers()
  {
       for(int i=0; i<userarraylist.size(); i++)
       {
           User user = (User) userarraylist.get(i);
           System.out.println(user.toString());
           String space = " ";
           System.out.println("This user currently has" + space + user.numberOnLoan() + 
           space + "books on loan");
           System.out.println("");
        }
  }
    
    /**
    * Selected by menu from 'i'. Prompts user to input book information
    * and calls method to check if that input matches a book in the libary file.
    * 
    * 
    */ 
  public void checkIfBorrowed()
  {
       printer.BookPrompt();
       Input = reader.nextLine();    
       checkIfAvailable();
  }
   
   /**
    * Called after user inputs a book to check whether the book exists
    * in the book list. Depending on user input, it either
    * i: calls a method to check whether the book is currently loaned, or
    * r: asks the user to input their username in order to confirm who the book is loaned to.
    * Otherwise it prints to the user that their input does not match an available book.
    *  
    */
  private void checkIfAvailable()
  {
       boolean found = false;
       //use a for i++ loop? Create new checks?
       for(int i=0; i<bookarraylist.size(); i++)
       {
          Book book = (Book) bookarraylist.get(i); 
          boolean compare = book.equals(Input);
          if(compare == true)
          {
             found = true;
             if(ch == 'i')
             {
                 checkIfLoaned();
             }
             else if(ch == 'r')
             {
                 findUser();
             }
          }
       }
        
       if(found == false)
       {
           printer.printInputNotFound();
       }
  }
   
   /**
    * Checks each user stored to see if the user inputted book
    * is registered as on loan to that user. If yes, it prints a reminder
    * to that user to return the book, and lets the typer know of this.
    * If not calls further methods to set book loan status and ask for the user
    * to input information to.
    * 
    *      
    */
  private void checkIfLoaned()
  {
       boolean found = false;
       for(int i=0; i<userarraylist.size(); i++)
       {
         //might come as error - change user method name if so.
         User user = (User) userarraylist.get(i);
         boolean compare = user.checkIfLoaned(Input); 
         
         if(compare == true)
         {
           found = true;
           printer.printCurrentlyLoaned();
           printer.printReminder(Input); 
         }
      }
      
      if(found == false)
      {
          findUser();
      }
  }
   
   /**
    * Called to find book to set loan status. Searches each book to match
    * it with the book the user wishes to loan/return. Once found, the book
    * object's status is set to the appropriate 'loaned' or 'not loaned'.
    * 
    *    
    */
  private void findBooktoLoan()
  {
       boolean found = false;
       
       for(int i=0;i<bookarraylist.size(); i++)
      {   
            Book book = (Book) bookarraylist.get(i);
            boolean compare = book.equals(Input);
            if(compare == true)
            {
               found = true;
               if(ch == 'i')
               {
                  book.setLoanStatus("loaned"); 
               }
               else if(ch == 'r')
               {
                  book.setLoanStatus("not loaned");
               }
            }
       }
       
      if(found == false)
      {
         printer.printInputNotFound();
      }
  }
    
   /**
    * Asks the user to input their details, confirms that the user exists,
    * then depending on user input, either adds or removes book from user records.
    * If not found, it prints a message to let them know and sends them back to the main menu.
    *     
    */
  private void findUser()
  {
      printer.printUserPrompt();
      String input = reader.nextLine();
      boolean found = false;
      
      for (int i=0; i<userarraylist.size(); i++)
      {
           User user = (User) userarraylist.get(i);
           boolean compare = user.equals(input);
       
           if(compare == true)
           {
             found = true;
             //user method, edit if does not work
             if(ch == 'i')
             {
                 findBooktoLoan();
                 user.addBooktoList(Input);
                 setBooktoUser(input);
             }
             else if(ch == 'r')
             {
                 findBooktoLoan();
                 user.removeBookFromList(Input);
                 setBooktoUser("none");
             }
           }
      }
      
      if(found == false)
      {
          printer.printInputNotFound();
      }
  }
  
  private void setBooktoUser(String input)
  {
      for(int i=0;i<bookarraylist.size(); i++)
      {   
            Book book = (Book) bookarraylist.get(i);
            boolean compare = book.equals(Input);
            
            if(compare == true)
            {
                book.setBorrower(input);
            }
      }
  }
    
  /**
    * Sets character value - used to store user input character from start menu for reference.
    * 
    * @param  character   
    */
  public void setCh(char ch)
  {
       this.ch = ch;    
  }
}
