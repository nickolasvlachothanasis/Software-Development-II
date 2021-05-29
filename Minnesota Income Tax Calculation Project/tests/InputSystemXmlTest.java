package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dataManagePackage.Database;
import inputManagePackage.InputSystem;
import inputManagePackage.InputSystemFactory;

public class InputSystemXmlTest {

	@Test
	public void test() {
		String path = "E:\\DATA\\cs\\Ανάπτ.Λογισμ.2\\project\\SoftDevII-ProjectMaterial-2021\\project-material\\Minnesota Income Tax Calculation Project\\InputFiles";
		List<String> myList = new ArrayList<String>();
		myList.add("130456094_INFO.xml");
		InputSystem  inputSystemFactory =  InputSystemFactory.addTaxpayersDataFromFilesIntoDatabase(path, myList);
		Database database = inputSystemFactory.getDatabase();
		String expected="Nikos Zisis";
		String actual=database.getTaxpayerFromArrayList(0).getName();
		assertEquals(expected, actual);
		expected="130456094";
		actual=database.getTaxpayerFromArrayList(0).getAFM();
		assertEquals(expected, actual);
		expected="Single";
		actual=database.getTaxpayerFromArrayList(0).getFamilyStatus();
		assertEquals(expected, actual);
		expected="40000.0";
		actual=""+database.getTaxpayerFromArrayList(0).getIncome();
		assertEquals(expected, actual);
		expected="1";
		actual=database.getTaxpayerFromArrayList(0).getReceipt(0).getId();
		assertEquals(expected, actual);
		expected="25/2/2014";
		actual=database.getTaxpayerFromArrayList(0).getReceipt(0).getDate();
		assertEquals(expected, actual);
		expected="Other";
		actual=database.getTaxpayerFromArrayList(0).getReceipt(0).getKind();
		assertEquals(expected, actual);
		expected="2000.0";
		actual=""+database.getTaxpayerFromArrayList(0).getReceipt(0).getAmount();
		assertEquals(expected, actual);
		expected="Omega Watches";
		actual=database.getTaxpayerFromArrayList(0).getReceipt(0).getCompany().getName();
		assertEquals(expected, actual);
		expected="Greece";
		actual=database.getTaxpayerFromArrayList(0).getReceipt(0).getCompany().getCountry();
		assertEquals(expected, actual);
		expected="Ioannina";
		actual=database.getTaxpayerFromArrayList(0).getReceipt(0).getCompany().getCity();
		assertEquals(expected, actual);
		expected="Kaloudi";
		actual=database.getTaxpayerFromArrayList(0).getReceipt(0).getCompany().getStreet();
		assertEquals(expected, actual);
		expected="4";
		actual=database.getTaxpayerFromArrayList(0).getReceipt(0).getCompany().getNumber();
		assertEquals(expected, actual);
	}

}
