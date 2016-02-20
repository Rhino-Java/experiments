package test.example.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static List<String> recursivelyGetAllFilesInDirectory(String directoryPath, final String... fileExtension)
			throws FileNotFoundException {
		List<String> filesList = new ArrayList<>();

		File directory = new File(directoryPath);
		File[] fileObjList;
		if (fileExtension.length == 0) {
			fileObjList = directory.listFiles();
		} else {
			fileObjList = directory.listFiles(new FileFilter() {

				@Override
				public boolean accept(File file) {
					if (file.isDirectory()) {
						return true;
					}
					for (String fileExt : fileExtension) {
						if (file.getAbsolutePath().endsWith(fileExt)) {
							return true;
						}
					}
					return false;
				}
			});
		}
		if (fileObjList == null) {
			throw new FileNotFoundException(directoryPath + " does not exist.");
		}
		for (File file : fileObjList) {
			if (file.isFile()) {
				filesList.add(file.getAbsolutePath());
			} else if (file.isDirectory()) {
				filesList.addAll(recursivelyGetAllFilesInDirectory(file.getAbsolutePath(), fileExtension));
			}
		}
		return filesList;
	}

	public static List<String> getAllFilesInDirectory(String directoryPath, final String... fileExtension)
			throws FileNotFoundException {
		List<String> filesList = new ArrayList<>();

		File directory = new File(directoryPath);

		File[] fileObjList;

		if (fileExtension.length == 0) {
			fileObjList = directory.listFiles();
		} else {
			fileObjList = directory.listFiles(new FileFilter() {

				@Override
				public boolean accept(File file) {
					for (String fileExt : fileExtension) {
						if (file.getAbsolutePath().endsWith(fileExt)) {
							return true;
						}
					}
					return false;
				}
			});
		}
		if (fileObjList == null) {
			throw new FileNotFoundException(directoryPath + " does not exist.");
		}
		for (File file : fileObjList) {
			if (file.isFile()) {
				filesList.add(file.getAbsolutePath());
			}
		}
		return filesList;
	}
}