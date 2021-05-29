package dataManagePackage;
import java.util.HashMap;
import java.util.Map;

public class FamilyStatus {
	private double[] limits = new double[4];
	private double[] amountRate = new double[4];
	private double[] rates = new double[4];
	private String status;

	public FamilyStatus(String status) {
		this.status=status;
		if (this.status == "married filing jointly") {
			double[][] d = new double[][] {{36080.0,1930.28,7.05/100},{90000.0,5731.24,7.05/100},{143350.0,9492.82,7.85/100},{254240.0,18197.69,9.85/100}};
			doWork(d);
		}
		else if(this.status == "married filing separately") {
			double[][] d =  new double[][] {{18040.0,965.14,7.05/100},{71680.0,4746.76,7.85/100},{90000.0,6184.88,7.85/100},{127120.0,9098.80,9.85/100}};
			doWork(d);
		}
		else if(this.status == "single") {
			double[][] d =  new double[][] {{24680.0,1320.38,7.05/100},{81080.0,5296.58,7.85/100},{90000.0,5996.80,7.85/100},{152540.0,10906.19,9.85/100}};
			doWork(d);
		}
		else {
			double[][] d =  new double[][] {{30390.0,1625.87,7.05/100},{90000.0,5828.38,7.05/100},{122110.0,8092.13,7.85/100},{203390.0,14472.61,9.85/100}};
			doWork(d);
		}
		
	}
	public void doWork(double[][] d) {
		for (int i=0;i<4;i++){
			this.limits[i] = d[i][0];
			this.amountRate[i] = d[i][1];
			this.rates[i] = d[i][2];
		}
	}

	public double getLimits(int i) {
		return limits[i];
	}


	public double getAmountRate(int i) {
		return amountRate[i];
	}

	public double getRates(int i) {
		return rates[i];
	}

	public String getStatus() {
		return status;
	}


}
