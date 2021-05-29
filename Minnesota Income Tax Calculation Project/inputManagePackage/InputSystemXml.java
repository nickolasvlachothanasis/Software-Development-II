package inputManagePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dataManagePackage.Database;
import dataManagePackage.FamilyStatus;
import dataManagePackage.Taxpayer;
import dataManagePackage.Receipt.Receipt;

public class InputSystemXml extends InputSystem {
	private Database database = Database.getInstance();	
	public InputSystemXml(String afmInfoFileFolderPath, String afmInfoFile) {
		super(afmInfoFileFolderPath, afmInfoFile);
	}

	
	public void loadTaxpayerDataFromFileIntoDatabase(String afmInfoFileFolderPath, String afmInfoFile){
		Scanner inputStream = null;
		try
		{
			inputStream = new Scanner(new FileInputStream(afmInfoFileFolderPath+"\\"+afmInfoFile));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening " + afmInfoFile + " file.");
			System.exit(0);
		}			
		
		String taxpayerName = getParameterValueFromFileLine(inputStream.nextLine(), "<Name> ", " </Name>");
		String taxpayerAFM = getParameterValueFromFileLine(inputStream.nextLine(), "<AFM> ", " </AFM>");
		String status = getParameterValueFromFileLine(inputStream.nextLine(), "<Status> ", " </Status>");
		String taxpayerIncome = getParameterValueFromFileLine(inputStream.nextLine(), "<Income> ", " </Income>");
		FamilyStatus newFamilyStatus = new FamilyStatus(status);
		Taxpayer newTaxpayer = new Taxpayer(taxpayerName, taxpayerAFM, newFamilyStatus, taxpayerIncome);
		
		String fileLine;
		while (inputStream.hasNextLine())
		{
			fileLine = inputStream.nextLine();
			if (fileLine.equals("")) continue;
			if (fileLine.indexOf("<Receipts>")!=-1) continue;
			if (fileLine.indexOf("</Receipts>")!=-1) break;
			
			String receiptID = getParameterValueFromFileLine(fileLine, "<ReceiptID> ", " </ReceiptID>");
			String receiptDate = getParameterValueFromFileLine(inputStream.nextLine(), "<Date> ", " </Date>");
			String receiptKind = getParameterValueFromFileLine(inputStream.nextLine(), "<Kind> ", " </Kind>");
			String receiptAmount = getParameterValueFromFileLine(inputStream.nextLine(), "<Amount> ", " </Amount>");
			String receiptCompany = getParameterValueFromFileLine(inputStream.nextLine(), "<Company> ", " </Company>");
			String receiptCountry = getParameterValueFromFileLine(inputStream.nextLine(), "<Country> ", " </Country>");
			String receiptCity = getParameterValueFromFileLine(inputStream.nextLine(), "<City> ", " </City>");
			String receiptStreet = getParameterValueFromFileLine(inputStream.nextLine(), "<Street> ", " </Street>");
			String receiptNumber = getParameterValueFromFileLine(inputStream.nextLine(), "<Number> ", " </Number>");
			Receipt newReceipt = new Receipt(receiptKind, receiptID, receiptDate, receiptAmount, receiptCompany, receiptCountry, receiptCity, receiptStreet, receiptNumber);
			//Receipt newReceipt = ReceiptFactory.createNewReceipt(receiptKind, receiptID, receiptDate, receiptAmount, receiptCompany, receiptCountry, receiptCity, receiptStreet, receiptNumber);
			
			newTaxpayer.addReceiptToList(newReceipt);
		}
		//Database database = Database.getInstance();
		database.addTaxpayerToList(newTaxpayer);
	}
	
	public String getParameterValueFromFileLine(String fileLine, String parameterStartField, String parameterEndField){
		return fileLine.substring(parameterStartField.length(), fileLine.length()-parameterEndField.length());
	}

	public Database getDatabase() {return this.database;}
	
}

