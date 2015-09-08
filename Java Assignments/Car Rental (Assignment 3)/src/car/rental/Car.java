package car.rental;

/**
 * @author Mmillward89
 *
 *Car interface that adds get and set methods, check for full tank,
 *addFuel and drive methods.
 *
 */

/**
 * @author Mmillward89
 *
 */
public interface Car {
	

/**
 * Takes an integer value and adds amount to fuel stored up to
 * the car's available litre capacity.
 * 
 * @param fuel
 * @return
 */
int addFuel(int fuel);

/**
 * Takes an integer amount of kilometres driven and calculates and returns
 * the amount of fuel consumed based on the car type's MPG.
 * 
 * @param kilometres
 * @return
 */
int drive(int kilometres);

/**
 * Returns true if the car's fuel tank is full.
 * 
 * @return boolean
 */
boolean isTankFull();

/**
 * @return Car RegistrationNumber
 */
RegistrationNumber getRegistrationNumber();

/**
 * Returns true if the car is currently being rented.
 * 
 * @return boolean
 */
boolean getRentalStatus();

/**
 * @return fuel in litres integer value
 */
int getFuelinTank();

/**
 * @return litre capacity of fuel tank integer value
 */
int getLitreCapacity();

/**
 * @param fuelintank adds fuel to car tank
 */
void setFuelinTank(int fuelintank);

/**
 * @param rentalstatus set to true sets car as rented
 */
void setRentalStatus(boolean rentalstatus);

/**
 * @param capacity sets car litre capacity
 */
void setLitreCapacity(int capacity);
	
}
