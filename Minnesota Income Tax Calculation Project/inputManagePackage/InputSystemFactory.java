package inputManagePackage;

import java.util.List;

public class InputSystemFactory {

	public static InputSystem addTaxpayersDataFromFilesIntoDatabase(String afmInfoFilesFolderPath, List<String> taxpayersAfmInfoFiles){
		InputSystem inputsystem = new InputSystemTxt("","");
		for (String afmInfoFile : taxpayersAfmInfoFiles)
		{
			if (afmInfoFile.endsWith(".txt")){
				inputsystem = new InputSystemTxt(afmInfoFilesFolderPath, afmInfoFile);
				inputsystem.loadTaxpayerDataFromFileIntoDatabase(afmInfoFilesFolderPath, afmInfoFile);
				return inputsystem;
			}
			else if (afmInfoFile.endsWith(".xml")){
				inputsystem = new InputSystemXml(afmInfoFilesFolderPath, afmInfoFile);
				inputsystem.loadTaxpayerDataFromFileIntoDatabase(afmInfoFilesFolderPath, afmInfoFile);
				return inputsystem;
			}
		}
		return inputsystem;
	}
	
}
