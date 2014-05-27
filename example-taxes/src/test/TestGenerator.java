package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;

import com.bartoszwalter.students.taxes.TaxCalculator;
import com.bartoszwalter.students.taxes.io.ConsoleBufforPrinter;
import com.bartoszwalter.students.taxes.io.FileService;
import com.bartoszwalter.students.taxes.view.Reader;
import com.bartoszwalter.students.taxes.view.ViewFactory;

public class TestGenerator {

	public static String[][] data = { { "1000" }, { "1"}, { "100000" }, { "100000" ,"SA"} };
	public static String[] type={"P","Z"};
	@Test
	public void test() throws NumberFormatException, IOException {
		
		for (String[] test : data) {
			for (int i = 0; i < 2; i++) {
				String k = test[0];
				String u =type[i];
				if(test.length==2)
					u=test[1];
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
				fs.saveTest(printer.getSb().toString(), "k" + k + u + ".txt");
			}
		}
	}

}
