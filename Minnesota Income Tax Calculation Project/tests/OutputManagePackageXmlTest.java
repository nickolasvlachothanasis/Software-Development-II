package tests;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class OutputManagePackageXmlTest {

	@Test
	public void testXml() {
		
		Scanner inputStream = null;
		try
		{
			inputStream = new Scanner(new FileInputStream("E:\\DATA\\cs\\Ανάπτ.Λογισμ.2\\project\\SoftDevII-ProjectMaterial-2021\\project-material\\Minnesota Income Tax Calculation Project"+"\\"+"130456093_LOG.xml"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening " + "130456093_LOG.xml" + " file.");
			System.exit(0);
		}			
		
		String taxpayerName = getParameterValueFromFileLine(inputStream.nextLine(), "<Name> ","");
		String taxpayerAFM = getParameterValueFromFileLine(inputStream.nextLine(), "<AFM> ","");
		//String status = getParameterValueFromFileLine(inputStream.nextLine(), "Status: ","");
		String taxpayerIncome = getParameterValueFromFileLine(inputStream.nextLine(), "<Income> ","");
		String basicTax = getParameterValueFromFileLine(inputStream.nextLine(), "<BasicTax> ","");
		String taxIncrease = getParameterValueFromFileLine(inputStream.nextLine(), "<TaxIncrease> ","");
		String totalTax= getParameterValueFromFileLine(inputStream.nextLine(), "<TotalTax> ","");
		String totalReceiptsAmount= getParameterValueFromFileLine(inputStream.nextLine(), "<Receipts> ","");
		String Entert= getParameterValueFromFileLine(inputStream.nextLine(), "<Entertainment> ","");
		String Basic= getParameterValueFromFileLine(inputStream.nextLine(), "<Basic> ","");
		String Travel= getParameterValueFromFileLine(inputStream.nextLine(), "<Travel> ","");
		String Health= getParameterValueFromFileLine(inputStream.nextLine(), "<Health> ","");
		String Other= getParameterValueFromFileLine(inputStream.nextLine(), "<Other> ","");
		assertEquals("Apostolos Zarras </Name>",taxpayerName);
		assertEquals("130456093 </AFM>",taxpayerAFM);
		assertEquals("22570.0 </Income>",taxpayerIncome);
		assertEquals("1207.49 </BasicTax>",basicTax);
		assertEquals("96.6 </TaxIncrease>",taxIncrease);
		assertEquals("1304.09 </TotalTax>",totalTax);
		assertEquals("4500.0 </Receipts>",totalReceiptsAmount);
		assertEquals("500.0 </Entertainment>",Entert);
		assertEquals("2000.0 </Basic>",Basic);
		assertEquals("0.0 </Travel>",Travel);
		assertEquals("500.0 </Health>",Health);
		assertEquals("1500.0 </Other>",Other);
		
		
	}
	
	public String getParameterValueFromFileLine(String fileLine, String parameterName, String parameterEndField){
		return fileLine.substring(parameterName.length(), fileLine.length()-parameterEndField.length());
	}

}
