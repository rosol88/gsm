package gsm;

import gsm.model.Network;
import gsm.model.Operator;
import gsm.model.Phone;
import gsm.model.Plan;
import gsm.model.SimplePlan;
import gsm.model.User;

public class Main
{

    public static void main( String[] args )
    {
        Operator op1 = new Operator( "Orange" );
        Operator op2 = new Operator( "Plus" );

        Network net1 = new Network( op1 );
        Network net2 = new Network( op2 );

        User u1 = new User( "jkowlaski" );
        User u2 = new User( "anowak" );

        Plan pl1 = new SimplePlan( "POP", op1 );
        Plan pl2 = new SimplePlan( "Firma", op2 );

        Phone p1 = new Phone( "609222111", pl1 );
        Phone p2 = new Phone( "899221002", pl2 );

        u1.addPhone( p1 );
        u2.addPhone( p2 );

        p1.setNetwork( net1 );
        p2.setNetwork( net2 );

        p1.sendText( "899221002", "SADSA" );

        p1.startCall( "899221002" );
        p1.stopCall();

        p1.sendData( new Object() );
        p2.getData();

    }

}
