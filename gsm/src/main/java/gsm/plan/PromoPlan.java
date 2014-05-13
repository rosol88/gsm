package gsm.plan;

import java.util.List;

import gsm.model.ConnectType;
import gsm.model.History;
import gsm.model.Operator;

public class PromoPlan implements Plan {

	private Plan plan;

	private final int SMS_COUNT = 100;

	public PromoPlan(Plan plan) {
		this.plan = plan;
	}

	@Override
	public Operator getOperator() {
		return plan.getOperator();
	}

	@Override
	public void setOperator(Operator operator) {
		plan.setOperator(operator);

	}

	@Override
	public String getName() {
		return plan.getName();
	}

	@Override
	public void setName(String name) {
		plan.setName(name);

	}

	@Override
	public double calculatePrice(List<History> history) {
		int smsCount = SMS_COUNT;
		double cost = 0;
		for (History h : history) {
			if (h.getType() == ConnectType.TEXT) {
				if (smsCount == 0) {
					cost += plan.calculatePrice(h);
				} else {
					smsCount--;
				}
			}

		}
		return cost;
	}

	@Override
	public double calculatePrice(History history) {
		return plan.calculatePrice(history);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
