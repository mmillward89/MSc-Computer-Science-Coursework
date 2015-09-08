package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import car.rental.*;

public class CarDrivetest {
	private LargeCar car1;
	private SmallCar car2;
	
	@Before
	public void setUp() throws Exception {
		car1 = new LargeCar();
		car2 = new SmallCar();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		car1.setRentalStatus(true);
		car1.setFuelinTank(0);
		
		//check that car can't drive without fuel
		assertEquals(0, car1.drive(40));
		
		car1.setFuelinTank(60);
		car1.setRentalStatus(false);
		
		//car shouldn't drive while not rented
		assertEquals(0, car1.drive(40));
		
		car1.setRentalStatus(true);
		int a = car1.drive(60);
		assertEquals(54, a);
		
		car1.addFuel(6);
		int b = car1.drive(50);
		assertEquals(55, b);
		
		car1.addFuel(5);
		int c = car1.drive(100);
		assertEquals(52, c);
		
		//Check that large car converts at appropriate rate when
		//going over and under 50 kilometres
		
		car2.setRentalStatus(true);
		int d = car2.drive(7);
		assertEquals(48, d);
		
		car2.addFuel(1);
		int e = car2.drive(70);
		assertEquals(46, e);
		
		car1.addFuel(100);
		car1.drive(900);
		System.out.println(car1.getFuelinTank());
		
		car2.addFuel(100);
		car2.drive(1000);
		System.out.println(car2.getFuelinTank());
		
		//two print messages to confirm car can drive over fuel
		//and accept negative numbers
		
	}

}
