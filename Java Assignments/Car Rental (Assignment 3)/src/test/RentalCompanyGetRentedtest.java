package test;

import car.rental.*;
import java.util.*;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import car.rental.LargeCar;

public class RentalCompanyGetRentedtest {

	private LargeCar car1;
	private LargeCar car2;
	private LargeCar car3;
	private LargeCar car4;
	private LargeCar car5;
	private SmallCar car6;
	private SmallCar car7;
	private SmallCar car8;
	private SmallCar car9;
	private SmallCar car10;
	private RentalCompany rentalcompany;
	
	@Before
	public void setUp() throws Exception {
		car1 = new LargeCar();
		car2 = new LargeCar();
		car3 = new LargeCar();
		car4 = new LargeCar();
		car5 = new LargeCar();
		
		car6 = new SmallCar();
		car7 = new SmallCar();
		car8 = new SmallCar();
		car9 = new SmallCar();
		car10 = new SmallCar();
		
		rentalcompany = RentalCompany.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() 
	{
		
		ArrayList<Car> list = new ArrayList<Car>();
		list = (ArrayList<Car>) rentalcompany.getRentedCars();
		
		//create a list and check that without cars a list of
		//size zero is returned
		assertEquals(0, list.size());
		
		rentalcompany.addCar(car1);
		rentalcompany.addCar(car2);
		rentalcompany.addCar(car3);
		rentalcompany.addCar(car4);
		rentalcompany.addCar(car5);
		rentalcompany.addCar(car6);
		rentalcompany.addCar(car7);
		rentalcompany.addCar(car8);
		rentalcompany.addCar(car9);
		rentalcompany.addCar(car10);
		
		car1.setRentalStatus(true);
		car3.setRentalStatus(true);
		car5.setRentalStatus(true);
		car7.setRentalStatus(true);
		car9.setRentalStatus(true);
		
		//check that the method doesn't return nothing.
		assertNotNull(rentalcompany.getRentedCars());
		
		car1.setRentalStatus(false);
		car3.setRentalStatus(false);
		car5.setRentalStatus(false);
		car7.setRentalStatus(false);
		car9.setRentalStatus(false);
		
		list = (ArrayList<Car>) rentalcompany.getRentedCars();
		
		//Check that the return is zero when cars are reset.
		assertEquals(0, list.size());
		
		car1.setRentalStatus(true);
		car3.setRentalStatus(true);
		car5.setRentalStatus(true);
		car7.setRentalStatus(true);
		car9.setRentalStatus(true);
		
		list = (ArrayList<Car>) rentalcompany.getRentedCars();
		
		//List returned is appropriate size based on values set.
		assertEquals(5, list.size());
	}

}
