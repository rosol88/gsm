package gsm.model;

public interface Operation
{

    public void sendText( String fromNumber, String toNumber, String text );

    public void startCall( Call call );

    public void stopCall();

    public void sendData( Object data );

    public void getData();
}
