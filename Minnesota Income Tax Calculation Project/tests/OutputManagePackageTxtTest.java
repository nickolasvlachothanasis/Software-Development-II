package tests;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import dataManagePackage.Database;
import dataManagePackage.FamilyStatus;
import dataManagePackage.Taxpayer;
import dataManagePackage.Receipt.Receipt;
import inputManagePackage.InputSystem;
import inputManagePackage.InputSystemFactory;

public class OutputManagePackageTxtTest {

	@Test
	public void testTxt() {
		
		Scanner inputStream = null;
		try
		{
			inputStream = new Scanner(new FileInputStream("E:\\DATA\\cs\\Ανάπτ.Λογισμ.2\\project\\SoftDevII-ProjectMaterial-2021\\project-material\\Minnesota Income Tax Calculation Project"+"\\"+"130456093_LOG.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening " + "130456093_LOG.txt" + " file.");
			System.exit(0);
		}			
		
		String taxpayerName = getParameterValueFromFileLine(inputStream.nextLine(), "Name: ","");
		String taxpayerAFM = getParameterValueFromFileLine(inputStream.nextLine(), "AFM: ","");
		//String status = getParameterValueFromFileLine(inputStream.nextLine(), "Status: ","");
		String taxpayerIncome = getParameterValueFromFileLine(inputStream.nextLine(), "Income: ","");
		String basicTax = getParameterValueFromFileLine(inputStream.nextLine(), "Basic Tax: ","");
		String taxIncrease = getParameterValueFromFileLine(inputStream.nextLine(), "Tax Increase: ","");
		String totalTax= getParameterValueFromFileLine(inputStream.nextLine(), "Total Tax: ","");
		String totalReceiptsAmount= getParameterValueFromFileLine(inputStream.nextLine(), "Total Receipts Amount: ","");
		String Entert= getParameterValueFromFileLine(inputStream.nextLine(), "Entertainment: ","");
		String Basic= getParameterValueFromFileLine(inputStream.nextLine(), "Basic: ","");
		String Travel= getParameterValueFromFileLine(inputStream.nextLine(), "Travel: ","");
		String Health= getParameterValueFromFileLine(inputStream.nextLine(), "Health: ","");
		String Other= getParameterValueFromFileLine(inputStream.nextLine(), "Other: ","");
		assertEquals("Apostolos Zarras",taxpayerName);
		assertEquals("130456093",taxpayerAFM);
		assertEquals("22570.0",taxpayerIncome);
		assertEquals("1207.49",basicTax);
		assertEquals("96.6",taxIncrease);
		assertEquals("1304.09",totalTax);
		assertEquals("4500.0",totalReceiptsAmount);
		assertEquals("500.0",Entert);
		assertEquals("2000.0",Basic);
		assertEquals("0.0",Travel);
		assertEquals("500.0",Health);
		assertEquals("1500.0",Other);
		
		
	}
	public String getParameterValueFromFileLine(String fileLine, String parameterName, String parameterEndField){
		return fileLine.substring(parameterName.length(), fileLine.length()-parameterEndField.length());
	}
	

}
