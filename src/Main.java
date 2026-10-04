import bridge.*;

public class Main {
    public static void main(String[] args) {

        Device tv = new TvDevice();
        Device radio = new RadioDevice();

        Remote basicTV = new BasicRemote("A1", 30, tv);
        Remote basicRadio = new BasicRemote("A1", 30, radio);

        Remote quietTV = new QuietRemote("A2", 5, tv);
        Remote quietRadio = new QuietRemote("A2", 5, radio);

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
    }
}