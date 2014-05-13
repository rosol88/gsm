package gsm;

import gsm.model.Connector;
import gsm.model.MainConnector;
import gsm.plan.PlanFactory;
import gsm.plan.SimplePlanFactory;

import com.google.inject.AbstractModule;

public class GsmModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(PlanFactory.class).to(SimplePlanFactory.class);
		bind(Connector.class).to(MainConnector.class);
	}

}
