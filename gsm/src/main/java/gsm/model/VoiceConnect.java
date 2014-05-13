package gsm.model;

import gsm.report.ReportBuilder;

import java.util.Date;

public class VoiceConnect implements HistoryDetail {

	public VoiceConnect(Phone fromPhone, Phone toPhone, Network startNetwork, Network endNetwork) {
		super();
		this.fromNumber = fromPhone.getNumber();
		this.toNumber = toPhone.getNumber();
		this.startNetwork = startNetwork;
		this.endNetwork=endNetwork;
		this.startDate = new Date();
	}

	private String fromNumber;

	private String toNumber;

	private Date startDate;

	private Date endDate;

	private Network startNetwork;

	private Network endNetwork;

	public void stop() {
		this.endDate = new Date();

	}

	public long getTime() {
		return endDate.getTime() - startDate.getTime();
	}

	@Override
	public String accept(ReportBuilder reportBuilder) {

		return reportBuilder.buildItem(this);

	}
}
