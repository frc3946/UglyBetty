/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.Library;

/**
 * Class for the SoftSwitches, used in conjunction with a SoftSwitchBoard.
 * @author gixxy
 */
public class SoftSwitch {
    private boolean state;
    
    public SoftSwitch() {
        state = false;
    }
    
    public SoftSwitch(boolean startState) {
        state = startState;
    }
    
    /**
     * Toggles state of Switch Instance
     */
    public void toggleState() {
        state = !state;
    }
    
    /**
     * Sets the Switch Instance to a specific state
     * @param newState New state to set Switch to
     */
    public void setState(boolean newState) {
        state = newState;
    }
    
    /**
     * 
     * @return Current State of Switch Instance
     */
    public boolean getState() {
        return state;
    }
}
