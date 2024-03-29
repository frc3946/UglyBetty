/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Controls;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TigerRobotics.Library.DashBoard;

/**
 * Controls interface while in Arcade Mode
 * @author Gus Michel
 */
public class ArcadeControl implements ControlMap {
    private int DRIVESTICK_PORT = 1;
    private int STOPSWITCH_BUTTON = 1;
    private int TANKSWITCH_BUTTON = 2;
    private int FIRE_BUTTON = 3;
    private static ArcadeControl instance = null;
    private DashBoard dashBoard;
    private SoftSwitchBoard softSwitchBoard;
    private Joystick driveStick;
    
    private ArcadeControl() {
        dashBoard = DashBoard.getInstance();
        softSwitchBoard = SoftSwitchBoard.getInstance();
        driveStick = new Joystick(DRIVESTICK_PORT);
    }
    
    /**
     * Get Instance of ArcadeControl
     * @return Singleton Instance
     */
    public static ArcadeControl getInstance() {
        if(instance == null) {
            instance = new ArcadeControl();
        }
        return instance;
    }
    
    /**
     * Get the Throttle of the Joystick
     * @return Joystick Y-axis
     */
    public double getThrottle() {
        return driveStick.getY();
    }
    
    /**
     * Get the Turn of the Joystick
     * @return Joystick X-axis
     */
    public double getTurn() {
        return driveStick.getX();
    }
    
    /**
     * Not used in arcade mode. Will report error to Dashboard.
     * @return 0 for Drive Motors
     */
    public double getLeftThrottle() {
        dashBoard.post("Drive Error","getLeftThrottle in Arcade");
        return 0.0;
    }
    
    /**
     * Not used in arcade mode. Will report error to Dashboard.
     * @return 0 for Drive Motors
     */
    public double getRightThrottle() {
        dashBoard.post("Drive Error","getRightThrottle in Arcade");
        return 0.0;
    }
    
    /**
     * Get state of Fire Button
     * @return State of the Fire Button
     */
    public boolean getFire() {
        return driveStick.getRawButton(FIRE_BUTTON);
    }
    
    /*
     * Toggles state of Stop Switch if button is hit
     */
    public void setStopSwitch() {
        if(driveStick.getRawButton(STOPSWITCH_BUTTON)) {
            softSwitchBoard.getStopModeSwitch().toggleState();
        }
    }
    
    /*
     * Toggles state of Drive Mode "Tank" Switch if button is hit
     */
    public void setTankSwitch() {
        if(driveStick.getRawButton(TANKSWITCH_BUTTON)) {
            softSwitchBoard.getTankModeSwitch().toggleState();
        }
    }
}
