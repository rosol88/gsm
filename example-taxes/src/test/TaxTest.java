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
public class TaxTest {

	@Test
	public void test() throws NumberFormatException, IOException {
		TaxCalculator cal=new TaxCalculator();
		ViewFactory vw=mock(ViewFactory.class);
		ConsoleBufforPrinter printer=new ConsoleBufforPrinter();
		when(vw.getPrinter()).thenReturn(printer);
		Reader reader=mock(Reader.class);
		when(reader.readLine()).thenReturn("1000").thenReturn("P");
		when(vw.getReader()).thenReturn(reader);
		cal.setViewFactory(vw);
		cal.run();
		FileService fs=new FileService();
		printer.getSb().toString().equals(fs.readFile("k1000p.txt"));
	}

}
