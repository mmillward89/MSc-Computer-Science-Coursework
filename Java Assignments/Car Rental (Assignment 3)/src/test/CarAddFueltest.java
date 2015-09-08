package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import car.rental.*;

public class CarAddFueltest {
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
		//test car won't add fuel if not rented
		assertEquals(0, car1.addFuel(30));
		
		car1.setRentalStatus(true);
		car1.drive(50);
		int a = car1.addFuel(10);
		car1.drive(50);
		int b = car1.addFuel(5);
		
		//Check car will only add fuel to full capacity if given
		//right amount and too much.
		
		assertEquals(a, b);
		
		car2.setRentalStatus(true);
		car2.drive(50);
		a = car1.addFuel(10);
		car2.drive(50);
		b = car1.addFuel(5);
		
		assertEquals(a, b);
	}

}
