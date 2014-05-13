package gsm.model;

public interface Connector {

	VoiceConnect call( String fromNumber, String toNumber );
	void registerNetwork(Network network);
	public Phone getPhone(String fromNumber);
}
