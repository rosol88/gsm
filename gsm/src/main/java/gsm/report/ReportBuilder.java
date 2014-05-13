package gsm.report;

import gsm.model.DataConnect;
import gsm.model.History;
import gsm.model.HistoryDetail;
import gsm.model.TextConnect;
import gsm.model.VoiceConnect;
import gsm.plan.Plan;

import java.util.List;

//visitor
public abstract class ReportBuilder {

	protected Plan plan;

	public ReportBuilder(Plan plan) {
		this.plan = plan;
	}

	public void buildReport(List<History> history) {
		for (History h : history) {
			HistoryDetail hd = h.getDetails();
			printHeader(h);
			String msg = hd.accept(this);
			printDetail(msg);
		}
	}

	public abstract void printHeader(History h);

	public abstract void printDetail(String msg);

	public abstract String buildItem(VoiceConnect call);

	public abstract String buildItem(TextConnect call);

	public abstract String buildItem(DataConnect call);

}