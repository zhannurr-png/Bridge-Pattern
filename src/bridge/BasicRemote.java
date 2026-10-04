package bridge;

public class BasicRemote extends Remote {
    public BasicRemote(String id, int volume, Device device){
        super(id, volume, device);
    }
    @Override
    public String execute(){
        return device.applySettings(volume);
    }
}