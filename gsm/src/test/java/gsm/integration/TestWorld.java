package gsm.integration;

import gsm.GsmModule;
import gsm.model.Connector;
import gsm.model.Network;
import gsm.model.Operator;
import gsm.model.Phone;
import gsm.model.User;
import gsm.plan.OrangePopPlan;
import gsm.plan.Plan;
import gsm.plan.PlanFactory;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestWorld {

	private List<Operator> operators;
	private List<Network> networks;
	private List<Phone> phones=new ArrayList<Phone>();
	private List<User> users;
	public TestWorld( )
    {
		
		Injector injector = Guice.createInjector(new GsmModule());
		PlanFactory pf=injector.getInstance(PlanFactory.class);
		Connector mc=injector.getInstance(Connector.class);
        Operator op1 = new Operator( "Orange" );
        Operator op2 = new Operator( "Plus" );

        Network net1 = new Network( op1 );
        Network net2 = new Network( op2 );
        
        mc.registerNetwork(net1);
        mc.registerNetwork(net2);

        User u1 = new User( "jkowlaski" );
        User u2 = new User( "anowak" );

        Plan pl1 = new OrangePopPlan( "POP", op1 );
        Plan pl2 = new OrangePopPlan( "Firma", op2 );

        Phone p1 = new Phone( "555555555", pl1 );
        Phone p2 = new Phone( "666666666", pl2 );
        phones.add(p1);
        phones.add(p2);

        u1.addPhone( p1 );
        u2.addPhone( p2 );

        p1.setNetwork( net1 );
        p2.setNetwork( net1 );


    }
	public Phone getPhone(String number) {
		for (Phone phone : phones) {
			if(phone.getNumber().equals(number))
				return phone;
		}
		return null;
	}
}
