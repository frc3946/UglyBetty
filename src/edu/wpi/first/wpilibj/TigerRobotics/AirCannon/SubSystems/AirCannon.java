/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.SubSystems;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Timer;

/**
 * Handles the AirCannon's Cannon
 * @author Gus Michel
 */
public class AirCannon {
    private int CANNON_PWM_SLOT = 1;
    public static AirCannon instance = null;
    private PWM cannon;
    
    private void AirCannon() {
        cannon = new PWM(CANNON_PWM_SLOT);
    }
    
    /**
     * Get Instance of AirCannon
     * @return Singleton Instance
     */
    public static AirCannon getInstance() {
        if(instance == null) {
            instance = new AirCannon();
        }
        return instance;
    }
    /**
     * Fires the Air Cannon
     */
    public void fire() {
        cannon.setPosition(1);
        Timer.delay(4);
        cannon.setPosition(0);
    }
    
    /**
     * Will recharge AirCannon Pressure (Currently does NOTHING)
     */
    public void recharge() {
        
    }
}
