package gsm.model;

import gsm.report.ReportBuilder;

public interface Visitable {
	public String accept(ReportBuilder visitor);
}
