package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dataManagePackage.FamilyStatus;

public class FamilyStatusTest {

	@Test
	public void marriedfilingjointlyTest() {
		FamilyStatus familyStatus = new FamilyStatus("married filing jointly");
		double[][] myD = new double[][] {{36080.0,1930.28,7.05/100},{90000.0,5731.24,7.05/100},{143350.0,9492.82,7.85/100},{254240.0,18197.69,9.85/100}};
		double[] myLimits = new double[4];
		double[] myAmountRate = new double[4];
		double[] myRates = new double[4];
		for (int i=0;i<4;i++){
			myLimits[i] = myD[i][0];
			myAmountRate[i] = myD[i][1];
			myRates[i] = myD[i][2];
		}
		String expected ="";
		String actual ="";
		for(int i=0; i<4; i++) {
			expected =""+myLimits[i];
			actual = ""+familyStatus.getLimits(i);
			assertEquals(expected, actual);
			expected =""+myAmountRate[i];
			actual = ""+familyStatus.getAmountRate(i);
			assertEquals(expected, actual);
			expected =""+myRates[i];
			actual = ""+familyStatus.getRates(i);
			assertEquals(expected, actual);
		}	
	}
	@Test
	public void marriedfilingseparatelyTest() {
		FamilyStatus familyStatus = new FamilyStatus("married filing separately");
		double[][] myD = new double[][] {{18040.0,965.14,7.05/100},{71680.0,4746.76,7.85/100},{90000.0,6184.88,7.85/100},{127120.0,9098.80,9.85/100}};
		double[] myLimits = new double[4];
		double[] myAmountRate = new double[4];
		double[] myRates = new double[4];
		for (int i=0;i<4;i++){
			myLimits[i] = myD[i][0];
			myAmountRate[i] = myD[i][1];
			myRates[i] = myD[i][2];
		}
		String expected ="";
		String actual ="";
		for(int i=0; i<4; i++) {
			expected =""+myLimits[i];
			actual = ""+familyStatus.getLimits(i);
			assertEquals(expected, actual);
			expected =""+myAmountRate[i];
			actual = ""+familyStatus.getAmountRate(i);
			assertEquals(expected, actual);
			expected =""+myRates[i];
			actual = ""+familyStatus.getRates(i);
			assertEquals(expected, actual);
		}	
	}
	@Test
	public void singleTest() {
		FamilyStatus familyStatus = new FamilyStatus("single");
		double[][] myD = new double[][] {{24680.0,1320.38,7.05/100},{81080.0,5296.58,7.85/100},{90000.0,5996.80,7.85/100},{152540.0,10906.19,9.85/100}};
		double[] myLimits = new double[4];
		double[] myAmountRate = new double[4];
		double[] myRates = new double[4];
		for (int i=0;i<4;i++){
			myLimits[i] = myD[i][0];
			myAmountRate[i] = myD[i][1];
			myRates[i] = myD[i][2];
		}
		String expected ="";
		String actual ="";
		for(int i=0; i<4; i++) {
			expected =""+myLimits[i];
			actual = ""+familyStatus.getLimits(i);
			assertEquals(expected, actual);
			expected =""+myAmountRate[i];
			actual = ""+familyStatus.getAmountRate(i);
			assertEquals(expected, actual);
			expected =""+myRates[i];
			actual = ""+familyStatus.getRates(i);
			assertEquals(expected, actual);
		}	
	}
	@Test
	public void elseTest() {
		FamilyStatus familyStatus = new FamilyStatus("else");
		double[][] myD = new double[][] {{30390.0,1625.87,7.05/100},{90000.0,5828.38,7.05/100},{122110.0,8092.13,7.85/100},{203390.0,14472.61,9.85/100}};
		double[] myLimits = new double[4];
		double[] myAmountRate = new double[4];
		double[] myRates = new double[4];
		for (int i=0;i<4;i++){
			myLimits[i] = myD[i][0];
			myAmountRate[i] = myD[i][1];
			myRates[i] = myD[i][2];
		}
		String expected ="";
		String actual ="";
		for(int i=0; i<4; i++) {
			expected =""+myLimits[i];
			actual = ""+familyStatus.getLimits(i);
			assertEquals(expected, actual);
			expected =""+myAmountRate[i];
			actual = ""+familyStatus.getAmountRate(i);
			assertEquals(expected, actual);
			expected =""+myRates[i];
			actual = ""+familyStatus.getRates(i);
			assertEquals(expected, actual);
		}	
	}
}
