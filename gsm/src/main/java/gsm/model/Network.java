package gsm.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Network {
	private Set<Connector> connectors=new HashSet<Connector>();

	public Set<Connector> getConnectors() {
		return connectors;
	}

	public void setConnectors(Set<Connector> connectors) {
		this.connectors = connectors;
	}

	public Network(Operator operator) {
		super();
		this.operator = operator;
	}

	List<Phone> phones = new ArrayList<Phone>();

	List<History> history;

	private Operator operator;

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public void sendText(String fromNumber, String toNumber, String text) {
		// validateNumbers( fromNumber, toNumber );

		Phone fromPhone = getPhone(fromNumber);
		Phone toPhone = getPhone(toNumber);

		validatePhones(fromPhone, toPhone);

		toPhone.receiveText(new Message(fromPhone, text));

	}

	private void validatePhones(Phone fromPhone, Phone toPhone) {
		// TODO Auto-generated method stub

	}

	public Phone getPhone(String number) {
		for (Phone phone : phones) {
			if (phone.getNumber().equals(number))
				return phone;
		}
		return null;
	}

	public VoiceConnect call(String fromNumber, String toNumber) {
		VoiceConnect call = null;
		for (Connector con : connectors) {
			call = con.call(fromNumber, toNumber);
			if (call != null)
				break;
		}
		return call;
	}

	public void addPhone(Phone phone) {
		phones.add(phone);

	}

}
