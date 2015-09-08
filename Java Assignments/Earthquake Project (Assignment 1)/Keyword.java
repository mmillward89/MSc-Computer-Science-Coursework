
/**
 * A simple string object that stores a keyword that a user has inputted,
 * is called by the MonitoringIO to confirm validity, and contains methods
 * to return its value, and confirm whether it is an unknown word.
 * 
 * @author (Mark Millward) 
 * @version (1.0)
 */
public class Keyword
{
    // instance variables - replace the example below with your own
  private String keyword; 

 /**
 * Constructor for objects of class Keyword. 
 * Creates a string variable to store user input.
 */
 public Keyword(String keyword)
 {
    this.keyword = keyword;
 }
    
 /**
  * Returns true if the keyword stored is null.
  * 
  * @return boolean true/false
  */
 public boolean isUnknown() {
      return (keyword == null);   
 }
 
  /**
  * Returns the string value stored in keyword.
  * 
  * @return keyword
  */
 public String getKeyword() {
    return keyword;
 }
}
