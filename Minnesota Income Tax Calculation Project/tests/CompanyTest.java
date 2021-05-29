package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dataManagePackage.Receipt.Company;

public class CompanyTest {

	@Test
	public void companyInfoTest() {
		Company company = new Company("Epaminondas","Soudan","Paris","Kalari","2");
		assertEquals("Epaminondas",company.getName());
		assertEquals("Soudan",company.getCountry());
		assertEquals("Paris",company.getCity());
		assertEquals("Kalari",company.getStreet());
		assertEquals("2",company.getNumber());
	}

}
