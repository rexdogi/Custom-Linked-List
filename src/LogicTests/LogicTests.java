package LogicTests;

/**
 * Created by Paulius on 9/11/2016.
 */
public class LogicTests {

    LightSwitch switch1 = new LightSwitch(false);
    LightSwitch switch2 = new LightSwitch(false);
    LightSwitch switch3 = new LightSwitch(false);
    LightSwitch switch5 = new LightSwitch(false);
    LightSwitch switch6 = new LightSwitch(false);
    LightSwitch switch7 = new LightSwitch(false);



    public LogicTests() {
        switch1.setSwitchTo(true);
        switch3.setSwitchTo(true);
        switch3.setSwitchTo(false);
        switch7.setSwitchTo(true);
    }
}
