package gsm.model;

import java.util.List;

public class Operator
{
    public Operator( String name )
    {
        super();
        this.name = name;
    }

    private String name;

    private List<Plan> plans;

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public List<Plan> getPlans()
    {
        return plans;
    }

    public void setPlans( List<Plan> plans )
    {
        this.plans = plans;
    }

}
