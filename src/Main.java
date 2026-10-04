import bridge.*;

public class Main {
    public static void main(String[] args) {

        Device tv = new TvDevice();
        Device radio = new RadioDevice();
        Device projector = new ProjectorDevice();

        Remote basicTV = new BasicRemote("A1", 30, tv);
        Remote basicRadio = new BasicRemote("A1", 30, radio);
        Remote basicProjector = new BasicRemote("A1", 30, projector);

        Remote quietTV = new QuietRemote("A2", 5, tv);
        Remote quietRadio = new QuietRemote("A2", 5, radio);
        Remote quietProjector = new QuietRemote("A2", 5, projector);

        System.out.println("T1: " + basicTV.execute());
        System.out.println("T2: " + basicRadio.execute());
        System.out.println("T3: " + quietTV.execute());
        System.out.println("T4: " + quietRadio.execute());

        Remote original = basicTV;

        System.out.println("T5 before: " + original.execute());
        original.setImplementation(radio);

        Remote afterSwitch = original;

        System.out.println("T5 same object: " + (original == afterSwitch));
        System.out.println("T5 after: " + afterSwitch.execute());

        System.out.println("T6: " + basicProjector.execute());
        System.out.println("T7: " + quietProjector.execute());
    }
}