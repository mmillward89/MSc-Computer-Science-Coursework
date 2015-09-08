package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import car.rental.*;

public class RentalCompanyAvailableCarstest {
	
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
		int i = rentalcompany.availableCars(car1);
		System.out.println(i);
		
		//Value is zero before cars are added
		assertEquals(0, i);
		
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
		
		//check both for correct values based on set properties
		int a = rentalcompany.availableCars(car1);
		System.out.println(a);
		assertEquals(2, a);
		
		int b = rentalcompany.availableCars(car6);
		System.out.println(b);
		assertEquals(3, b);
		
		car1.setRentalStatus(false);
		car3.setRentalStatus(false);
		car5.setRentalStatus(false);
		car7.setRentalStatus(false);
		car9.setRentalStatus(false);
		
		//cars become available after reset
		int c = rentalcompany.availableCars(car1);
		System.out.println(c);
		assertEquals(5, c);
		
		int d = rentalcompany.availableCars(car6);
		System.out.println(d);
		assertEquals(5, d);
	}

}
