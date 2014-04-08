package gsm.plan;

import gsm.exeption.InvalidPlanException;
import gsm.model.Operator;

import java.util.HashMap;
import java.util.Map;

public class SimplePlanFactory implements PlanFactory {

	private static Map<String, Plan> plans = new HashMap<String, Plan>();
	private static Map<String, Operator> operators = new HashMap<String, Operator>();
	static {
		Operator plus = new Operator("Plus");
		Operator orange = new Operator("Orange");
		operators.put("Plus", plus);
		operators.put("Orange", orange);

		Plan firma = new PlusFirmaPlan("firma", plus);
		Plan pop = new OrangePopPlan("pop", orange);
		plans.put("firma", firma);
		plans.put("pop", pop);
	}

	@Override
	public Plan createPlan(String plan) {
		if (plans.containsKey(plan)) {
			try {
				return (Plan) plans.get(plan).clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		throw new InvalidPlanException(plan);
	}

}