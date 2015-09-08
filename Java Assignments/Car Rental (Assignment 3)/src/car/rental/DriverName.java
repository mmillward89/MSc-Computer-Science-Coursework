package car.rental;

public final class DriverName
{

private final String firstname;
private final String lastname;
private final String strrep;

public DriverName(String firstname, String lastname)
{
	if(!(firstname instanceof String) || !(lastname instanceof String))
	{
		throw new IllegalArgumentException("Please provide valid "
				+ "string parameters.");
	}
	
	this.firstname = new String(firstname);
	this.lastname = new String(lastname);
	this.strrep = new String(firstname + "" + lastname);
}

public String getFirstName()
{
	return new String(firstname);
}

public String getLastName()
{
	return new String(lastname);
}

public String toString()
{
	return new String(strrep);
}

public static DriverName valueOf(String drivername)
{
	if(!(drivername instanceof String))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "string parameter.");
	}
	
	final String[] parts = drivername.split(" ");
	
	final String firstname = parts[0].equals("null")
			? null
			: parts[0];
	final String lastname = parts[1];
	
	return new DriverName(firstname, lastname);
}
}