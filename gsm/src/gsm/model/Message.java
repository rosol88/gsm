package gsm.model;

import java.util.Date;

public class Message
{

    private Phone fromPhone;

    private String text;

    private Date date;

    public Message( Phone fromPhone, String text )
    {
        super();
        this.fromPhone = fromPhone;
        this.text = text;
        this.date = new Date();
    }

    public Phone getFromPhone()
    {
        return fromPhone;
    }

    public String getText()
    {
        return text;
    }

    public Date getDate()
    {
        return date;
    }

}
