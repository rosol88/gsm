package gsm.model;

import java.util.List;

public class SearchUtils {


    public static Phone findPhone(List<Phone> phones, String number )
    {
    	for (Phone phone : phones) {
			if(phone.getNumber().equals(number))
				return phone;
		}
		return null;
    }
}
