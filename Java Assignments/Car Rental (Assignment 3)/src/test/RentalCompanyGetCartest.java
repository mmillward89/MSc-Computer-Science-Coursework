package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import car.rental.*;

public class RentalCompanyGetCartest {
	
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
	private DrivingLicence drivinglicence;

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
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1970, 10, 21);
		Date date = calendar.getTime();

		calendar.set(1980, 10, 14);
		Date date1 = calendar.getTime();
		
		drivinglicence = new DrivingLicence("John", "Jones", date, date1, true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
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
		
		drivinglicence.setRentalStatus(false);
		
		//check that message prints and first car is returned
		assertEquals(car1, rentalcompany.getCar(drivinglicence));
		
		drivinglicence.setRentalStatus(true);
		
		RentalContract rentalcontract = new RentalContract(drivinglicence, car3);
		rentalcompany.addContract(rentalcontract);
		
		//Create contract and check correct car is returned. No need to
		//go through 'issue' methods and checks when testing.
		assertEquals(car3, rentalcompany.getCar(drivinglicence));
	}

}
