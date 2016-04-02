package test.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import test.example.exception.ErrorCodes;
import test.example.exception.ErrorMessages;
import test.example.exception.SampleJasperException;
import test.example.utility.ConfigUtil;
import test.example.utility.DataUtil;

public class App {

	public static void main(String[] args) throws IOException, JRException {

		try {
			System.out.println("Initializing ...");
			generatePdf();
			System.out.println("PDF file is exported successfully. ");
		} catch (SampleJasperException exception) {
			System.out.println("Error in creating PDF report\n" + exception);
		} catch (Exception exception) {
			System.out.println("Error in creating PDF report\n" + exception);
		}
	}

	private static void generatePdf() {
		JREmptyDataSource jREmptyDataSource1 = new JREmptyDataSource();
		JREmptyDataSource jREmptyDataSource2 = new JREmptyDataSource();
		JRBeanCollectionDataSource jRBeanCollectionDataSource1 = new JRBeanCollectionDataSource(
				DataUtil.getSampleData());
		JRBeanCollectionDataSource jRBeanCollectionDataSource2 = new JRBeanCollectionDataSource(
				DataUtil.getSampleData());
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("subReportDataSource1", jRBeanCollectionDataSource1);
		parameters.put("subReportDataSource2", jRBeanCollectionDataSource2);

		try {
			JasperCompileManager.compileReportToFile(ConfigUtil.getInstance().getPart1JrxmlFilePath());
		} catch (JRException e) {
			throw new SampleJasperException(ErrorCodes.JRXML_COMPILATION_ERROR + ":" + ErrorMessages.ERROR_MSG_14, e);
		}
		try {
			JasperCompileManager.compileReportToFile(ConfigUtil.getInstance().getPart2JrxmlFilePath());
		} catch (JRException e) {
			throw new SampleJasperException(ErrorCodes.JRXML_COMPILATION_ERROR + ":" + ErrorMessages.ERROR_MSG_15, e);
		}
		String jasperFilePath = "";
		try {
			jasperFilePath = JasperCompileManager
					.compileReportToFile(ConfigUtil.getInstance().getMasterJrxmlFilePath());
		} catch (JRException e) {
			throw new SampleJasperException(ErrorCodes.JRXML_COMPILATION_ERROR + ":" + ErrorMessages.ERROR_MSG_16, e);
		}
		String lastPageJasperFilePath = "";
		try {
			lastPageJasperFilePath = JasperCompileManager
					.compileReportToFile(ConfigUtil.getInstance().getLastPageJrxmlFilePath());
		} catch (JRException e) {
			throw new SampleJasperException(ErrorCodes.JRXML_COMPILATION_ERROR + ":" + ErrorMessages.ERROR_MSG_17, e);
		}
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(jasperFilePath, parameters, jREmptyDataSource1);
			JasperPrint lastPageJasperPrint = JasperFillManager.fillReport(lastPageJasperFilePath,
					new HashMap<String, Object>(), jREmptyDataSource2);

			for (JRPrintPage jRPrintPage : lastPageJasperPrint.getPages()) {
				jasperPrint.addPage(jRPrintPage);
			}
		} catch (JRException e) {
			throw new SampleJasperException(ErrorCodes.JASPER_DATA_FILLING_ERROR + ":" + ErrorMessages.ERROR_MSG_18, e);
		}
		try {
			JasperExportManager.exportReportToPdfFile(jasperPrint, ConfigUtil.getInstance().getPdfFilePath());
		} catch (JRException e) {
			throw new SampleJasperException(ErrorCodes.PDF_EXPORT_ERROR + ":" + ErrorMessages.ERROR_MSG_19, e);
		}
	}
}