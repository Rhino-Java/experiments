package test.example;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		Connection conn = null;

		ResultSet rs = null;
		try {
			String databaseConnectionURL = "jdbc:oracle:thin:@" + DatabaseConfiguration.DB_URL + ":"
					+ DatabaseConfiguration.DB_PORT + ":" + DatabaseConfiguration.DB_NAME;

			Class.forName(DatabaseConfiguration.DB_DRIVER).newInstance();

			System.out.println("Connecting with the database ...");
			conn = DriverManager.getConnection(databaseConnectionURL, DatabaseConfiguration.DB_USERNAME,
					DatabaseConfiguration.DB_PASSWORD);

			Statement stmt = conn.createStatement();

			rs = stmt.executeQuery("select FILE_DATA from TEST_TABLE");

			Blob blob;
			int bufferSize = 1024;
			int readBytes;
			byte[] data;
			byte[] buffer;
			while (rs.next()) {

				data = rs.getBytes(1);
				if (data.length != 0) {
					System.out
							.println("Binary data obtained with length " + data.length + "\n" + Arrays.toString(data));
				} else {
					System.out.println("Empty binary data is received from the database");
				}

				blob = rs.getBlob(1);

				InputStream inputStream = blob.getBinaryStream();

				buffer = new byte[bufferSize];

				readBytes = 0;

				byte[] blobData = null;

				while ((readBytes = inputStream.read(buffer)) != -1) {
					if (blobData == null) {
						blobData = new byte[readBytes];
						System.arraycopy(buffer, 0, blobData, 0, readBytes);
					} else {
						byte[] tmpReceviedData = new byte[blobData.length + readBytes];
						System.arraycopy(blobData, 0, tmpReceviedData, 0, blobData.length);
						System.arraycopy(buffer, 0, tmpReceviedData, blobData.length, readBytes);
						blobData = new byte[tmpReceviedData.length];
						System.arraycopy(tmpReceviedData, 0, blobData, 0, tmpReceviedData.length);
					}
				}
				if (blobData != null) {
					System.out.println(
							"Blob data obtained with length " + blobData.length + "\n" + Arrays.toString(blobData));
				} else {
					System.out.println("Empty blob data is received from the database");
				}
				inputStream.close();
			}
			conn.close();
			System.out.println("Disconnected with the database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}