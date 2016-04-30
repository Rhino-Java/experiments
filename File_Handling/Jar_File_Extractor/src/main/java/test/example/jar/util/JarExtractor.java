package test.example.jar.util;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import test.example.util.FileCopier;

public class JarExtractor {

	public static void extract(String jarFilePath, String extractToDirectoryPath) throws IOException {

		try (JarFile jarFile = new JarFile(jarFilePath)) {
			Enumeration<JarEntry> jarFileEntries = jarFile.entries();
			while (jarFileEntries.hasMoreElements()) {
				JarEntry jarEntry = jarFileEntries.nextElement();
				File file = new File(extractToDirectoryPath + File.separator + jarEntry.getName());
				if (jarEntry.isDirectory()) { // if its a directory, create it
					file.mkdirs();
					continue;
				}
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				FileCopier.copy(jarFile.getInputStream(jarEntry), file);
			}
		}
	}
}