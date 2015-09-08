
/**
 * Creates an object that stores Book author name and book title information,
 * along with information on whether the book is currently on loan.
 * 
 * @author (Mark Millward) 
 * @version (1.0)
 */
public class Book extends Person implements Comparable<Book>
{
    // instance variables - replace the example below with your own
    private String title;
    private String status;
    private String borrower;
    
    /**
     * Constructor for objects of class Book. Inititalizes first and last name,
     * book title, borrower information and loan status.
     */
    public Book(String FirstName, String LastName, String title)
    {
        // initialise instance variables
        super();
        setFirstName(FirstName);
        setLastName(LastName);
        setTitle(title);
        status = "not loaned";
        borrower = "none";
    }

    /**
    * Confirms whether book is on loan or not.
    *   
    * @return  boolean, is book set to loaned status.   
    */
    public boolean isOnLoan()
    { 
     if(status.equals("loaned")){
         return true;
        }
     return false;
    }
    
    /**
    * Sets status, by another method, to loaned or not loaned. 
    * 
    * @param    String, 'loaned' or 'not loaned' in this instance     
    */
    public void setLoanStatus(String word)
    {
        status = word;
    }
    
    /**
    * Compares the string format of the book to an input to confirm they match. 
    * 
    * @param    String input, user input of a book title      
    */
    public boolean equals(String input)
    {
        if(input.equals(toString()))
        {
            return true;
        }
        return false;
    }
    
    /**
     * returns the book title
     * 
     * @return  String, book title
     */
    public String getTitle()
    {
        return title;       
    }
    
    /**
     * Takes input to change book title
     * 
     * @param  String, book title  
     */
    public void setTitle(String title)
    {
        this.title = title;    
    }
    
    /**
     * Converts the book into a string - title, author first name, author last name
     *  
     * @return  String, book information     
     */
    public String toString()
    {
        String space = " ";
        return title + space + FirstName + space + LastName;
    }
    
    /**
    * Allows user to input an object of book type, will compare it
    * to this object and return a value based on how the two match up.
    * 
    *  
    * @return  integer value, comparison of user input object to this onject   
    */
    public int compareTo(Book book)
    
    {
        int lncmp = LastName.compareTo(book.LastName);
        return lncmp;
    }
    
    /**
    * Takes a string value of the user borrowing the book and stores it.
    * 
    * @param  String, borrower name
    *     
    */
    public void setBorrower(String input)
    
    {
        borrower = input;
    }
    
    /**
    * Returns the string value stored in variable borrower.
    * 
    *   
    * @return  String, borrower name  
    */
    public String getBorrower()
    
    {
        return borrower;
    }
}
