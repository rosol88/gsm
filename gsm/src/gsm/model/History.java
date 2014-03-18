package gsm.model;

public class History
{

    public History(Phone fromPhone, Phone toPhone, Call call) {
		this.fromPhone=fromPhone;
		this.toPhone=toPhone;
		type=ConnectType.VOICE;
		this.details=call;
	}

    private ConnectType type;
	private Phone fromPhone;

    private Phone toPhone;

    private Network startNetwork;

    private Network endNetwork;
    private HistoryDetail details;

	public ConnectType getType() {
		return type;
	}

	public void setType(ConnectType type) {
		this.type = type;
	}

	public Phone getFromPhone() {
		return fromPhone;
	}

	public void setFromPhone(Phone fromPhone) {
		this.fromPhone = fromPhone;
	}

	public Phone getToPhone() {
		return toPhone;
	}

	public void setToPhone(Phone toPhone) {
		this.toPhone = toPhone;
	}

	public HistoryDetail getDetails() {
		return details;
	}

	public void setDetails(HistoryDetail details) {
		this.details = details;
	}
    
}
