package test;

import org.junit.Test;

public class FileServiceTest {

	@Test
	public void test() {
		FileService fs=new FileService();
		fs.readFile("k1000p.txt");
	}

}
