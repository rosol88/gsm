package gsm.plan;

import gsm.exeption.InvalidPlanException;
import gsm.model.Operator;

public class SimplePlanFactory implements PlanFactory {

	@Override
	public Plan createPlan(String plan, Operator op) {
		if (op.getName().equals("Plus")) {
			if (plan.equals("firma")) {
				return new PlusFirmaPlan(plan, op);
			}
		} else if (op.getName().equals("Oragne")) {
			if (plan.equals("pop")) {
				return new OrangePopPlan(plan, op);
			}
		}
		throw new InvalidPlanException(plan);
	}

}
