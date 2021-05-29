package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dataManagePackage.Receipt.Receipt;

public class ReceiptTest {

	@Test
	public void EntertainmentTest() {
		Receipt receipt = new Receipt("Entertainment", "GR", "29/04/96", "45000.0", "Periklis","GREECE", "IOANNINA", "28hs","45");
		assertEquals("Entertainment",receipt.getKind());
		assertEquals("GR",receipt.getId());
		assertEquals("29/04/96",receipt.getDate());
		String amount = ""+receipt.getAmount();
		assertEquals("45000.0",amount);
		assertEquals("Periklis",receipt.getCompany().getName());
		assertEquals("GREECE",receipt.getCompany().getCountry());
		assertEquals("IOANNINA",receipt.getCompany().getCity());
		assertEquals("28hs",receipt.getCompany().getStreet());
		assertEquals("45",receipt.getCompany().getNumber());
	}
	@Test
	public void BasicTest() {
		Receipt receipt = new Receipt("Basic", "GR", "29/04/96", "45000.0", "Periklis","GREECE", "IOANNINA", "28hs","45");
		assertEquals("Basic",receipt.getKind());
		assertEquals("GR",receipt.getId());
		assertEquals("29/04/96",receipt.getDate());
		String amount = ""+receipt.getAmount();
		assertEquals("45000.0",amount);
		assertEquals("Periklis",receipt.getCompany().getName());
		assertEquals("GREECE",receipt.getCompany().getCountry());
		assertEquals("IOANNINA",receipt.getCompany().getCity());
		assertEquals("28hs",receipt.getCompany().getStreet());
		assertEquals("45",receipt.getCompany().getNumber());
	}
	@Test
	public void TravelTest() {
		Receipt receipt = new Receipt("Travel", "GR", "29/04/96", "45000.0", "Periklis","GREECE", "IOANNINA", "28hs","45");
		assertEquals("Travel",receipt.getKind());
		assertEquals("GR",receipt.getId());
		assertEquals("29/04/96",receipt.getDate());
		String amount = ""+receipt.getAmount();
		assertEquals("45000.0",amount);
		assertEquals("Periklis",receipt.getCompany().getName());
		assertEquals("GREECE",receipt.getCompany().getCountry());
		assertEquals("IOANNINA",receipt.getCompany().getCity());
		assertEquals("28hs",receipt.getCompany().getStreet());
		assertEquals("45",receipt.getCompany().getNumber());
	}
	@Test
	public void HealthTest() {
		Receipt receipt = new Receipt("Health", "GR", "29/04/96", "45000.0", "Periklis","GREECE", "IOANNINA", "28hs","45");
		assertEquals("Health",receipt.getKind());
		assertEquals("GR",receipt.getId());
		assertEquals("29/04/96",receipt.getDate());
		String amount = ""+receipt.getAmount();
		assertEquals("45000.0",amount);
		assertEquals("Periklis",receipt.getCompany().getName());
		assertEquals("GREECE",receipt.getCompany().getCountry());
		assertEquals("IOANNINA",receipt.getCompany().getCity());
		assertEquals("28hs",receipt.getCompany().getStreet());
		assertEquals("45",receipt.getCompany().getNumber());
	}
	@Test
	public void OtherTest() {
		Receipt receipt = new Receipt("Other", "GR", "29/04/96", "45000.0", "Periklis","GREECE", "IOANNINA", "28hs","45");
		assertEquals("Other",receipt.getKind());
		assertEquals("GR",receipt.getId());
		assertEquals("29/04/96",receipt.getDate());
		String amount = ""+receipt.getAmount();
		assertEquals("45000.0",amount);
		assertEquals("Periklis",receipt.getCompany().getName());
		assertEquals("GREECE",receipt.getCompany().getCountry());
		assertEquals("IOANNINA",receipt.getCompany().getCity());
		assertEquals("28hs",receipt.getCompany().getStreet());
		assertEquals("45",receipt.getCompany().getNumber());
	}
}
