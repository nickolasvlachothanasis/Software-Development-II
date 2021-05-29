package inputManagePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dataManagePackage.Database;
import dataManagePackage.FamilyStatus;
import dataManagePackage.Taxpayer;
import dataManagePackage.Receipt.Receipt;
import gui.InsertNewReceiptJDialog;

public class InputSystemTxt extends InputSystem{
	private Database database = Database.getInstance();	
	public InputSystemTxt(String afmInfoFileFolderPath, String afmInfoFile) {
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
		
		String taxpayerName = getParameterValueFromFileLine(inputStream.nextLine(), "Name: ","");
		String taxpayerAFM = getParameterValueFromFileLine(inputStream.nextLine(), "AFM: ","");
		String status = getParameterValueFromFileLine(inputStream.nextLine(), "Status: ","");
		String taxpayerIncome = getParameterValueFromFileLine(inputStream.nextLine(), "Income: ","");
		FamilyStatus newFamilyStatus = new FamilyStatus(status);
		System.out.println(newFamilyStatus.getStatus());
		Taxpayer newTaxpayer = new Taxpayer(taxpayerName, taxpayerAFM, newFamilyStatus, taxpayerIncome);
		
		String fileLine;
		while (inputStream.hasNextLine())
		{
			fileLine = inputStream.nextLine();
			if (fileLine.equals("")) continue;
			if (fileLine.indexOf("Receipts:")!=-1) continue;
			
			String receiptID = getParameterValueFromFileLine(fileLine, "Receipt ID: ","");
			String receiptDate = getParameterValueFromFileLine(inputStream.nextLine(), "Date: ","");
			String receiptKind = getParameterValueFromFileLine(inputStream.nextLine(), "Kind: ","");
			String receiptAmount = getParameterValueFromFileLine(inputStream.nextLine(), "Amount: ","");
			String receiptCompany = getParameterValueFromFileLine(inputStream.nextLine(), "Company: ","");
			String receiptCountry = getParameterValueFromFileLine(inputStream.nextLine(), "Country: ","");
			String receiptCity = getParameterValueFromFileLine(inputStream.nextLine(), "City: ","");
			String receiptStreet = getParameterValueFromFileLine(inputStream.nextLine(), "Street: ","");
			String receiptNumber = getParameterValueFromFileLine(inputStream.nextLine(), "Number: ","");
			Receipt newReceipt = new Receipt(receiptKind, receiptID, receiptDate, receiptAmount, receiptCompany, receiptCountry, receiptCity, receiptStreet, receiptNumber);
			
			newTaxpayer.addReceiptToList(newReceipt);
		}
		//Database database = Database.getInstance();		
		database.addTaxpayerToList(newTaxpayer);
		
		
	}
	
	public String getParameterValueFromFileLine(String fileLine, String parameterName, String parameterEndField){
		return fileLine.substring(parameterName.length(), fileLine.length()-parameterEndField.length());
	}
	
	public Database getDatabase() {return this.database;}

}
