package gsm.model;

public interface Operation
{

    public void sendText( String fromNumber, String toNumber, String text );

    public void startCall( VoiceConnect call );

    public void stopCall();

    public void sendData( Object data );

    public void getData();
}
