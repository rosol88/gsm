package gsm.model;

import java.util.List;

public class Network
{

    public Network( Operator operator )
    {
        super();
        this.operator = operator;
    }

    List<Phone> phones;

    List<History> history;

    private Operator operator;

    public List<Phone> getPhones()
    {
        return phones;
    }

    public void setPhones( List<Phone> phones )
    {
        this.phones = phones;
    }

    public Operator getOperator()
    {
        return operator;
    }

    public void setOperator( Operator operator )
    {
        this.operator = operator;
    }

    public void sendText( String fromNumber, String toNumber, String text )
    {
        validateNumbers( fromNumber, toNumber );

        Phone fromPhone = getPhone( fromNumber );
        Phone toPhone = getPhone( toNumber );

        validatePhones( fromPhone, toPhone );

        toPhone.receiveText( new Message( fromPhone, text ) );

    }

    private void validatePhones( Phone fromPhone, Phone toPhone )
    {
        // TODO Auto-generated method stub

    }

    private Phone getPhone( String fromNumber )
    {
        // TODO Auto-generated method stub
        return null;
    }

    private void validateNumbers( String fromNumber, String toNumber )
    {
        // TODO Auto-generated method stub

    }

    public Call call( String fromNumber, String toNumber )
    {
        validateNumbers( fromNumber, toNumber );

        Phone fromPhone = getPhone( fromNumber );
        Phone toPhone = getPhone( toNumber );

        validatePhones( fromPhone, toPhone );

        Call call = new Call( fromPhone, toPhone, this );
        return call;

    }
}
