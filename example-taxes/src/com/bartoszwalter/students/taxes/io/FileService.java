package com.bartoszwalter.students.taxes.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class FileService {

	public String readFile(String name) {
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream(name);
		String s;
		try {
			s = IOUtils.toString(is, "UTF-8");
			System.out.println(s);
			return s;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void saveTest(String content, String name) {
		try {
			File dir = new File("gen");
			if(!dir.exists())
				dir.mkdir();
			File f = new File(dir,name);
			if (!f.exists())
				f.createNewFile();
			FileUtils.writeStringToFile(f, content);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
