package car.rental;

/**
 * @author Mmillward89
 * 
 * Abstract implementation of the Car interface that implements
 * get and set methods, the addFuel method function, and initializes
 * the registration number and rentalstatus of the car.
 *
 */
public abstract class AbstractCar implements Car {
	
	private final RegistrationNumber registrationnumber;
	private int litrecapacity;
	private int fuelintank;
	private boolean rentalstatus;

	public AbstractCar()
	{
		this.registrationnumber = RegistrationNumber.getInstance();
		rentalstatus = false;
	}

public int addFuel(int fuel)
{
	if(!((Integer) fuel instanceof Integer))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "integer parameter.");
	}
	
	if(rentalstatus == false)
	{		
		System.out.println("Could not add fuel as car has not been rented.");
		return 0;
	}
	else
	{
	int totalfuel = fuelintank + fuel;
	if(totalfuel > litrecapacity)
	{
		int difference = totalfuel - litrecapacity;
		fuelintank = litrecapacity;
		int fueladded = fuel - difference;
		return fueladded;
	}
	else
	{
		fuelintank += fuel;
		return fuel;
	}
	}
}

public boolean isTankFull()
{
	if(fuelintank == litrecapacity)
	{
		return true;
	}
	return false;
}

public boolean getRentalStatus()
{
	return rentalstatus;
}

public RegistrationNumber getRegistrationNumber()
{
	return registrationnumber;
}

public int getFuelinTank()
{
	return fuelintank;
}

public int getLitreCapacity()
{
	return litrecapacity;
}
	
public void setFuelinTank(int fuelintank)
{
	if(!((Integer) fuelintank instanceof Integer))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "integer parameter.");
	}
	
	this.fuelintank = fuelintank;
}

public void setLitreCapacity(int capacity)
{
	if(!((Integer) capacity instanceof Integer))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "integer parameter.");
	}
	
	litrecapacity = capacity;
}
	
public void setRentalStatus(boolean isrented)
{
	if(!((Boolean) isrented instanceof Boolean))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "boolean parameter.");
	}
	
	rentalstatus = isrented;
}
	
public String toString()
{
	return "Registration number = " + registrationnumber.toString()
	+ ", rental status = " + rentalstatus;
}

}


