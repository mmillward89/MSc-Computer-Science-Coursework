package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import car.rental.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RentalCompanyIssueCartest {
	
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
	private DrivingLicence drivinglicence1;
	private DrivingLicence drivinglicence2;
	
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
		calendar.set(1996, 10, 21);
		Date date = calendar.getTime();

		calendar.set(2015, 3, 9);
		Date date1 = calendar.getTime();
		
		drivinglicence = new DrivingLicence("Tom", "Bombadil", date, date1, true);
		
		calendar.set(1992, 10, 21);
		Date date2 = calendar.getTime();

		calendar.set(2011, 3, 9);
		Date date3 = calendar.getTime();
		
		drivinglicence1 = new DrivingLicence("The", "Pope", date2, date3, true);
		
		calendar.set(1900, 10, 21);
		Date date4 = calendar.getTime();

		calendar.set(1950, 3, 9);
		Date date5 = calendar.getTime();
		
		drivinglicence2 = new DrivingLicence("Michael", "Jordan", date4, date5, true);
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
		
		drivinglicence.setFullLicence(false);
		boolean testmethod = rentalcompany.issueCar(drivinglicence, "large");
		
		//check full licence check works
		assertFalse(testmethod);
		
		drivinglicence.setFullLicence(true);
		drivinglicence.setRentalStatus(true);
		testmethod = rentalcompany.issueCar(drivinglicence, "large");
		
		//check rental status check works
		assertFalse(testmethod);
		
		drivinglicence.setRentalStatus(false);
		testmethod = rentalcompany.issueCar(drivinglicence, "hello");
		
		//check wrong type could not be found
		assertFalse(testmethod);
		
		car1.setRentalStatus(true);
		car2.setRentalStatus(true);
		car3.setRentalStatus(true);
		car4.setRentalStatus(true);
		car5.setRentalStatus(true);
		testmethod = rentalcompany.issueCar(drivinglicence, "LaRge");
		
		//set all large to rented then check that a request won't work
		assertFalse(testmethod);
		
		car6.setRentalStatus(true);
		car7.setRentalStatus(true);
		car8.setRentalStatus(true);
		car9.setRentalStatus(true);
		car10.setRentalStatus(true);
		testmethod = rentalcompany.issueCar(drivinglicence, "SmAll");
		
		//same as above but for small
		assertFalse(testmethod);
	
		car6.setRentalStatus(false);
		car7.setRentalStatus(false);
		car8.setRentalStatus(false);
		car9.setRentalStatus(false);
		car10.setRentalStatus(false);
		
		car1.drive(10);
		car2.drive(10);
		car3.drive(10);
		car4.drive(10);
		car5.drive(10);
		car1.setRentalStatus(false);
		testmethod = rentalcompany.issueCar(drivinglicence2, "LARGE");
		
		//check that non-full fuel tank check works
		assertFalse(testmethod);
		
		car1.addFuel(1);
		car2.addFuel(1);
		car3.addFuel(1);
		car4.addFuel(1);
		car5.addFuel(1);
		
		testmethod = rentalcompany.issueCar(drivinglicence, "SMALL");
		
		//check licence with ineligible dates can't rent small car
		//next one does that for large, adding fuel to car.
		assertFalse(testmethod);
		
		car1.setRentalStatus(true); car1.addFuel(100); car1.setRentalStatus(false);
		testmethod = rentalcompany.issueCar(drivinglicence1, "lARGe");
		assertFalse(testmethod);
		
		testmethod = rentalcompany.issueCar(drivinglicence2, "smaLL");
		
		//final one checks that all appropriate additions are made
		//when conditions are correct
		assertTrue(testmethod);
		assertTrue(car6.getRentalStatus());
		assertTrue(drivinglicence2.getRentalStatus());
	}

}
