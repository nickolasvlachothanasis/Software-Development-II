package dataManagePackage;
import inputManagePackage.*;
import outputManagePackage.*;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class Database {
	private String taxpayersInfoFilesPath;
	private ArrayList<Taxpayer> taxpayersArrayList = new ArrayList<Taxpayer>();
	private static Database instance;
	
	private Database () {}
	
	public static Database getInstance() {
		if(instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	
	public void setTaxpayersInfoFilesPath(String taxpayersInfoFilesPath){
		this.taxpayersInfoFilesPath = taxpayersInfoFilesPath;
	}
	
	public String getTaxpayersInfoFilesPath(){
		return taxpayersInfoFilesPath;
	}
	
	public void proccessTaxpayersDataFromFilesIntoDatabase(String afmInfoFilesFolderPath, List<String> taxpayersAfmInfoFiles){
		
		InputSystem  inputSystemFactory =  InputSystemFactory.addTaxpayersDataFromFilesIntoDatabase(afmInfoFilesFolderPath, taxpayersAfmInfoFiles);
	}
	
	public void addTaxpayerToList(Taxpayer taxpayer){
		taxpayersArrayList.add(taxpayer);
	}
	
	public int getTaxpayersArrayListSize(){
		return taxpayersArrayList.size();
	}
	
	public Taxpayer getTaxpayerFromArrayList(int index){
		return taxpayersArrayList.get(index);
	}
	
	public void removeTaxpayerFromArrayList(int index){
		taxpayersArrayList.remove(index);
	}
	
	public String getTaxpayerNameAfmValuesPairList(int index){
		Taxpayer taxpayer = taxpayersArrayList.get(index);
		return taxpayer.getName() + " | " + taxpayer.getAFM();
	}
	
	public String[] getTaxpayersNameAfmValuesPairList(){
		String[] taxpayersNameAfmValuesPairList = new String[taxpayersArrayList.size()];
		
		int c = 0;
		for (Taxpayer taxpayer : taxpayersArrayList){
			taxpayersNameAfmValuesPairList[c++] = taxpayer.getName() + " | " + taxpayer.getAFM();
		}
		
		return taxpayersNameAfmValuesPairList;
	}
	
	public void updateTaxpayerInputFile(int index){
		File taxpayersInfoFilesPathFileObject = new File(taxpayersInfoFilesPath);
		FilenameFilter fileNameFilter = new FilenameFilter(){
            public boolean accept(File dir, String name) {
               return (name.toLowerCase().endsWith("_info.txt") || name.toLowerCase().endsWith("_info.xml"));
            }
         };
		
		for (File file : taxpayersInfoFilesPathFileObject.listFiles(fileNameFilter)){
			if (!file.getName().contains(taxpayersArrayList.get(index).getAFM())) continue;
			OutputSystem outputSystem = OutputSystemFactory.createOutputSystemFiles(file, index);
		}
	}	
}