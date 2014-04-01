package gsm.plan;

import gsm.exeption.UnsupportedTypeException;
import gsm.model.Call;
import gsm.model.ConnectType;
import gsm.model.History;
import gsm.model.HistoryDetail;
import gsm.model.Operator;

import java.util.List;

public class PlusFirmaPlan
    extends Plan
{

	private double voiceBid=1;
    public PlusFirmaPlan( String name, Operator operator )
    {
        super( name, operator );
    }

    @Override
    public double calculatePrice(List<History> history)
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
		long time=details.getTime();
		double price=time/1000 * voiceBid;
		return price;
	}


}
