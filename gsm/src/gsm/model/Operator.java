package gsm.model;

import gsm.plan.Plan;

import java.util.ArrayList;
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

    private List<Phone> phones=new ArrayList<Phone>();
    private List<History> history=new ArrayList<History>();

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

    public List<History> getHistory( String number)
    {
    	List<History> hist=new ArrayList<History>();
    	for (History h : history) {
			if(h.getFromPhone().getNumber().equals(number) || h.getToPhone().getNumber().equals(number))
				hist.add(h);
    	}
        return hist;
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

	public void addHistory(History hist) {
		history.add(hist);
	}

	public Bill getBill(String number) {
		
		List<History> phoneHistory=getHistory(number);
		Phone phone=SearchUtils.findPhone(phones, number);
		double price=phone.getPlan().calculatePrice(phoneHistory);
		Bill bill=new Bill(phone,price);
		return bill;
	}

	public void addPhone(Phone phone) {
		phones.add(phone);
		
	}

}
