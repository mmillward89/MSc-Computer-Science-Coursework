package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import car.rental.*;
public class EqualsHashcodeValueoftest {
	private LargeCar car1;
	private LargeCar car2;
	private SmallCar car3;
	private SmallCar car4;
	private DrivingLicence drivinglicence1;
	private DrivingLicence drivinglicence2;
	private LicenceNumber licencenumber1;
	private LicenceNumber licencenumber2;
	private RegistrationNumber registrationnumber1;
	private RegistrationNumber registrationnumber2;
	
	@Before
	public void setUp() throws Exception {
		car1 = new LargeCar();
		car2 = new LargeCar();
		car3 = new SmallCar();
		car4 = new SmallCar();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1996, 10, 21);
		Date date = calendar.getTime();

		calendar.set(2015, 3, 9);
		Date date1 = calendar.getTime();
		
		drivinglicence1 = new DrivingLicence("Mark", "Millward", date, date1, true);
		
		calendar.set(1992, 10, 21);
		Date date2 = calendar.getTime();

		calendar.set(2011, 3, 9);
		Date date3 = calendar.getTime();
		
		drivinglicence2 = new DrivingLicence("Chris", "Gayle", date2, date3, true);
		
		licencenumber1 = drivinglicence1.getLicenceNumber();
		licencenumber2 = drivinglicence2.getLicenceNumber();
		
		registrationnumber1 = RegistrationNumber.getInstance();
		registrationnumber2 = RegistrationNumber.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//check equal and hashcode methods work 
		//for true and false claims in each class.
		
		assertFalse(car1.equals(car2));
		
		Car car5 = car1;
		assertTrue(car1.equals(car5));
		
		assertFalse(car3.equals(car4));
		
		Car car6 = car3;
		assertTrue(car3.equals(car6));
		
		int a = car1.hashCode();
		int b = car2.hashCode();
		
		assertFalse(a == b);
		
		assertEquals(car1.hashCode(), car5.hashCode());
		
		a = car3.hashCode();
		b = car4.hashCode();
		assertFalse(a == b);
		
		assertEquals(car3.hashCode(), car6.hashCode());
		
		assertFalse(drivinglicence1.equals(drivinglicence2));
		DrivingLicence drivinglicence3 = drivinglicence2;
		
		assertTrue(drivinglicence2.equals(drivinglicence3));
		
		a = drivinglicence1.hashCode();
		b = drivinglicence2.hashCode();
		
		assertFalse(a == b);
		assertEquals(drivinglicence2.hashCode(), drivinglicence3.hashCode());
		
		assertFalse(licencenumber1.equals(licencenumber2));
		LicenceNumber licencenumber3 = licencenumber2;
		
		assertTrue(licencenumber2.equals(licencenumber3));
		
		a = licencenumber1.hashCode();
		b = licencenumber2.hashCode();
		
		assertFalse(a == b);
		assertEquals(licencenumber2.hashCode(), licencenumber3.hashCode());
		
		assertFalse(registrationnumber1.equals(registrationnumber2));
		RegistrationNumber registrationnumber3 = registrationnumber2;
		
		assertTrue(registrationnumber2.equals(registrationnumber3));
		
		a = registrationnumber1.hashCode();
		b = registrationnumber2.hashCode();
		
		assertFalse(a == b);
		assertEquals(registrationnumber2.hashCode(), registrationnumber3.hashCode());
		
		//Check valueof works and prints correctly
		DriverName drivername1 = DriverName.valueOf("Terry Wogan");
		System.out.println(drivername1.getFirstName());
		System.out.println(drivername1.getLastName());
				
	}

}
