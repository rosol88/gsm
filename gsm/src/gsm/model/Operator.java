package gsm.model;

import java.util.Date;
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

    private List<Phone> phones;

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

    public List<History> getHistory( String number, Date startDate, Date endDate )
    {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Phone> getPhones()
    {
        return phones;
    }

    public void setPhones( List<Phone> phones )
    {
        this.phones = phones;
    }

}
