package gsm.report;

import gsm.model.DataConnect;
import gsm.model.History;
import gsm.model.TextConnect;
import gsm.model.VoiceConnect;
import gsm.plan.Plan;

public class ConsoleReportBuilder extends ReportBuilder {

	public ConsoleReportBuilder(Plan plan) {
		super(plan);
	}

	@Override
	public String buildItem(VoiceConnect call) {
		return call.toString();
	}

	@Override
	public String buildItem(TextConnect call) {
		return call.toString();
	}

	@Override
	public String buildItem(DataConnect call) {
		return call.toString();
	}

	@Override
	public void printHeader(History h) {
		System.out.println("Header: " + h);
	}

	@Override
	public void printDetail(String msg) {
		System.out.println("Detail: " + msg);

	}

}
