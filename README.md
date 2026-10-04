# Bridge Pattern

**Name:** Zhannur Bakyt  
**Group:** SE-2524  
**Topic Letter:** D
**Repository:** https://github.com/zhannurr-png/Bridge-Pattern.git  
**Base Commit:** aa61130

## Bridge Map

| Role | Class | Path |
|---|---|---|
| Abstraction | Remote | src/bridge/Remote.java |
| A1 | BasicRemote | src/bridge/BasicRemote.java |
| A2 | QuietRemote | src/bridge/QuietRemote.java |
| Implementor | Device | src/bridge/Device.java |
| I1 | TvDevice | src/bridge/TvDevice.java |
| I2 | RadioDevice | src/bridge/RadioDevice.java |
| I3 | ProjectorDevice | src/bridge/ProjectorDevice.java |
| Client | Main | src/Main.java |

## Bridge Parts

- **Bridge field:** `Remote.java` → `Device device`
- **execute():** `Remote.java`
- **setImplementation(...):** `Remote.java`
- **T5 check:** `Main.java` → T5

## Build and Run

Run these commands from the project root:

```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

## Expected Output
T1 PASS | BasicRemote + TvDevice | result=TV | power=ON |volume=30 

T2 PASS | BasicRemote + RadioDevice | result=Radio | power=ON | volume=30

T3 PASS | QuietRemote + TvDevice | result=TV | power=ON |volume=5

T4 PASS | QuietRemote + RadioDevice | result=Radio | power=ON | volume=5

T5 PASS | sameObject=true | stateUnchanged=true | before=TV | power=ON |volume=30 | after=Radio | power=ON | volume=30

T6 PASS | BasicRemote + ProjectorDevice | result=Projector | power=ON | volume=30

T7 PASS | QuietRemote + ProjectorDevice | result=Projector | power=ON | volume=5

SUMMARY: 7/7 PASS