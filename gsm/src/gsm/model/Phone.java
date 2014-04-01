package gsm.model;

import gsm.exeption.NoNetworkException;
import gsm.plan.Plan;

import java.util.ArrayList;
import java.util.List;

public class Phone {

	private String number;

	private Network network;

	private List<Message> messages = new ArrayList<Message>();

	private Call call;

	public Phone(String number, Plan plan) {
		super();
		this.number = number;
		this.plan = plan;
		getOperator().addPhone(this);
	}

	private Plan plan;

	public Operator getOperator() {
		return plan.getOperator();
	}

	public String getNumber() {
		return number;
	}

	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
		network.addPhone(this);
	}

	public Plan getPlan() {
		return plan;
	}

	public void sendText(String number, String text) {
		checkNetwork();
		getNetwork().sendText(getNumber(), number, text);
	}

	private void checkNetwork() {
		if (getNetwork() == null)
			throw new NoNetworkException();

	}

	public void startCall(String number) {
		call = getNetwork().call(getNumber(), number);
	}

	public void stopCall() {
		call.stop();
	}

	public void sendData(Object data) {

	}

	public void getData() {

	}

	public void receiveText(Message message) {
		messages.add(message);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

}
