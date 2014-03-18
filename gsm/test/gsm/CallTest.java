package gsm;

import static org.junit.Assert.assertEquals;
import gsm.model.Bill;
import gsm.model.ConnectType;
import gsm.model.History;
import gsm.model.Phone;

import java.util.List;

import org.junit.Test;

public class CallTest {

	private TestWorld world=new TestWorld();
	@Test
	public void voiceCall() throws InterruptedException {
		String fromNum="555555555";
		String toNum="666666666";
		Phone from=world.getPhone(fromNum);
		Phone to=world.getPhone(toNum);
		from.startCall(toNum);
		Thread.sleep(1000);
		from.stopCall();
		
		List<History> history=from.getOperator().getHistory(fromNum);
		assertEquals("Nieprawidłowa ilość pozycji historii",1,history.size());
		History hist=history.get(0);
		assertEquals("Nieprawidłowy telefon rozpoczynający",from,hist.getFromPhone());
		assertEquals("Nieprawidłowy telefon odbierający",to,hist.getToPhone());
		assertEquals("Nieprawidłowy typ połączenia",ConnectType.VOICE,hist.getType());
		
		Bill bill=from.getOperator().getBill(from.getNumber());
	}

}
