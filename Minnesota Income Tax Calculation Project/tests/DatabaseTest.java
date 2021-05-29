package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dataManagePackage.Database;
import inputManagePackage.InputSystem;
import inputManagePackage.InputSystemFactory;
import inputManagePackage.InputSystemTxt;
import inputManagePackage.InputSystemXml;

public class DatabaseTest {

	@Test
	public void setTaxpayersInfoFilesPathTest() {
		Database database = Database.getInstance();
		database.setTaxpayersInfoFilesPath("filepath\\filePath");
		assertEquals("filepath\\filePath", database.getTaxpayersInfoFilesPath());
	}
	@Test
	public void proccessTaxpayersDataFromTxtFilesIntoDatabaseTest() {
		// prepei na settaroume to path
		String path = "E:\\DATA\\cs\\Ανάπτ.Λογισμ.2\\project\\SoftDevII-ProjectMaterial-2021\\project-material\\Minnesota Income Tax Calculation Project\\InputFiles\\";
		List<String> list = new ArrayList<String>();
		list.add("130456093_INFO.txt");
		InputSystem  inputSystemFactory =  InputSystemFactory.addTaxpayersDataFromFilesIntoDatabase(path,list);
		//assert
		InputSystem inputsystem = new InputSystemTxt(path, list.get(0));
		inputsystem.loadTaxpayerDataFromFileIntoDatabase(path, list.get(0));
		assertEquals(inputsystem.getafmInfoFile(), inputSystemFactory.getafmInfoFile());
		assertEquals(inputsystem.getafmInfoFileFolderPath(),inputSystemFactory.getafmInfoFileFolderPath());
	}
	@Test
	public void proccessTaxpayersDataFromXmlFilesIntoDatabaseTest() {
		// prepei na settaroume to path
		String path = "E:\\DATA\\cs\\Ανάπτ.Λογισμ.2\\project\\SoftDevII-ProjectMaterial-2021\\project-material\\Minnesota Income Tax Calculation Project\\InputFiles\\";
		List<String> list = new ArrayList<String>();
		list.add("130456094_INFO.xml");
		InputSystem  inputSystemFactory =  InputSystemFactory.addTaxpayersDataFromFilesIntoDatabase(path,list);
		//assert
		InputSystem inputsystem = new InputSystemXml(path, list.get(0));
		inputsystem.loadTaxpayerDataFromFileIntoDatabase(path, list.get(0));
		assertEquals(inputsystem.getafmInfoFile(), inputSystemFactory.getafmInfoFile());
		assertEquals(inputsystem.getafmInfoFileFolderPath(),inputSystemFactory.getafmInfoFileFolderPath());
	}

}
