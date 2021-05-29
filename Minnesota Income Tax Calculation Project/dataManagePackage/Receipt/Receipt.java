package dataManagePackage.Receipt;

import java.math.BigDecimal;

public class Receipt {
	private String kind;
	private String id;
	private String date;
	private double amount;
	private Company company;
	
	public Receipt(String kind, String id, String date, String amount, String name, String country, String city, String street, String number){
		if (kind.equalsIgnoreCase("Entertainment") || kind.equalsIgnoreCase("Basic") || kind.equalsIgnoreCase("Travel") || kind.equalsIgnoreCase("Health") || kind.equalsIgnoreCase("Other")){
			this.kind = kind;
			this.id = id;
			this.date = date;
			this.amount = Double.parseDouble(amount);
			this.company = new Company(name, country, city, street, number);
		}
		else{
			this.kind = null;
			this.id = null;
			this.date = null;
			this.amount = Double.parseDouble(null);
			this.company = new Company(null, null, null, null, null);
		}
	}
	
	public String getId(){
		return id;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getKind(){
		return kind;
	}
	
	public double getAmount(){
		return (new BigDecimal(amount).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
	}
	
	public Company getCompany(){
		return company;
	}
	
	public String toString(){
		return "ID: "+id
				+"\nDate: "+date
				+"\nKind: "+kind
				+"\nAmount: "+String.format("%.2f", amount)
				+"\nCompany: "+company.getName()
				+"\nCountry: "+company.getCountry()
				+"\nCity: "+company.getCity()
				+"\nStreet: "+company.getStreet()
				+"\nNumber: "+company.getNumber();
	}
}