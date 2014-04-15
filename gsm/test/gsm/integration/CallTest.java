package gsm.integration;

import static org.junit.Assert.assertEquals;
import gsm.model.Bill;
import gsm.model.ConnectType;
import gsm.model.History;
import gsm.model.Phone;
import gsm.report.ConsoleReportBuilder;
import gsm.report.ReportBuilder;

import java.util.List;

import org.junit.Test;

public class CallTest {

	private TestWorld world = new TestWorld();

	@Test
	public void voiceCall() throws InterruptedException {
		String fromNum = "555555555";
		String toNum = "666666666";
		Phone from = world.getPhone(fromNum);
		Phone to = world.getPhone(toNum);
		from.startCall(toNum);
		Thread.sleep(1000);
		from.stopCall();

		List<History> history = from.getOperator().getHistory(fromNum);
		assertEquals("Nieprawid³owa iloœæ pozycji historii", 1, history.size());
		History hist = history.get(0);
		assertEquals("Nieprawid³owy telefon rozpoczynaj¹cy", from,
				hist.getFromPhone());
		assertEquals("Nieprawid³owy telefon odbieraj¹cy", to, hist.getToPhone());
		assertEquals("Nieprawid³owy typ po³¹czenia", ConnectType.VOICE,
				hist.getType());

		Bill bill = from.getOperator().getBill(from.getNumber());
		assertEquals("Nieprawid³owa kwota", 1, bill.getPrice(), 0.0001);
	}

	@Test
	public void report() throws InterruptedException {
		String fromNum = "555555555";
		String toNum = "666666666";
		Phone from = world.getPhone(fromNum);
		Phone to = world.getPhone(toNum);
		from.startCall(toNum);
		Thread.sleep(1000);
		from.stopCall();

		List<History> history = from.getOperator().getHistory(fromNum);
		assertEquals("Nieprawid³owa iloœæ pozycji historii", 1, history.size());
		ReportBuilder rb = new ConsoleReportBuilder(from.getPlan());

		rb.buildReport(history);

	}

}
