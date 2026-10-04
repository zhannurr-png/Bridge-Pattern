import bridge.*;

public class Main {
    static int passed = 0;
    public static void main(String[] args) {
        if (args.length == 0 || !args[0].equals("--demo")){
            System.out.println("Use --demo");
            return;
        }

        Device tv = new TvDevice();
        Device radio = new RadioDevice();
        Device projector = new ProjectorDevice();

        Remote basicTV = new BasicRemote("A1", 30, tv);
        Remote basicRadio = new BasicRemote("A1", 30, radio);
        Remote basicProjector = new BasicRemote("A1", 30, projector);

        Remote quietTV = new QuietRemote("A2", 5, tv);
        Remote quietRadio = new QuietRemote("A2", 5, radio);
        Remote quietProjector = new QuietRemote("A2", 5, projector);

        check("T1", "BasicRemote + TvDevice", basicTV.execute(), "TV | power=ON |volume=30");
        check("T2", "BasicRemote + RadioDevice", basicRadio.execute(), "Radio | power=ON | volume=30");
        check("T3", "QuietRemote + TvDevice", quietTV.execute(), "TV | power=ON |volume=5");
        check("T4", "QuietRemote + RadioDevice", quietRadio.execute(), "Radio | power=ON | volume=5");

        Remote original = basicTV;
        String before = original.execute();
        original.setImplementation(radio);

        Remote afterSwitch = original;
        String after = afterSwitch.execute();

        boolean sameObject = original == afterSwitch;
        boolean beforeCorrect = before.equals("TV | power=ON |volume=30");
        boolean afterCorrect = after.equals("Radio | power=ON | volume=30");

        if (sameObject && beforeCorrect && afterCorrect) {
            System.out.println("T5 PASS | sameObject=true | stateUnchanged=true" + " | before=" + before + " | after=" + after);
            passed++;
        } else {
            System.out.println("T5 FAIL | sameObject=" + sameObject + " | stateUnchanged=" + beforeCorrect + " | before=" + before + " | after=" + after);
        }

        check("T6", "BasicRemote + ProjectorDevice", basicProjector.execute(), "Projector | power=ON | volume=30");
        check("T7", "QuietRemote + ProjectorDevice", quietProjector.execute(), "Projector | power=ON | volume=5");

        System.out.println("SUMMARY: " + passed + "/7 PASS");
    }
    static void check(String id, String classes, String actual, String expected) {
        if (actual.equals(expected)) {
            System.out.println(id + " PASS | " + classes + " | result=" + actual);
            passed++;
        } else {
            System.out.println(id + " FAIL | " + classes + " | result=" + actual);
            System.out.println("expected=" + expected);
        }
    }
}