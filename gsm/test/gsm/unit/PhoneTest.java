package gsm.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import gsm.exeption.NoNetworkException;
import gsm.model.Call;
import gsm.model.Network;
import gsm.model.Operator;
import gsm.model.Phone;
import gsm.plan.Plan;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PhoneTest {

	@Mock
	Plan plan;
	@Mock
	Plan plan2;
	@Mock
	Operator operator;

	@Mock
	Network network;

	@Mock
	Call call;

	@Mock
	Phone testPhone;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(plan.getOperator()).thenReturn(operator);
		when(plan2.getOperator()).thenReturn(operator);
	}

	@Test(expected = NoNetworkException.class)
	public void sendTextNoNetwork() {
		Phone phone = new Phone("123", plan);
		phone.sendText("321", "abc");
	}

	@Test
	public void sendText() {
		Phone phone = new Phone("123", plan);
		phone.setNetwork(network);
		phone.sendText("321", "abc");
		verify(network).sendText("123", "321", "abc");
	}

	@Test
	public void receiveText() {

		// when(testPhone.sendText("321", "abc"));
		testPhone.sendText("321", "abc");

		Phone phone2 = new Phone("321", plan);
		phone2.setNetwork(network);

		testPhone.sendText("321", "abc");

		// verify(phone2).receiveText(message);
	}

	@Test
	public void callTest() {
		Phone phone = new Phone("123", plan);
		phone.setNetwork(network);
		when(network.call("123", "321")).thenReturn(call);
		phone.startCall("321");
		phone.stopCall();
		verify(network).call("123", "321");
		verify(call).stop();
	}

	@Test
	public void equalsTest() {
		Phone phone = new Phone("123", plan);
		Phone phone2 = new Phone("123", plan2);
		assertEquals(phone, phone2);
	}

}
