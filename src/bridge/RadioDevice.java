package bridge;

public class RadioDevice implements Device{
    @Override
    public String applySettings(int volume){
        return "Radio | power=ON | volume=" + volume;
    }
}