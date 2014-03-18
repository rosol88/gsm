package gsm.model;

import java.util.Date;

public class Call implements HistoryDetail
{

    public Call( Phone fromPhone, Phone toPhone, Network network )
    {
        super();
        this.fromNumber = fromPhone.getNumber();
        this.toNumber = toPhone.getNumber();
        this.startNetwork = network;
        this.startDate = new Date();
    }

    private String fromNumber;

    private String toNumber;

    private Date startDate;

    private Date endDate;

    private Network startNetwork;

    private Network endNetwork;

    public void stop()
    {
        this.endDate = new Date();

    }


	public long getTime() {
		return endDate.getTime()-startDate.getTime();
	}


}
