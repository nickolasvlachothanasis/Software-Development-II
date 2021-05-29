package outputManagePackage;
import dataManagePackage.*;
import dataManagePackage.Receipt.Receipt;

import java.awt.Dialog.ModalExclusionType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public abstract class OutputSystem {
	private File filePath;
	private int taxpayerIndex;
	private static DefaultPieDataset receiptPieChartDataset;
	private static JFreeChart receiptPieJFreeChart;
	private static PiePlot piePlot;
	private static ChartFrame receiptPieChartFrame;
	public OutputSystem(File filePath, int taxpayerIndex) {
		this.filePath=  filePath;
		this.taxpayerIndex = taxpayerIndex;
	}
	public OutputSystem() {}
	
	public abstract void saveTaxpayerInfoToLogFile(String folderSavePath, int taxpayerIndex);
	public abstract void saveUpdatedTaxpayerInputFile(String filePath, int taxpayerIndex);
	
	public  DefaultPieDataset getReceiptPieChartDataset() {
		return receiptPieChartDataset;
	}

	public  JFreeChart getReceiptPieJFreeChart() {
		return receiptPieJFreeChart;
	}

	public  PiePlot getPiePlot() {
		return piePlot;
	}

	public  ChartFrame getReceiptPieChartFrame() {
		return receiptPieChartFrame;
	}

	public static void createTaxpayerReceiptsPieJFreeChart(int taxpayerIndex){
		receiptPieChartDataset = new DefaultPieDataset();
		Database database = Database.getInstance();
		Taxpayer taxpayer = database.getTaxpayerFromArrayList(taxpayerIndex);
		
		receiptPieChartDataset.setValue("Basic", taxpayer.getReceiptsAmount("Basic")[0]);
		receiptPieChartDataset.setValue("Entertainment", taxpayer.getReceiptsAmount("Entertainment")[0]);
		receiptPieChartDataset.setValue("Travel", taxpayer.getReceiptsAmount("Travel")[0]);
		receiptPieChartDataset.setValue("Health", taxpayer.getReceiptsAmount("Health")[0]);
		receiptPieChartDataset.setValue("Other", taxpayer.getReceiptsAmount("Other")[0]);
		
		receiptPieJFreeChart = ChartFactory.createPieChart("Receipt Pie Chart", receiptPieChartDataset);
		piePlot = (PiePlot)receiptPieJFreeChart.getPlot();
		PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator("{0}: {1}$ ({2})", new DecimalFormat("0.00"), new DecimalFormat("0.00%"));
		piePlot.setLabelGenerator(generator); 

		receiptPieChartFrame = new ChartFrame(database.getTaxpayerNameAfmValuesPairList(taxpayerIndex), receiptPieJFreeChart);
		receiptPieChartFrame.pack();
		receiptPieChartFrame.setResizable(false);
		receiptPieChartFrame.setLocationRelativeTo(null);
		receiptPieChartFrame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		receiptPieChartFrame.setVisible(true);
	}
	
	public static void createTaxpayerTaxAnalysisBarJFreeChart(int taxpayerIndex){
		DefaultCategoryDataset taxAnalysisBarChartDataset = new DefaultCategoryDataset();
		Database database = Database.getInstance();
		Taxpayer taxpayer = database.getTaxpayerFromArrayList(taxpayerIndex);
		
		String taxVariationType = taxpayer.getTaxInxrease()!=0? "Tax Increase" : "Tax Decrease";
		double taxVariationAmount = taxpayer.getTaxInxrease()!=0? taxpayer.getTaxInxrease() : taxpayer.getTaxDecrease()*(-1);
		
		taxAnalysisBarChartDataset.setValue(taxpayer.getBasicTax(), "Tax", "Basic Tax");
		taxAnalysisBarChartDataset.setValue(taxVariationAmount, "Tax", taxVariationType);
		taxAnalysisBarChartDataset.setValue(taxpayer.getTotalTax(), "Tax", "Total Tax");

		JFreeChart taxAnalysisJFreeChart = ChartFactory.createBarChart("Tax Analysis Bar Chart", "",  "Tax Analysis in $", taxAnalysisBarChartDataset, PlotOrientation.VERTICAL, true, true, false);

		ChartFrame receiptPieChartFrame = new ChartFrame(database.getTaxpayerNameAfmValuesPairList(taxpayerIndex), taxAnalysisJFreeChart);
		receiptPieChartFrame.pack();
		receiptPieChartFrame.setResizable(false);
		receiptPieChartFrame.setLocationRelativeTo(null);
		receiptPieChartFrame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		receiptPieChartFrame.setVisible(true);
	}
}
