package test.example;

import java.io.FileNotFoundException;
import java.util.List;

import test.example.util.FileUtil;

public class App {
	public static void main(String[] args) throws FileNotFoundException {
		String directoryPath = "F:\\mine\\workspace\\Get_All_Files_In_A_Directory\\";
		String fileExtension = "java";
		List<String> allFiles = FileUtil.recursivelyGetAllFilesInDirectory(directoryPath, fileExtension);
		if (allFiles.isEmpty()) {
			System.out.println("No file found in directory " + directoryPath + " with extension " + fileExtension);
		} else {
			System.out
					.println("List of files in directory " + directoryPath + " with extension " + fileExtension + " -");
			for (String file : allFiles) {
				System.out.println(file);
			}
		}
	}
}
