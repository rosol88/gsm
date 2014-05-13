package gsm.plan;

import gsm.model.History;
import gsm.model.Operator;

import java.util.List;

public abstract class AbstractPlan implements Plan {
	private String name;

	private Operator operator;

	public AbstractPlan(String name, Operator operator) {
		this.name = name;
		this.operator = operator;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double calculatePrice(List<History> history) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculatePrice(History history) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
