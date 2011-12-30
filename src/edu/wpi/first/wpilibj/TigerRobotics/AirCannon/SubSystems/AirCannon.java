/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.SubSystems;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author gixxy
 */
public class AirCannon {
    private int CANNON_PWM_SLOT = 1;
    public static AirCannon instance = null;
    private PWM ac;
    
    private void AirCannon() {
        ac = new PWM(CANNON_PWM_SLOT);
    }
    
    public static AirCannon getInstance() {
        if(instance == null) {
            instance = new AirCannon();
        }
        return instance;
    }
    
    public void fire() {
        ac.setPosition(1);
        Timer.delay(4);
        ac.setPosition(0);
    }
    
    public void recharge() {
        
    }
}
