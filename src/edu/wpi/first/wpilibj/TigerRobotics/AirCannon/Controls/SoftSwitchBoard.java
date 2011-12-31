/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Controls;

import edu.wpi.first.wpilibj.TigerRobotics.Library.SoftSwitch;

/**
 *
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
    
    public static SoftSwitchBoard getInstance() {
        if(instance == null) {
            instance = new SoftSwitchBoard();
        }
        return instance;
    }
    
    public SoftSwitch getTankModeSwitch() {
        return tankMode;
    }
    
    public SoftSwitch getStopModeSwitch() {
        return stopMode;
    }
}
