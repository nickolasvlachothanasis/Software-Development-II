package inputManagePackage;
import java.util.List;

import dataManagePackage.Database;
import dataManagePackage.Taxpayer;
import dataManagePackage.Receipt.Receipt;

public abstract class InputSystem {
	private String afmInfoFileFolderPath;
	private String afmInfoFile;
	public InputSystem(String afmInfoFileFolderPath, String afmInfoFile) {
		this.afmInfoFileFolderPath = afmInfoFileFolderPath;
		this.afmInfoFile = afmInfoFile;
	}
	public abstract void loadTaxpayerDataFromFileIntoDatabase(String afmInfoFileFolderPath, String afmInfoFile);
	public abstract String getParameterValueFromFileLine(String fileLine, String parameterStartField, String parameterEndField);
	public abstract Database getDatabase();
	public String getafmInfoFileFolderPath() {
		return this.afmInfoFileFolderPath;
	}
	public String getafmInfoFile() {
		return this.afmInfoFile;
	}
}
