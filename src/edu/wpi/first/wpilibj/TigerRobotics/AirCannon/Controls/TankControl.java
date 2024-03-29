/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Controls;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TigerRobotics.Library.DashBoard;

/**
 * Control interface while in Tank Mode
 * @author Gus Michel
 */
public class TankControl implements ControlMap {
    private int RIGHTSTICK_PORT = 1;
    private int LEFTSTICK_PORT = 2;
    private int STOPSWITCH_BUTTON = 1;
    private int TANKSWITCH_BUTTON = 2;
    private int FIRE_BUTTON = 3;
    private static TankControl instance = null;
    private DashBoard dashBoard;
    private SoftSwitchBoard theSoftSwitchBoard;
    private Joystick rightStick;
    private Joystick leftStick;
    
    private TankControl() {
        dashBoard = DashBoard.getInstance();
        theSoftSwitchBoard = SoftSwitchBoard.getInstance();
        rightStick = new Joystick(RIGHTSTICK_PORT);
        leftStick = new Joystick(LEFTSTICK_PORT);
    }
    
    /**
     * Get Instance of TankControl
     * @return Singleton Instance
     */
    public static TankControl getInstance() {
        if(instance == null) {
            instance = new TankControl();
        }
        return instance;
    }
    
    /**
     * Not used in Tank Mode. Will report error to Dashboard.
     * @return 0 for Motors
     */
    public double getThrottle() {
        dashBoard.post("Drive Error","getThrottle in Tank");
        return 0.0;
    }
    
    /**
     * Not used in Tank Mode. Will report error to Dashboard.
     * @return 0 for Motors
     */
    public double getTurn() {
        dashBoard.post("Drive Error","getTurn in Tank");
        return 0.0;
    }
    
    /**
     * Get Throttle of Left Joystick
     * @return Left Joystick Y-axis.
     */
    public double getLeftThrottle() {
        return leftStick.getY();
    }

    /**
     * Get Throttle of Right Joystick
     * @return Right Joystick Y-axis.
     */
    public double getRightThrottle() {
        return rightStick.getY();
    }

    /**
     * Get State of Fire Button
     * @return State of Fire Button.
     */
    public boolean getFire() {
        return rightStick.getRawButton(FIRE_BUTTON);
    }

    /**
     * Toggles state of Stop Switch if button is hit.
     */
    public void setStopSwitch() {
        if(rightStick.getRawButton(STOPSWITCH_BUTTON)) {
            theSoftSwitchBoard.getStopModeSwitch().toggleState();
        }
    }

    /**
     *  Toggles state of Drive Mode "Tank" switch if button is hit.
     */
    public void setTankSwitch() {
        if(rightStick.getRawButton(TANKSWITCH_BUTTON)) {
            theSoftSwitchBoard.getTankModeSwitch().toggleState();
        }
    }
}
