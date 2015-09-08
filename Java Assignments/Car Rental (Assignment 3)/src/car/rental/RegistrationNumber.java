package car.rental;

import java.util.*;

/**
 * @author Mmillward89
 *
 *Immutable class that uses an object factory to create and store unique
 *instances for cars to use as registration numbers. Overrides equals, hashcode and
 *toString.
 */
public final class RegistrationNumber {
	
private static final Map<String, RegistrationNumber> numbers = new HashMap<String, RegistrationNumber>();
	
private final char letter;
private final int number;
private final String strrep;

private RegistrationNumber(char letter, int number, String strrep)
{
	this.letter = new Character(letter);
	this.number = new Integer(number);
	this.strrep = new String(strrep);
}

/**
 * Creates a unique instance of randomized string of one letter and 
 * 4 digit number
 * 
 * @return RegistrationNumber object
 */
public static RegistrationNumber getInstance()
{
	Random r = new Random();
	char letter = (char)(r.nextInt(26) + 'a');
	int number = r.nextInt(9999) + 1000;
	String strrep = "" + letter + number;
	
	RegistrationNumber n = numbers.get(strrep);
	if(n == null)
	{
		n = new RegistrationNumber(letter, number, strrep);
		numbers.put(strrep, n);
	}
	return n;
}

/**
 * @return character value of registration number
 */
public char getLetter()
{
	return new Character(letter);
}

/**
 * @return integer 4 digit number of registration number
 */
public int getNumber()
{
	return new Integer(number);
}

public String toString()
{
	return new String(strrep);
}

public boolean equals(Object rhs)
{
	if(this == rhs)
	{
		return true;
	}
	
	if(!(rhs instanceof RegistrationNumber))
	{
		return false;
	}
	
	RegistrationNumber r = (RegistrationNumber) rhs;
	return r.toString().equals(toString());
}

public int hashCode()
{
	int hc = 23;
	
	hc = 17 * hc
			 + strrep.hashCode();
	
	return hc;
}

}
