package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import car.rental.*;

public class RentalCompanyTerminateRentaltest {
	private LargeCar car1;
	private SmallCar car2;
	private RentalCompany rentalcompany;
	private DrivingLicence drivinglicence;

	@Before
	public void setUp() throws Exception {
		car1 = new LargeCar();
		car2 = new SmallCar();
		
		rentalcompany = RentalCompany.getInstance();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1900, 10, 21);
		Date date = calendar.getTime();

		calendar.set(1950, 3, 9);
		Date date1 = calendar.getTime();
		
		drivinglicence = new DrivingLicence("Tom", "Bombadil", date, date1, true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		rentalcompany.addCar(car1);
		rentalcompany.addCar(car2);
		int testmethod = rentalcompany.terminateRental(drivinglicence);
		
		//No rental contract should return 0 and print message.
		assertEquals(0, testmethod);
		
		rentalcompany.issueCar(drivinglicence,"large");
		car1.drive(40);
		testmethod = rentalcompany.terminateRental(drivinglicence);
		
		//Check that message is passed when fuel is liable
		assertEquals(4, testmethod);
		
		rentalcompany.issueCar(drivinglicence,"small");
		testmethod = rentalcompany.terminateRental(drivinglicence);
		
		//Check that 0 returned and message printed when all conditions met
		assertEquals(0, testmethod);
	}

}
