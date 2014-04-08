package gsm.plan;

import java.util.List;

import gsm.model.History;
import gsm.model.Operator;

public interface Plan {

	public Operator getOperator();

	public void setOperator(Operator operator);

	public String getName();

	public void setName(String name);

	public double calculatePrice(List<History> history);

	public double calculatePrice(History history);

	public Object clone() throws CloneNotSupportedException;
}
