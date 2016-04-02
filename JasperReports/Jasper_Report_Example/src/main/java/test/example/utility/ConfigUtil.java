package test.example.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import test.example.exception.ErrorCodes;
import test.example.exception.ErrorMessages;
import test.example.exception.SampleJasperException;

public class ConfigUtil {

	private static ConfigUtil instance;

	private static boolean instanceCreated;

	private String lastPageJrxmlFilePath;

	private String masterJrxmlFilePath;

	private String pdfFilePath;

	private String part1JrxmlFilePath;

	private String part2JrxmlFilePath;

	private ConfigUtil() {
		validateConfigFilePath(Constants.CONFIG_FILE_PATH);
		File file = new File(Constants.CONFIG_FILE_PATH);

		try (InputStream inputStream = new FileInputStream(file)) {
			Properties properties = new Properties();
			properties.load(inputStream);
			String temp = properties.getProperty(Constants.MASTER_JRXML_FILE_PATH);
			if (temp != null && !temp.trim().isEmpty()) {
				masterJrxmlFilePath = temp.trim();
			} else {
				throw new SampleJasperException(ErrorCodes.CONFIG_FILE_ERROR + ":" + ErrorMessages.ERROR_MSG_1);
			}
			temp = properties.getProperty(Constants.PART1_JRXML_FILE_PATH);
			if (temp != null && !temp.trim().isEmpty()) {
				part1JrxmlFilePath = temp.trim();
			} else {
				throw new SampleJasperException(ErrorCodes.CONFIG_FILE_ERROR + ":" + ErrorMessages.ERROR_MSG_2);
			}
			temp = properties.getProperty(Constants.PART2_JRXML_FILE_PATH);
			if (temp != null && !temp.trim().isEmpty()) {
				part2JrxmlFilePath = temp.trim();
			} else {
				throw new SampleJasperException(ErrorCodes.CONFIG_FILE_ERROR + ":" + ErrorMessages.ERROR_MSG_3);
			}
			temp = properties.getProperty(Constants.LAST_PAGE_JRXML_FILE_PATH);
			if (temp != null && !temp.trim().isEmpty()) {
				lastPageJrxmlFilePath = temp.trim();
			} else {
				throw new SampleJasperException(ErrorCodes.CONFIG_FILE_ERROR + ":" + ErrorMessages.ERROR_MSG_4);
			}
			temp = properties.getProperty(Constants.PDF_FILE_PATH);
			if (temp != null && !temp.trim().isEmpty()) {
				pdfFilePath = temp.trim();
			} else {
				throw new SampleJasperException(ErrorCodes.CONFIG_FILE_ERROR + ":" + ErrorMessages.ERROR_MSG_5);
			}
		} catch (IOException exception) {
			throw new SampleJasperException(ErrorCodes.CONFIG_FILE_ERROR + ":" + ErrorMessages.ERROR_MSG_9, exception);
		}
		validate();
	}

	private void validate() {
		if (!CommonUtil.isFilePathValid(masterJrxmlFilePath)) {
			throw new SampleJasperException(ErrorCodes.INPUT_FILES_NOT_FOUND + ":" + ErrorMessages.ERROR_MSG_10);
		}
		if (!CommonUtil.isFilePathValid(part1JrxmlFilePath)) {
			throw new SampleJasperException(ErrorCodes.INPUT_FILES_NOT_FOUND + ":" + ErrorMessages.ERROR_MSG_11);
		}
		if (!CommonUtil.isFilePathValid(part2JrxmlFilePath)) {
			throw new SampleJasperException(ErrorCodes.INPUT_FILES_NOT_FOUND + ":" + ErrorMessages.ERROR_MSG_12);
		}
		if (!CommonUtil.isFilePathValid(lastPageJrxmlFilePath)) {
			throw new SampleJasperException(ErrorCodes.INPUT_FILES_NOT_FOUND + ":" + ErrorMessages.ERROR_MSG_13);
		}
	}

	private void validateConfigFilePath(String configFilePath) {
		if (!CommonUtil.isFilePathValid(configFilePath)) {
			throw new SampleJasperException(ErrorCodes.CONFIG_FILE_ERROR + ":" + ErrorMessages.ERROR_MSG_8);
		}
	}

	public static ConfigUtil getInstance() {
		if (!instanceCreated) {
			synchronized (ConfigUtil.class) {
				if (!instanceCreated) {
					instance = new ConfigUtil();
					instanceCreated = true;
				}
			}
		}
		return instance;
	}

	public String getLastPageJrxmlFilePath() {
		return lastPageJrxmlFilePath;
	}

	public String getMasterJrxmlFilePath() {
		return masterJrxmlFilePath;
	}

	public String getPdfFilePath() {
		return pdfFilePath;
	}

	public String getPart1JrxmlFilePath() {
		return part1JrxmlFilePath;
	}

	public String getPart2JrxmlFilePath() {
		return part2JrxmlFilePath;
	}

	public void setLastPageJrxmlFilePath(String lastPageJrxmlFilePath) {
		this.lastPageJrxmlFilePath = lastPageJrxmlFilePath;
	}

	public void setMasterJrxmlFilePath(String masterJrxmlFilePath) {
		this.masterJrxmlFilePath = masterJrxmlFilePath;
	}

	public void setPdfFilePath(String pdfFilePath) {
		this.pdfFilePath = pdfFilePath;
	}

	public void setPart1JrxmlFilePath(String part1JrxmlFilePath) {
		this.part1JrxmlFilePath = part1JrxmlFilePath;
	}

	public void setPart2JrxmlFilePath(String part2JrxmlFilePath) {
		this.part2JrxmlFilePath = part2JrxmlFilePath;
	}

}
