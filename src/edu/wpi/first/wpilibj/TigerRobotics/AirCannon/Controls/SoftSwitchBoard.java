/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Controls;

import edu.wpi.first.wpilibj.TigerRobotics.Library.SoftSwitch;

/**
 * Manages the Currently used SoftSwitch Instances
 * @author gixxy
 */
public class SoftSwitchBoard {
    private SoftSwitch stopMode;
    private SoftSwitch tankMode;
    private static SoftSwitchBoard instance = null;
    
    private SoftSwitchBoard() {
        stopMode = new SoftSwitch(false);
        tankMode = new SoftSwitch(false);
    }
    
    /**
     * Get Instance of SoftSwitchBoard
     * @return Singleton Instance
     */
    public static SoftSwitchBoard getInstance() {
        if(instance == null) {
            instance = new SoftSwitchBoard();
        }
        return instance;
    }
    
    /**
     * Get TankMode SoftSwitch Instance
     * @return Tank Mode Switch Instance
     */
    public SoftSwitch getTankModeSwitch() {
        return tankMode;
    }
    
    /**
     * Get StopMode SoftSwitch Instance
     * @return Stop Mode Switch Instance
     */
    public SoftSwitch getStopModeSwitch() {
        return stopMode;
    }
}
