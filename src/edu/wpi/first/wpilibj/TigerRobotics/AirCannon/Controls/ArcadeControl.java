/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Controls;

import edu.wpi.first.wpilibj.TigerRobotics.AirCannon.SubSystems.SoftSwitchBoard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TigerRobotics.Library.DashBoard;

/**
 *
 * @author gixxy
 */
public class ArcadeControl implements ControlMap {
    private int DRIVESTICK_PORT = 1;
    private int STOPSWITCH_BUTTON = 1;
    private int TANKSWITCH_BUTTON = 2;
    private int FIRE_BUTTON = 3;
    private static ArcadeControl instance = null;
    private DashBoard db;
    private SoftSwitchBoard ssb;
    private Joystick driveStick;
    
    private ArcadeControl() {
        db = DashBoard.getInstance();
        ssb = SoftSwitchBoard.getInstance();
        driveStick = new Joystick(DRIVESTICK_PORT);
    }
    
    public static ArcadeControl getInstance() {
        if(instance == null) {
            instance = new ArcadeControl();
        }
        return instance;
    }

    public double getThrottle() {
        return driveStick.getY();
    }

    public double getTurn() {
        return driveStick.getX();
    }

    public double getLeftThrottle() {
        db.post("Drive Error","getLeftThrottle in Arcade");
        return 0.0;
    }

    public double getRightThrottle() {
        db.post("Drive Error","getRightThrottle in Arcade");
        return 0.0;
    }

    public boolean getFire() {
        return driveStick.getRawButton(FIRE_BUTTON);
    }

    public void setStopSwitch() {
        if(driveStick.getRawButton(STOPSWITCH_BUTTON)) {
            ssb.getStopModeSwitch().toggleState();
        }
    }

    public void setTankSwitch() {
        if(driveStick.getRawButton(TANKSWITCH_BUTTON)) {
            ssb.getTankModeSwitch().toggleState();
        }
    }
}
