
/**
 * Abstract class Person - used for book and user classes
 * to store first and last name information.
 * 
 * @author (Mark Millward)
 * @version (1.0)
 */
public abstract class Person
{
    // instance variables - replace the example below with your own
    protected String FirstName;
    protected String LastName;
    
    /**
     * Constructor for Person class 
     * 
     */
    public Person()
    {
        FirstName = "none";
        LastName = "none";
    }
    
    /**
     * Returns string value stored in First Name
     * 
     * @param  
     * @return String, first name      
     */
    public String getFirstName()
    {
        // put your code here
        return FirstName;
    }
    
    /**
     * Returns string value stored in Last Name
     * 
     * @param  
     * @return String, last name      
     */   
    public String getLastName()
    {
        // put your code here
        return LastName;
    }
    
    /**
     * Takes string input to change value stored in First Name
     * 
     * @param  String, first name
     * @return       
     */
    public void setFirstName(String name)
    {
        FirstName = name;    
    }
   
    /**
     * Takes string input to change value stored in Last Name
     * 
     * @param  String, last name
     * @return       
     */
    public void setLastName(String name)
    {
        LastName = name;    
    }
}
