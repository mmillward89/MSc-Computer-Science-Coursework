
/**
 * Creates a user class to store Library users, first and last name,
 * and a list of books registered on loan to the user.
 * 
 * @author (Mark Millward) 
 * @version (1.0)
 */
public class User extends Person implements Comparable<User>
{
    // instance variables - replace the example below with your own
    private String[] loans = new String[]{"none", "none", "none"};
    

    /**
     * Constructor for objects of class User. Calls Person class to store
     * first and last names.
     * 
     */
    public User(String FirstName, String LastName)
    {
        // initialise instance variables
        super();
        setFirstName(FirstName);
        setLastName(LastName);
    }

    /**
     * Converts the user name into a string - first name, last name
     * 
     * @param  
     * @return  String, user name     
     */
    public String toString()
    {
        String space = " ";
        return FirstName + space + LastName;
    }
    
    /**
     * Compares user input of a username with the to string version
     * of the user object to confirm the two match.
     * 
     * @param  User input of a user name
     * @return    
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
     * Takes input of book information and checks the user information
     * to check whether the user has the book out or not.
     * 
     * @param   String, book information  
     * @return     
     */
    public boolean checkIfLoaned(String book)
    {
        for(int i=0; i<loans.length; i++)
        {
            if(loans[i].equals(book))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
    * Checks list of books registered to user, returns an integer value
    * representing how many books the user currently has out.
    * 
    * @param  
    * @return integer books on loan     
    */
    public int numberOnLoan()
    {
        int a = 0;
        for(int i=0; i<loans.length; i++)
        {
            if(!loans[i].equals("none"))
            {
                a++;
            }
        }
        return a;
    }
    
    /**
     * After book and user information has been confirmed,
     * takes book information, confirms whether user already has three books out.
     * If yes, prints a message, if no adds book to list and prints
     * another message to let them know it's been added.
     * 
     * 
     * @param   String, book information
     * @return     
     */
    public void addBooktoList(String book)
    {
        //Confirms whether the book can be issued or not
        boolean found = false;
        for(int i=0; i<loans.length; i++)
        {
            if(loans[i].equals("none") && found == false)
            {
                found = true;
                loans[i] = book;
                System.out.println("");
                System.out.println("This book has been issued.");
                System.out.println("");
            }
        }
        
        if(!loans[2].equals("none") && found == false)
        {
             System.out.println("");
             System.out.println("You currently have three books on loan,");
             System.out.println("no more than three can be loaned at any given time.");
             System.out.println("");
        }
    }
   
    /**
     * After book and user information has been confirmed,
     * takes book information, confirms that the book is loaned to the user.
     * If yes, replaces it with 'none' and prints message to user confirming this,
     * and calls method to set book object loan status.
     * If not prints another message to let them know of this.
     * 
     * @param   String, book information
     * @return     
     */
    public void removeBookFromList(String input)
    {
        boolean found = false;
        for(int i=0; i<loans.length; i++)
        {
            if(loans[i].equals(input) && found == false)
            {
                found = true;
                loans[i] = "none";
                System.out.println("");
                System.out.println("This book has been returned");
                System.out.println("");
            }
        }
        
        if(!loans[2].equals(input) && found == false)
        {
             System.out.println("");
             System.out.println("This book is not registered to this user's account");
             System.out.println("");
        }
    }
      
    /**
    * Allows user to input an object of user type, will compare it
    * to this object and return a value based on how the two match up.
    * 
    * @param  
    * @return  integer value, comparison of user input object to this onject   
    */
    public int compareTo(User user)
    
    {
        int lncmp = LastName.compareTo(user.LastName);
        if (lncmp!=0) return lncmp;
        int fncmp = FirstName.compareTo(user.FirstName);
        return fncmp;
    }
}
