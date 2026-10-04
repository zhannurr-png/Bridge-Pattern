package bridge;

public class ProjectorDevice implements Device{
    @Override
    public String applySettings(int volume){
        return "Projector | power=ON | volume=" + volume;
    }
}