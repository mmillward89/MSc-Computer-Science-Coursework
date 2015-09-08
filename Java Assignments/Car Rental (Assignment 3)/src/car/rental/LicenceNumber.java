package car.rental;

import java.util.*;

/**
 * @author Mmillward89
 *
 *Immutable class that uses an object factory to create and store unique
 *instances for driving licences to use as licence numbers. Overrides equals, hashcode and
 *toString.
 */
public final class LicenceNumber {
	
private static final Map<String, LicenceNumber> numbers = new HashMap<String, LicenceNumber>();
	
private final String initials;
private final int yearofissue;
private final int serialnumber;
private final String strrep;

private LicenceNumber(String initials, int yearofissue, int serialnumber, String strrep)
{
	this.initials = new String(initials);
	this.yearofissue = new Integer(yearofissue);
	this.serialnumber = new Integer(serialnumber);
	this.strrep = new String(strrep);
}

/**
 * Takes initials, a year of issue, and adds a serial number, returning a
 * a unique licencenumber from the object factory.
 *  
 * @param String initials
 * @param int yearofissue
 * @return LicenceNumber object
 */
public static LicenceNumber getInstance(String initials, int yearofissue)
{
	if(!(initials instanceof String) || !((Integer) yearofissue instanceof Integer))
	{
		throw new IllegalArgumentException("Please provide valid "
				+ "parameters.");
	}
	
	Random r = new Random();
	int serialnumber = r.nextInt(10) + 1;
	String strrep = initials + "-" + yearofissue + "-" + serialnumber;
	LicenceNumber n = numbers.get(strrep);
	if(n == null)
	{
		n = new LicenceNumber(initials, yearofissue, serialnumber, strrep);
		numbers.put(strrep, n);
	}
	return n;
}

/**
 * @return String driver initials
 */
public String getInitials()
{
	return new String(initials);
}

/**
 * @return integer year of issue
 */
public int getYearofIssue()
{
	return new Integer (yearofissue);
}

/**
 * @return randomized integer serial number, 1-10
 */
public int getSerialNumber()
{
	return new Integer (serialnumber);
}

public String toString()
{
	return new String (strrep);
}

public boolean equals(Object rhs)
{
	if(this == rhs)
	{
		return true;
	}
	
	if(!(rhs instanceof LicenceNumber))
	{
		return false;
	}
	
	LicenceNumber l = (LicenceNumber) rhs;
	return l.toString().equals(toString());
}

public int hashCode()
{
	int hc = 11;
	
	hc = 51 * hc
			 + strrep.hashCode();
	
	return hc;
}

}
