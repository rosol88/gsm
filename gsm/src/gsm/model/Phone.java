package gsm.model;

import gsm.exeption.NoNetworkException;

import java.util.ArrayList;
import java.util.List;

public class Phone
{

    private String number;

    private Network network;

    private List<Message> messages = new ArrayList<Message>();

    private Call call;

    public Phone( String number, Plan plan )
    {
        super();
        this.number = number;
        this.plan = plan;
    }

    private Plan plan;

    public String getNumber()
    {
        return number;
    }

    public void setNumber( String number )
    {
        this.number = number;
    }

    public Network getNetwork()
    {
        return network;
    }

    public void setNetwork( Network network )
    {
        this.network = network;
    }

    public Plan getPlan()
    {
        return plan;
    }

    public void setPlan( Plan plan )
    {
        this.plan = plan;
    }

    public void sendText( String number, String text )
    {
        checkNetwork();
        getNetwork().sendText( getNumber(), number, text );
    }

    private void checkNetwork()
    {
        if ( getNetwork() == null )
            throw new NoNetworkException();

    }

    public void startCall( String number )
    {
        call = getNetwork().call( getNumber(), number );
    }

    public void stopCall()
    {
        call.stop();
    }

    public void sendData( Object data )
    {

    }

    public void getData()
    {

    }

    public void receiveText( Message message )
    {
        messages.add( message );
    }
}