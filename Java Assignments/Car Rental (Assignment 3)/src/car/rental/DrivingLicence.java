package car.rental;
import java.util.*;

/**
 * @author Mmillward89
 *
 *Class that stores a driver's name, licence and rental status, dates
 *of birth and issue, along with initalizing a licence number based on
 *the driver's details. Includes get/set methods, equals and hashcode.
 */
public final class DrivingLicence
{

private DriverName drivername;
private final LicenceNumber licencenumber;
private Date dateofbirth;
private Date dateofissue;
private Boolean fulllicence;
private Boolean rentalstatus;

public DrivingLicence(String firstname, String lastname, 
		Date dateofbirth, Date dateofissue, Boolean fulllicence)
{
	try
	{
	drivername = new DriverName(firstname, lastname);
	this.dateofbirth = dateofbirth;
	this.dateofissue = dateofissue;
	this.fulllicence = fulllicence;
	rentalstatus = false;
	}
	catch(IllegalArgumentException e)
	{
		System.out.println("Please check parameters provided, some were "
				+ "unable to be processed.");
	}
	
	Calendar calendar1 = Calendar.getInstance();
	calendar1.setTime(dateofissue);
	String initials = createInitials(firstname, lastname);
	licencenumber = LicenceNumber.getInstance(initials,calendar1.get(Calendar.YEAR));
}

/**
 * @return DriverName toString value
 */
public String getDriverName()
{
	return drivername.toString();
}

/**
 * @return Driver first name string value
 */
public String getFirstName()
{
	return drivername.getFirstName();
}

/**
 * @return Driver last name string value
 */
public String getLastName()
{
	return drivername.getLastName();
}

public Date getDateofBirth()
{
	return dateofbirth;
}

 public LicenceNumber getLicenceNumber()
{
	return licencenumber;
}

public Date getDateofIssue()
{
	return dateofissue;
}

public Boolean getFullLicence()
{
	return fulllicence;
}

public Boolean getRentalStatus()
{
	return rentalstatus;
}

public void setDateofIssue(Date dateofissue)
{
	this.dateofissue = dateofissue;
}

public void setFullLicence(Boolean fulllicence)
{
	this.fulllicence = fulllicence;
}

public void setRentalStatus(Boolean rentalstatus)
{
	this.rentalstatus = rentalstatus;
}

public String createInitials(String firstname, String lastname)
{
	String initials = firstname.substring(0,1) + lastname.substring(0,1);
	return initials;	
}

public String toString()
{
	return drivername.toString() + " d.o.b. = " + dateofbirth.toString()
			+ " d.o.i = " + dateofissue.toString() + " full licence status = " + fulllicence
			+ " licence number = " + licencenumber.toString();
}

public boolean equals(Object rhs)
{
	if(this == rhs)
	{
		return true;
	}
	
	if(!(rhs instanceof DrivingLicence))
	{
		return false;
	}
	
	DrivingLicence d = (DrivingLicence) rhs;
	
	return licencenumber.equals(d.licencenumber)
			&& drivername.equals(d.drivername)
			&& dateofbirth.equals(d.dateofbirth)
			&& dateofissue.equals(d.dateofissue)
			&& fulllicence == d.fulllicence;
}

public int hashCode()
{
	int hc = 7;
	
	hc = 14 * hc
			 + licencenumber.hashCode();
	
	hc = 14 * hc
			 + drivername.hashCode();
	
	hc = 14 * hc
			 + dateofbirth.hashCode();
	
	hc = 14 * hc
			 + dateofissue.hashCode();
	
	hc = 14 * hc
			 + (fulllicence ? 1 : 0);
	
	return hc;
}

}