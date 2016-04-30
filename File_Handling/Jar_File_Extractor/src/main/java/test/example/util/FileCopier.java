package test.example.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class FileCopier {

	public static void copy(String sourceFilePath, String destinationFilePath) throws IOException {
		copy(new File(sourceFilePath), new File(destinationFilePath));

	}

	public static void copy(File sourceFile, File destinationFile) throws IOException {
		try (FileChannel inputFileChannel = new FileInputStream(sourceFile).getChannel()) {
			copy(inputFileChannel, destinationFile);
		}
	}

	public static void copy(InputStream inputStream, String destinationFilePath) throws IOException {
		copy(inputStream, new File(destinationFilePath));
	}

	public static void copy(InputStream inputStream, File destinationFile) throws IOException {
		try (ReadableByteChannel inputChannel = Channels.newChannel(inputStream)) {
			copy(inputChannel, destinationFile);
		}
	}

	public static void copy(ReadableByteChannel inputChannel, File destinationFile) throws IOException {
		long offset = 0;
		long noOfBytesToTransferred = 1024;
		long bytesTransferred;
		/**
		 * Closing FileChannel also closes underlying file streams. So, there is
		 * no need to close file streams separately.
		 */
		try (FileChannel outputFileChannel = new FileOutputStream(destinationFile).getChannel()) {
			while ((bytesTransferred = outputFileChannel.transferFrom(inputChannel, offset,
					noOfBytesToTransferred)) > 0) {
				offset += bytesTransferred;
			}
		}
	}
}