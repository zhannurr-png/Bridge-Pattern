package bridge;

public class QuietRemote extends Remote {
    public QuietRemote(String id, int volume, Device device){
        super(id, volume, device);
    }
    @Override
    public String execute(){
        return device.applySettings(volume);
    }
}