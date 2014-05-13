package gsm.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.inject.Singleton;

@Singleton
public class MainConnector implements Connector {

	private List<Network> networks = new ArrayList<Network>();
	
	@Override
	public VoiceConnect call(String fromNumber, String toNumber) {

		Phone fromPhone = getPhone(fromNumber);
		Phone toPhone = getPhone(toNumber);
		Network fromNetwork = fromPhone.getNetwork();
		Network toNetwork = toPhone.getNetwork();
		VoiceConnect call = new VoiceConnect(fromPhone, toPhone, fromNetwork,
				toNetwork);
		History hist = new History(fromPhone, toPhone, call);
		fromPhone.getOperator().addHistory(hist);
		return call;
	}

	public Phone getPhone(String fromNumber) {
		for (Network net : networks) {
			Phone p = net.getPhone(fromNumber);
			if (p != null)
				return p;
		}
		Set<Connector> visited=new HashSet<Connector>();
		visited.add(this);
		for (Network net : networks) {
			for(Connector con:net.getConnectors()){
				if(!visited.contains(con)){
					Phone p=con.getPhone(fromNumber);
					visited.add(con);
					return p;
				}
			}
		}
		return null;
	}

	@Override
	public void registerNetwork(Network network) {
		networks.add(network);
		network.getConnectors().add(this);
	}
}
