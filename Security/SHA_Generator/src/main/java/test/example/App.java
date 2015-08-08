package test.example;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		System.out.println("Enter the text to be hashed -");
		Scanner scanner = new Scanner(System.in);
		String textToBeHashed = scanner.next();
		scanner.close();

		byte[] hashedBytes = ShaGenerator.generateSha256Hash(textToBeHashed);
		System.out.println("Length of hashed byte array " + hashedBytes.length);
		String hashedHexString = convertByteArrayToHexString(hashedBytes);
		System.out.println("Hashed Hex String \'" + hashedHexString + "\' with length " + hashedHexString.length());

	}

	private static String convertByteArrayToHexString(byte[] arrayBytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < arrayBytes.length; i++) {
			stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return stringBuffer.toString();
	}
}
