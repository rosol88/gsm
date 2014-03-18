package gsm.model;

import gsm.exeption.UnsupportedTypeException;

import java.util.List;

public class SimplePlan
    extends Plan
{

    public SimplePlan( String name, Operator operator )
    {
        super( name, operator );
    }

    @Override
    double calculatePrice(List<History> history)
    {
    	double price=0;
    	for (History hist : history) {
    		HistoryDetail o=hist.getDetails();
    		if(hist.getType()==ConnectType.VOICE)
    			price+=calculate((Call)o);
    		else
    			throw new UnsupportedTypeException();
		}
        return price;
    }

	private double calculate(HistoryDetail details) {
		System.out.println("inteface");
		return 0;
	}
	private double calculate(Call details) {
		System.out.println("call");
		return 0;
	}


}
