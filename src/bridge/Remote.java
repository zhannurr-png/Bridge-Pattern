package bridge;
public abstract class Remote{
    protected String id;
    protected int volume;
    protected Device device;

    public Remote(String id, int volume, Device device){
        this.id = id;
        this.volume = volume;
        this.device = device;
    }
    public abstract String execute();

    public void setImplementation(Device device){
        this.device = device;
    }
}