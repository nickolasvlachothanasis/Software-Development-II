package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dataManagePackage.FamilyStatus;
import dataManagePackage.Taxpayer;

public class TaxpayerTest {

	@Test
	public void calculateTaxForMarriedFilingJointlyTest1() {
		FamilyStatus familystatus = new FamilyStatus("married filing jointly");
		String income = ""+(familystatus.getLimits(0)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = (5.35/100) * Double.parseDouble(income);
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForMarriedFilingJointlyTest2() {
		FamilyStatus familystatus = new FamilyStatus("married filing jointly");
		String income = ""+(familystatus.getLimits(1)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(0) + (familystatus.getRates(0) * (Double.parseDouble(income)-familystatus.getLimits(0)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForMarriedFilingJointlyTest3() {
		FamilyStatus familystatus = new FamilyStatus("married filing jointly");
		String income = ""+(familystatus.getLimits(2)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(1) + (familystatus.getRates(1) * (Double.parseDouble(income)-familystatus.getLimits(1)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForMarriedFilingJointlyTest4() {
		FamilyStatus familystatus = new FamilyStatus("married filing jointly");
		String income = ""+(familystatus.getLimits(3)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(2) + (familystatus.getRates(2) * (Double.parseDouble(income)-familystatus.getLimits(2)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForMarriedFilingJointlyTest5() {
		FamilyStatus familystatus = new FamilyStatus("married filing jointly");
		String income = ""+(familystatus.getLimits(3)+132.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(3) + (familystatus.getRates(3) * (Double.parseDouble(income)-familystatus.getLimits(3)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForMarriedFilingSeparatelyTest1() {
		FamilyStatus familystatus = new FamilyStatus("married filing separately");
		String income = ""+(familystatus.getLimits(0)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = (5.35/100) * Double.parseDouble(income);
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForMarriedFilingSeparatelyTest2() {
		FamilyStatus familystatus = new FamilyStatus("married filing separately");
		String income = ""+(familystatus.getLimits(1)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(0) + (familystatus.getRates(0) * (Double.parseDouble(income)-familystatus.getLimits(0)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForMarriedFilingSeparatelyTest3() {
		FamilyStatus familystatus = new FamilyStatus("married filing separately");
		String income = ""+(familystatus.getLimits(2)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(1) + (familystatus.getRates(1) * (Double.parseDouble(income)-familystatus.getLimits(1)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForMarriedFilingSeparatelyTest4() {
		FamilyStatus familystatus = new FamilyStatus("married filing separately");
		String income = ""+(familystatus.getLimits(3)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(2) + (familystatus.getRates(2) * (Double.parseDouble(income)-familystatus.getLimits(2)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForMarriedFilingSeparatelyTest5() {
		FamilyStatus familystatus = new FamilyStatus("married filing separately");
		String income = ""+(familystatus.getLimits(3)+231.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(3) + (familystatus.getRates(3) * (Double.parseDouble(income)-familystatus.getLimits(3)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForSingleTest1() {
		FamilyStatus familystatus = new FamilyStatus("single");
		String income = ""+(familystatus.getLimits(0)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = (5.35/100) * Double.parseDouble(income);
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForSingleTest2() {
		FamilyStatus familystatus = new FamilyStatus("single");
		String income = ""+(familystatus.getLimits(1)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(0) + (familystatus.getRates(0) * (Double.parseDouble(income)-familystatus.getLimits(0)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForSingleTest3() {
		FamilyStatus familystatus = new FamilyStatus("single");
		String income = ""+(familystatus.getLimits(2)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(1) + (familystatus.getRates(1) * (Double.parseDouble(income)-familystatus.getLimits(1)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForSingleTest4() {
		FamilyStatus familystatus = new FamilyStatus("single");
		String income = ""+(familystatus.getLimits(3)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(2) + (familystatus.getRates(2) * (Double.parseDouble(income)-familystatus.getLimits(2)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForSingleTest5() {
		FamilyStatus familystatus = new FamilyStatus("single");
		String income = ""+(familystatus.getLimits(3)+231.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(3) + (familystatus.getRates(3) * (Double.parseDouble(income)-familystatus.getLimits(3)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForElseTest1() {
		FamilyStatus familystatus = new FamilyStatus("Else");
		String income = ""+(familystatus.getLimits(0)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = (5.35/100) * Double.parseDouble(income);
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForElseTest2() {
		FamilyStatus familystatus = new FamilyStatus("Else");
		String income = ""+(familystatus.getLimits(1)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(0) + (familystatus.getRates(0) * (Double.parseDouble(income)-familystatus.getLimits(0)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForElseTest3() {
		FamilyStatus familystatus = new FamilyStatus("Else");
		String income = ""+(familystatus.getLimits(2)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(1) + (familystatus.getRates(1) * (Double.parseDouble(income)-familystatus.getLimits(1)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForElseTest4() {
		FamilyStatus familystatus = new FamilyStatus("Else");
		String income = ""+(familystatus.getLimits(3)-1.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(2) + (familystatus.getRates(2) * (Double.parseDouble(income)-familystatus.getLimits(2)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
	@Test
	public void calculateTaxForElseTest5() {
		FamilyStatus familystatus = new FamilyStatus("Else");
		String income = ""+(familystatus.getLimits(3)+231.0);
		Taxpayer taxpayer = new Taxpayer("Taxpayer","256489209",familystatus,income);
		double tax = familystatus.getAmountRate(3) + (familystatus.getRates(3) * (Double.parseDouble(income)-familystatus.getLimits(3)));
		String expected =""+ tax;
		String actual = ""+taxpayer.calculateTax(Double.parseDouble(income), familystatus);
		assertEquals(expected, actual);
	}
}
