package test;

import car.rental.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ObjectFactorytestTest {
	private LicenceNumber licencenumber1;
	private LicenceNumber licencenumber2;
	private LicenceNumber licencenumber3;
	private LicenceNumber licencenumber4;
	private LicenceNumber licencenumber5;
	private RegistrationNumber registrationnumber1;
	private RegistrationNumber registrationnumber2;
	private RegistrationNumber registrationnumber3;
	private RegistrationNumber registrationnumber4;
	private RegistrationNumber registrationnumber5;

	@Before
	public void setUp() throws Exception {
		licencenumber1 = LicenceNumber.getInstance("MM", 2000);
		licencenumber2 = LicenceNumber.getInstance("MM", 1994);
		licencenumber3 = LicenceNumber.getInstance("SY", 1990);
		licencenumber4 = LicenceNumber.getInstance("MM", 1990);
		licencenumber5 = LicenceNumber.getInstance("ST", 2005);
		registrationnumber1 = RegistrationNumber.getInstance();
		registrationnumber2 = RegistrationNumber.getInstance();
		registrationnumber3 = RegistrationNumber.getInstance();
		registrationnumber4 = RegistrationNumber.getInstance();
		registrationnumber5 = RegistrationNumber.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//print test to determine that tostring works, and that
		//each instance is turning out different
		
		System.out.println(licencenumber1);
		System.out.println(licencenumber2);
		System.out.println(licencenumber3);
		System.out.println(licencenumber4);
		System.out.println(licencenumber5);
		System.out.println(registrationnumber1);
		System.out.println(registrationnumber2);
		System.out.println(registrationnumber3);
		System.out.println(registrationnumber4);
		System.out.println(registrationnumber5);
	}

}
