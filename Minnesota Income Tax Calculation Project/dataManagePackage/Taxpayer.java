package dataManagePackage;
import dataManagePackage.Receipt.Receipt;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Taxpayer {
	private String name;
	private String afm;
	
	//private String familyStatus;
	private FamilyStatus familyStatus;
	
	private double income;
	private double basicTax;
	private double taxIncrease;
	private double taxDecrease;
	private double totalTax;
	private ArrayList<Receipt> receipts;
	/*Array of limits: 
		each line has the income limits for each family status .
		it is 4x4 array 
	Array rates : 
		it is 3D array 4x4x2
		each of the four lines represent each family status and consist a 2D array
		each line of the 2D array has the amount of tax and the rate of tax for each income based on family status
		
	*/
	
	public Taxpayer(String name, String afm, FamilyStatus familyStatus, String income){
		this.name = name;
		this.afm = afm;
		this.familyStatus = familyStatus;
		this.income = Double.parseDouble(income);
		setBasicTaxBasedOnFamilyStatus();
		taxIncrease = 0;
		taxDecrease = 0;
		
		receipts = new ArrayList<Receipt>();
	}
	// we changed the method which calculates basicTax
	private void setBasicTaxBasedOnFamilyStatus(){
		basicTax = calculateTax(income,familyStatus);
		totalTax = basicTax;
	}

	// new method calculateTax
	public double calculateTax(double totalIncome,FamilyStatus familyStatus) {
		double tax;
		
		if(totalIncome < familyStatus.getLimits(0)) {
			tax = (5.35/100) * totalIncome;
		}
		else if(totalIncome < familyStatus.getLimits(1)){
			tax = familyStatus.getAmountRate(0) + (familyStatus.getRates(0) * (totalIncome-familyStatus.getLimits(0)));
		}
		else if(totalIncome < familyStatus.getLimits(2)) {
			tax = familyStatus.getAmountRate(1) + (familyStatus.getRates(1) * (totalIncome-familyStatus.getLimits(1)));
		}
		else if(totalIncome < familyStatus.getLimits(3)) {
			tax = familyStatus.getAmountRate(2) + (familyStatus.getRates(2) * (totalIncome-familyStatus.getLimits(2)));
		}
		else {
			tax = familyStatus.getAmountRate(3) + (familyStatus.getRates(3) * (totalIncome-familyStatus.getLimits(3)));
		}
		
		return tax;
	}
	
	
	public String toString(){
		return "Name: "+name
				+"\nAFM: "+afm
				+"\nStatus: "+familyStatus.getStatus()
				+"\nIncome: "+String.format("%.2f", income)
				+"\nBasicTax: "+String.format("%.2f", basicTax)
				+"\nTaxIncrease: "+String.format("%.2f", taxIncrease)
				+"\nTaxDecrease: "+String.format("%.2f", taxDecrease);
	}
	
	public Receipt getReceipt(int receiptID){
		return receipts.get(receiptID);
	}
	
	public ArrayList<Receipt> getReceiptsArrayList(){
		return receipts;
	}
	
	public String[] getReceiptsList(){
		String[] receiptsList = new String[receipts.size()];
		
		int c = 0;
		for (Receipt receipt : receipts){
			receiptsList[c++] = receipt.getId() + " | " + receipt.getDate() + " | " + receipt.getAmount();
		}
		
		return receiptsList;
	}
	// new method getReceiptsAmount
	// type == kind of receipts
	public double[] getReceiptsAmount(String type){
		double typeReceiptsTotalAmount = 0;
		double totalReceiptsTotalAmount = 0;

		for (Receipt receipt : receipts){
			if (receipt.getKind().equals(type)){
				typeReceiptsTotalAmount += receipt.getAmount();
			}
			totalReceiptsTotalAmount += receipt.getAmount();
		}
		double n1 = new BigDecimal(typeReceiptsTotalAmount).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double n2 = new BigDecimal(totalReceiptsTotalAmount).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		return new double[] {n1, n2};
	}
	
	public String getName(){
		return name;
	}
	
	public String getAFM(){
		return afm;
	}
	
	public String getFamilyStatus(){
		return familyStatus.getStatus();
	}
	
	public double getIncome(){
		return (new BigDecimal(income).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
	}
	
	public double getBasicTax(){
		return (new BigDecimal(basicTax).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
	}
	
	public double getTaxInxrease(){
		return (new BigDecimal(taxIncrease).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
	}
	
	public double getTaxDecrease(){
		return (new BigDecimal(taxDecrease).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
	}
	
	public double getTotalTax(){
		return (new BigDecimal(totalTax).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
	}
	
	public void addReceiptToList(Receipt receipt){
		receipts.add(receipt);
		
		calculateTaxpayerTaxIncreaseOrDecreaseBasedOnReceipts();
	}
	
	public void removeReceiptFromList(int index){
		receipts.remove(index);
		
		calculateTaxpayerTaxIncreaseOrDecreaseBasedOnReceipts();
	}
	
	public void calculateTaxpayerTaxIncreaseOrDecreaseBasedOnReceipts(){
		double totalReceiptsAmount = 0;
		for (Receipt receipt : receipts){
			totalReceiptsAmount += receipt.getAmount();
		}
		
		taxIncrease = 0;
		taxDecrease = 0;
		if ((totalReceiptsAmount/(double)income) < 0.2){
			taxIncrease = basicTax * 0.08;
		}
		else if ((totalReceiptsAmount/(double)income) < 0.4){
			taxIncrease = basicTax * 0.04;
		}
		else if ((totalReceiptsAmount/(double)income) < 0.6){
			taxDecrease = basicTax * 0.15;
		}
		else{
			taxDecrease = basicTax * 0.30;
		}
		
		totalTax = basicTax + taxIncrease - taxDecrease;
	}
}