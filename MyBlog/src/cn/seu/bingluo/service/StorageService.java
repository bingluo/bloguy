package cn.seu.bingluo.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StorageService {
	public static String storeImage(byte[] bits, String extension)
			throws IOException {
		String uri = "a.jpg";
		File file = new File("./webapp/static/images/upload/a.jpg");
		if (!file.exists()) {
			file.createNewFile();
		}
		try {
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(file));
			outputStream.write(bits);
			outputStream.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uri;
	}
}
