package cn.seu.bingluo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

	public Encryption() {
	}

	public String MD5Purity(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			plainText = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return plainText.toUpperCase();
	}
}
