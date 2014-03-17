package gsm.model;

public abstract class Plan
{

    private String name;

    private Operator operator;

    public Plan( String name, Operator operator )
    {
        super();
        this.name = name;
        this.operator = operator;
    }

    public Operator getOperator()
    {
        return operator;
    }

    public void setOperator( Operator operator )
    {
        this.operator = operator;
    }

    abstract double calculatePrice();

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

}
