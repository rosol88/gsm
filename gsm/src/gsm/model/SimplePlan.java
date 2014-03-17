package gsm.model;

public class SimplePlan
    extends Plan
{

    public SimplePlan( String name, Operator operator )
    {
        super( name, operator );
    }

    @Override
    double calculatePrice()
    {
        return 0;
    }

}
