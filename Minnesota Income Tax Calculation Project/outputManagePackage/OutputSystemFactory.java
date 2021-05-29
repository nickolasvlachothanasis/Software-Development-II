package outputManagePackage;

import java.io.File;
import java.io.FilenameFilter;

public class OutputSystemFactory {
	public static OutputSystem createOutputSystemFiles(File filePath, int taxpayerIndex) {
		OutputSystem outputSystem = new OutputManagePackageTxt(filePath, taxpayerIndex);
		
		if (filePath.getName().toLowerCase().endsWith(".txt")){
			outputSystem = new OutputManagePackageTxt(filePath, taxpayerIndex);
			outputSystem.saveUpdatedTaxpayerInputFile(filePath.getAbsolutePath(), taxpayerIndex);
			return outputSystem;
		}
		if (filePath.getName().toLowerCase().endsWith(".xml")){
			outputSystem = new OutputManagePackageXml(filePath, taxpayerIndex);
			outputSystem.saveUpdatedTaxpayerInputFile(filePath.getAbsolutePath(), taxpayerIndex);
			return outputSystem;
		}
	
		return outputSystem;
	}
	
}
