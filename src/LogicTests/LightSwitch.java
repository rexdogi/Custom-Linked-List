package LogicTests;

import java.util.LinkedList;

/**
 * Created by Paulius on 9/11/2016.
 */
public class LightSwitch {

    public boolean status = false;

    public static LinkedList<LightSwitch> switches = new LinkedList<LightSwitch>();

    public LightSwitch(boolean status) {
        this.status = status;
        switches.add(this);
    }

    public void setSwitchTo(boolean switchTo) {
        this.status = switchTo;
        this.checkSwitches(this);
        printSwitchesStatus();
    }

    public void checkSwitches(LightSwitch lSwitch) {
        for(int i = 0; i < LightSwitch.switches.size(); i++) {
            if(!LightSwitch.switches.get(i).equals(lSwitch)) {
                LightSwitch.switches.get(i).status = false;
            }
        }
    }

    public void printSwitchesStatus() {
        for(int i = 0; i < LightSwitch.switches.size(); i++) {
            System.out.println(LightSwitch.switches.get(i).status);
        }
        System.out.println();
    }
}
