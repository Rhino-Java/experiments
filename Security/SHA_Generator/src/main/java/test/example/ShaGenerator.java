package test.example;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaGenerator {

	public static byte[] generateSha256Hash(String textToBeHashed)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		return md.digest(textToBeHashed.getBytes("UTF-8"));
	}
}
