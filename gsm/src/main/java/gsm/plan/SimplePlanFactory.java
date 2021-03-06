package gsm.plan;

import gsm.exeption.InvalidPlanException;
import gsm.model.Operator;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Singleton;
@Singleton
public class SimplePlanFactory implements PlanFactory {

	private static SimplePlanFactory factory;

	public SimplePlanFactory() {

	}

//	public static SimplePlanFactory getInstance() {
//		if (factory == null) {
//			factory = new SimplePlanFactory();
//		}
//		return factory;
//	}

	private static Map<String, Plan> plans = new HashMap<String, Plan>();
	static {
		Operator plus = new Operator("Plus");
		Operator orange = new Operator("Orange");

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
