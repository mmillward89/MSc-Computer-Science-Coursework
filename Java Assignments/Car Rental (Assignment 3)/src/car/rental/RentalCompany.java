package car.rental;
import java. util.*;

/**
 * @author Mmillward89
 *
 *Singleton class that contains all methods to store, organize, issue and
 * cancel rental contracts, as well as functionality to check for available cars.
 * All checks  made on whether a rental contract can go ahead are made 
 * in this class.
 */
public final class RentalCompany 
{
	private static final RentalCompany INSTANCE = new RentalCompany();
	private List<Car> cars;
	private List<RentalContract> rentalcontracts;
	
	private RentalCompany()
	{
		cars = new ArrayList<Car>();
		rentalcontracts = new ArrayList<RentalContract>();
	}
	
public static void main(String[] args)
{
	RentalCompany rentalcompany = RentalCompany.getInstance();
	
	for(int i=0; i<20; i++)
	{
		Car car = new SmallCar();
		rentalcompany.addCar(car);
	}
	
	for(int i=0; i<10; i++)
	{
		Car car = new LargeCar();
		rentalcompany.addCar(car);
	}
}

/**
 * @return the singleton class RentalCompany
 */
public static RentalCompany getInstance()
{
	return INSTANCE;
}
	
/**
 * @return hash set of all cars stored that are currently rented
 */
public <E> Collection<Car> getRentedCars()
{
	Collection<Car> temporary = new HashSet<Car>();
	for(Car car : cars)
	{
		if(car.getRentalStatus() == true)
		{
			temporary.add(car);
		}
	}
	
	return temporary;
}

/**
 * Looks through all cars and returns an integer value 
 * of all cars that are available of the type provided by the 
 * parameter.
 * 
 * @param Object implementing the Car interface
 * @return integer value of all cars not rented
 */
public int availableCars(Car chosencar)
{	
	if(!(chosencar instanceof Car))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "car parameter.");
	}
	
	int i = 0;
	int j = 0;
	
	for(Car car: cars)
	{
		boolean b = car.getRentalStatus();
		
		if(b == false)
		{
			if(car instanceof LargeCar)
			{
				i++;
			}
			else
			{
				j++;
			}
		}
	}
	
	if(chosencar instanceof LargeCar)
	{
		return i;
	}
	else
	{
		return j;
	}
}

/**
 * Looks at available cars and rental contracts to determine that 
 * the driver specified is renting an available car. The car is 
 * returned if so, otherwise a message explaining why the car could 
 * not be found.
 * 
 * @param DrivingLicence object
 * @return Car object that the driver is renting
 */
public Car getCar(DrivingLicence drivinglicence)
{
	if(!(drivinglicence instanceof DrivingLicence))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "driving licence parameter.");
	}
	
	Car car = cars.get(0);
	boolean defaultremoved = false;
	
	if(drivinglicence.getRentalStatus() == false)
	{	
		System.out.println("Car could not be found - first car available has been returned.");
		return car;
	}
			
	for(RentalContract rentalcontract : rentalcontracts)
	{
		DrivingLicence d = rentalcontract.getDrivingLicence();
			
		if(d.equals(drivinglicence))
		{
			car = rentalcontract.getCar();		
			defaultremoved = true;
		}		
	}
	
	
	if(defaultremoved != true)
	{	
		System.out.println("Car could not be found - first car available has been returned.");
	}
	
		return car;
}

/**
 * Calls various internal methods to determine whether the licence and 
 * car type are available and pass all checks. If so, a contract is created 
 * and the licence and car modified. The user is informed of all problems or 
 * actions that are taken.
 * 
 * @param DrivingLicence object
 * @param String value representing type of car wanted
 * @return true or false determing whether contract was created
 */
public boolean issueCar(DrivingLicence drivinglicence, String typeofcar)
{
	if(!(drivinglicence instanceof DrivingLicence) || !(typeofcar instanceof String) )
	{
		throw new IllegalArgumentException("Please provide valid "
				+ "parameter types");
	}
	
	boolean licencestatus = checkLicenceStatus(drivinglicence);
	
	if(licencestatus == false)
	{
		return false;
	}
	
	String type = checkType(typeofcar);
	
	if(type.equals("none"))
	{
		return false;
	}	
	
	Car car = findaCar(type);
	
	if(car == null)
	{
		return false;
	}
	
	boolean timestatus = checkTimeStatus(drivinglicence, car);
	//Call methods within the class to check status of each variable.

	if(timestatus == true)
	{
		RentalContract rentalcontract = new RentalContract(drivinglicence, car);
		rentalcontracts.add(rentalcontract);
		drivinglicence.setRentalStatus(true);
		car.setRentalStatus(true);
		System.out.println("A rental contract has been added with the specified"
				+ " driving licence and car.");
		return true;
	}
	
//Ends the method - all information on why the contract couldn't be created
//is conveyed in the methods
	
	return false;
}

/**
 * Checks that the licence provided is full and isn't already renting 
 * a car
 * 
 * @param DrivingLicence object
 * @return true if checks pass
 */
private boolean checkLicenceStatus(DrivingLicence drivinglicence)
{
	
	boolean canrent = true;
	
	if(drivinglicence.getFullLicence() != true)
	{
		System.out.println("Driver could not be added, not a full driver's licence.");
		canrent = false;
	}
	
	if(drivinglicence.getRentalStatus() != false)
	{
		System.out.println("Driver could not be added, already renting a car.");
		canrent = false;
	}
	
	return canrent;
}

/**
 * Simple method that determines that the user provided car type 
 * is valid.
 * 
 * @param typeofcar string value
 * @return typeofcar string value
 */
private String checkType(String typeofcar)
{	
	if(typeofcar.equalsIgnoreCase("large"))
	{
		return "large";
	}
	else if(typeofcar.equalsIgnoreCase("small"))
	{
		return "small";
	}
	else
	{
		System.out.println("Type could not be found.");
		return "none";	
	}
}

/**
 * Returns a car if one of the requested type is available, has not 
 * already been rented and has a full tank of petrol
 * 
 * @param typeofcar string value
 * @return Car object
 */
private Car findaCar(String typeofcar)
{	
	for(Car car : cars)
	{
		if(car.getRentalStatus() == false && car.isTankFull() == true)
		{
			if((typeofcar.equalsIgnoreCase("large") && car instanceof LargeCar)
				|| (typeofcar.equalsIgnoreCase("small") && car instanceof SmallCar))
				{
					return car;
				}
		}
	}
	
	System.out.println("A car of the specified type was not available to rent.");
	return null;	
}

/**
 * Determines that the licence date of issue and date of birth are 
 * appropriate of renting the type of car requested.
 * 
 * @param DrivingLicence object
 * @param Car object
 * @return true if date checks pass
 */
private boolean checkTimeStatus(DrivingLicence drivinglicence, Car car)
{
	boolean canrent = true;
	Calendar currentdatecal = Calendar.getInstance();
	Calendar birthdatecal = Calendar.getInstance();
	Calendar dateofissuecal = Calendar.getInstance();
	
	birthdatecal.setTime(drivinglicence.getDateofBirth());
	dateofissuecal.setTime(drivinglicence.getDateofIssue());

	if(car instanceof SmallCar)
	{
		if(currentdatecal.get(Calendar.YEAR) - birthdatecal.get(Calendar.YEAR) < 20)
		{
			System.out.println("Car could not be rented - driver must be "
					+ "at least 20 years old to rent this type of car.");
			canrent = false;
		}
		
		if(currentdatecal.get(Calendar.YEAR) - dateofissuecal.get(Calendar.YEAR) < 1)
		{
			System.out.println("Car could not be rented - licence must be at least "
					+ "1 year old to rent this type of car.");
			canrent = false;
		}
	}
	
	else
	{
		if(currentdatecal.get(Calendar.YEAR) - birthdatecal.get(Calendar.YEAR) < 25)
		{
			System.out.println("Car could not be rented - driver must be "
					+ "at least 25 years old to rent this type of car.");
			canrent = false;
		}
		
		if(currentdatecal.get(Calendar.YEAR) - dateofissuecal.get(Calendar.YEAR) < 5)
		{
			System.out.println("Car could not be rented - licence must be at least "
					+ "5 years old to rent this type of car.");
			canrent = false;
		}
	}
	
	
	return canrent;
}

/**
 * Determines that there is a rental contract between the driving 
 * licence and car, and if so removes it and changes both object's 
 * statuses.
 * 
 * @param DrivingLicence object
 * @return integer determing how much fuel the car requires
 */
public int terminateRental(DrivingLicence drivinglicence)
{
	if(!(drivinglicence instanceof DrivingLicence))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "driving licence parameter.");
	}
	
	Car car = cars.get(0);
	
	for(RentalContract rentalcontract : rentalcontracts)
	{
		int i = 0;
		DrivingLicence d = rentalcontract.getDrivingLicence();
		
		if(d.equals(drivinglicence))
		{
			car = rentalcontract.getCar();
			car.setRentalStatus(false);
			drivinglicence.setRentalStatus(false);
			
			System.out.println("Contract has been terminated.");
			
			int fuelneeded = checkFullTank(car);
			
			if(fuelneeded != 0)
			{
				System.out.println(fuelneeded + " litres of fuel are liable"
						+ " to the renter of this car.");
			}
			
			rentalcontracts.remove(i);
			return fuelneeded;	
		}
		
		i++;
	}
	
		System.out.println("Licence could not be found - nothing to return.");
		return 0;

}

/**
 * Internal method determing how much fuel the car needs to fill up.
 * 
 * @param Car object
 * @return integer value of fuel needed
 */
private int checkFullTank(Car car)
{
	if(car.isTankFull() == true)
	{
		return 0;
	}
	else
	{
		return car.getLitreCapacity() - car.getFuelinTank();
	}
}

/**
 * @param car added to Car list
 */
public void addCar(Car car)
{
	if(!(car instanceof Car))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "car parameter.");
	}
	
	cars.add(car);
}

/**
 * @param rentalcontract added to RentalContract list
 */
public void addContract(RentalContract rentalcontract)
{
	if(!(rentalcontract instanceof RentalContract))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "rental contract parameter.");
	}
	
	rentalcontracts.add(rentalcontract);
}

/**
 * @param integer determining which contract to remove
 */
public void removeContract(int a)
{
	if(!((Integer) a instanceof Integer))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "integer parameter.");
	}
	
	rentalcontracts.remove(a);
}

/**
 * @param integer determining which car to remove
 */
public void removeCar(int a)
{
	if(!((Integer) a instanceof Integer))
	{
		throw new IllegalArgumentException("Please provide a valid "
				+ "integer parameter.");
	}
	
	cars.remove(a);
}

}

