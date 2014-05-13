package gsm.model;

import java.util.ArrayList;
import java.util.List;

public class User
{

    public User( String userName )
    {
        super();
        this.userName = userName;
    }

    private List<Phone> phones = new ArrayList<Phone>();

    private String userName;

    private String firstName;

    private String lastName;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName( String userName )
    {
        this.userName = userName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public List<Phone> getPhones()
    {
        return phones;
    }

    public void setPhones( List<Phone> phones )
    {
        this.phones = phones;
    }

    public void addPhone( Phone phone )
    {
        this.getPhones().add( phone );
    }
}
