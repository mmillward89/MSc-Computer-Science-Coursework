package car.rental;

/**
 * @author Mmillward89
 *
 *Implements the Car interface and AbstractCar class. Sets litre capacity,
 *of fuel tank and fills it up. Implements drive method that converts kilometers
 *driven into fuel consumed at the expected method for small cars. Equals,
 *hashcode and toString are also overridden.
 */
public final class SmallCar extends AbstractCar
{

public SmallCar()
{
	super();
	setLitreCapacity(49);
	setFuelinTank(49);
}				

public int drive(int kilometres)
{
	if(!((Integer) kilometres instanceof Integer))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "integer parameter.");
	}
	
	int fuelintank = getFuelinTank();
	if(fuelintank <= 0 || getRentalStatus() == false)
	{
		System.out.println("Drive not taken, conditions not met.");
		return 0;
	}
	else
	{
		int fuelused = kilometres/20;
		if(fuelused < 1){fuelused = 1;}
		int remainingfuel = fuelintank - fuelused;
		setFuelinTank(remainingfuel);
		System.out.println("Car driven. " + fuelused + " litres of fuel consumed.");
		return remainingfuel;
	}	
}

public String toString()
{
	return super.toString() + ", type = Small Car";
}

public boolean equals(Object rhs)
{
	if(this == rhs)
	{
		return true;
	}
	
	if(!(rhs instanceof SmallCar))
	{
		return false;
	}
	
	SmallCar s = (SmallCar) rhs;
	
	return s.getRegistrationNumber().equals(getRegistrationNumber())
			&& s.getLitreCapacity() == getLitreCapacity();
}

public int hashCode()
{
	int hc = 26;
	
	hc = 13 * hc
			 + getRegistrationNumber().hashCode();
	
	hc = 13 * hc
			+ getLitreCapacity();
	
	return hc;
}

}


