package test;

import org.junit.Test;

import com.bartoszwalter.students.taxes.io.FileService;

public class FileServiceTest {

	@Test
	public void test() {
		FileService fs=new FileService();
		fs.readFile("k1000p.txt");
	}

}
