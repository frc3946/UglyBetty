/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Controls;

import edu.wpi.first.wpilibj.TigerRobotics.AirCannon.SubSystems.SoftSwitchBoard;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author gixxy
 */
public class TankControl implements ControlMap {
    private int RIGHTSTICK_PORT = 1;
    private int LEFTSTICK_PORT = 2;
    private int STOPSWITCH_BUTTON = 1;
    private int TANKSWITCH_BUTTON = 2;
    private int FIRE_BUTTON = 3;
    private static TankControl instance = null;
    private SoftSwitchBoard ssb;
    private Joystick rightStick;
    private Joystick leftStick;
    
    private TankControl() {
        ssb = SoftSwitchBoard.getInstance();
        rightStick = new Joystick(RIGHTSTICK_PORT);
        leftStick = new Joystick(LEFTSTICK_PORT);
    }
    
    public static TankControl getInstance() {
        if(instance == null) {
            instance = new TankControl();
        }
        return instance;
    }
    
    public double getThrottle() {
        return 0.0;
    }

    public double getTurn() {
        return 0.0;
    }

    public double getLeftThrottle() {
        return leftStick.getY();
    }

    public double getRightThrottle() {
        return rightStick.getY();
    }

    public boolean getFire() {
        return rightStick.getRawButton(FIRE_BUTTON);
    }

    public void setStopSwitch() {
        if(rightStick.getRawButton(STOPSWITCH_BUTTON)) {
            ssb.getStopModeSwitch().toggleState();
        }
    }

    public void setTankSwitch() {
        if(rightStick.getRawButton(STOPSWITCH_BUTTON)) {
            ssb.getTankModeSwitch().toggleState();
        }
    }
}
