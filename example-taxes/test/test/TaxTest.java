package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;

import com.bartoszwalter.students.taxes.TaxCalculator;
import com.bartoszwalter.students.taxes.io.ConsoleBufforPrinter;
import com.bartoszwalter.students.taxes.view.Reader;
import com.bartoszwalter.students.taxes.view.ViewFactory;

public class TaxTest {

	@Test
	public void test() throws NumberFormatException, IOException {

		for (String[] test : TestGenerator.data) {
			for (int i = 0; i < 2; i++) {
				String k = test[0];
				String u = TestGenerator.type[i];
				if(test.length==2)
					u=test[1];
				System.out.println("TEST "+k+" "+u);
				TaxCalculator cal = new TaxCalculator();
				ViewFactory vw = mock(ViewFactory.class);
				ConsoleBufforPrinter printer = new ConsoleBufforPrinter();
				when(vw.getPrinter()).thenReturn(printer);
				Reader reader = mock(Reader.class);
				when(reader.readLine()).thenReturn(k).thenReturn(u);
				when(vw.getReader()).thenReturn(reader);
				cal.setViewFactory(vw);
				cal.run();
				FileService fs = new FileService();
				System.out.println("Printer: \n"+printer.getSb().toString());
				System.out.println("File: \n"+fs.readFile("k"+k+u+".txt"));
				assertTrue(printer.getSb().toString().equals(fs.readFile("k"+k+u+".txt")));
			}
		}
	}
	
	@Test
	public void viewFactory() throws NumberFormatException, IOException {
		TaxCalculator cal = new TaxCalculator();
		ViewFactory vf=cal.getViewFactory();
		assertNotNull(vf.getPrinter());
		assertNotNull(vf.getReader());
	}

}
