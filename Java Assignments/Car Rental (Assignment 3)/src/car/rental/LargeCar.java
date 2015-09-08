package car.rental;

public final class LargeCar extends AbstractCar
{

public LargeCar()
{
	super();
	setLitreCapacity(60);
	setFuelinTank(60);
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
		System.out.println("Drive not taken, conditions not met");
		return 0;
	}
	else
	{
		int fuelused = 0;
		int journeyremainder = kilometres - 50;
		
			if(journeyremainder > 0)
			{
				journeyremainder = journeyremainder/15;
				if(journeyremainder < 1){journeyremainder = 1;}
				fuelused = journeyremainder + 5;
			}
			else
			{
				fuelused = kilometres/10;
				if(fuelused < 1){fuelused = 1;}
			}
				
		int remainingfuel = fuelintank - fuelused;
		setFuelinTank(remainingfuel);
		System.out.println("Car driven. " + fuelused + " litres of fuel consumed.");
		return remainingfuel;
	}
}	

public String toString()
{
	return super.toString() + ", type = Large Car";
}

public boolean equals(Object rhs)
{
	if(this == rhs)
	{
		return true;
	}
	
	if(!(rhs instanceof LargeCar))
	{
		return false;
	}
	
	LargeCar l = (LargeCar) rhs;
	
	return l.getRegistrationNumber().equals(getRegistrationNumber())
			&& l.getLitreCapacity() == getLitreCapacity();
}

public int hashCode()
{
	int hc = 18;
	
	hc = 35 * hc
			 + getRegistrationNumber().hashCode();
	
	hc = 35 * hc
			+ getLitreCapacity();
	
	return hc;
}

}
