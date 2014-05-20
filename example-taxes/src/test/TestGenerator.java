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

	String[][] data={{"1000","P"},{"100000","P"}};
	@Test
	public void test() throws NumberFormatException, IOException {
		for(String[] test:data){
			String k=test[0];
			String u=test[1];
		TaxCalculator cal=new TaxCalculator();
		ViewFactory vw=mock(ViewFactory.class);
		ConsoleBufforPrinter printer=new ConsoleBufforPrinter();
		when(vw.getPrinter()).thenReturn(printer);
		Reader reader=mock(Reader.class);
		when(reader.readLine()).thenReturn(k).thenReturn(u);
		when(vw.getReader()).thenReturn(reader);
		cal.setViewFactory(vw);
		cal.run();
		FileService fs=new FileService();
		fs.saveTest(printer.getSb().toString(),"k"+k+u+".txt");
		}
	}

}
