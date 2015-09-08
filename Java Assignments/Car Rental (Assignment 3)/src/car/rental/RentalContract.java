package car.rental;

public final class RentalContract 
{

private final DrivingLicence drivinglicence;
private final Car car;

public RentalContract(DrivingLicence drivinglicence, Car car)
{
	if(!(drivinglicence instanceof DrivingLicence) || !(car instanceof Car))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "integer parameter.");
	}
	
	this.drivinglicence = drivinglicence;
	this.car = car;
}

public String getDriverName()
{
	return drivinglicence.getDriverName();
}

public DrivingLicence getDrivingLicence()
{

	return drivinglicence;
}

public Car getCar()
{
	return car;
}

}
