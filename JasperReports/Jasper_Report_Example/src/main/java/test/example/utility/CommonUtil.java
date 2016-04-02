package test.example.utility;

import java.io.File;

public class CommonUtil {

	public static boolean isFilePathValid(String filePath) {
		File file = new File(filePath);
		boolean result = false;
		if (file.exists() && file.isFile()) {
			result = true;
		}
		return result;
	}
}
