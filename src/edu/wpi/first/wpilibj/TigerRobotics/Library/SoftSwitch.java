/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.Library;

/**
 *
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
    
    public void toggleState() {
        state = !state;
    }
    
    public void setState(boolean newState) {
        state = newState;
    }
    
    public boolean getState() {
        return state;
    }
}
