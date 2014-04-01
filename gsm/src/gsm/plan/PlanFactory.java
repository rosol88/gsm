package gsm.plan;

import gsm.model.Operator;

public interface PlanFactory {

	

	Plan createPlan(String plan, Operator op);
}
