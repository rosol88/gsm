package gsm;

import gsm.model.Network;
import gsm.model.Operator;
import gsm.model.Phone;
import gsm.model.Plan;
import gsm.model.SimplePlan;
import gsm.model.User;

import java.util.ArrayList;
import java.util.List;

public class TestWorld {

	private List<Operator> operators;
	private List<Network> networks;
	private List<Phone> phones=new ArrayList<Phone>();
	private List<User> users;
	public TestWorld( )
    {
        Operator op1 = new Operator( "Orange" );
        Operator op2 = new Operator( "Plus" );

        Network net1 = new Network( op1 );
        Network net2 = new Network( op2 );

        User u1 = new User( "jkowlaski" );
        User u2 = new User( "anowak" );

        Plan pl1 = new SimplePlan( "POP", op1 );
        Plan pl2 = new SimplePlan( "Firma", op2 );

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
