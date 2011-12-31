/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Main;

import edu.wpi.first.wpilibj.TigerRobotics.AirCannon.SubSystems.DriveTrain;
import edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Controls.SoftSwitchBoard;
import edu.wpi.first.wpilibj.TigerRobotics.Library.DashBoard;

/**
 *
 * @author gixxy
 */
public class BettyDash {
    private static BettyDash instance = null;
    private DashBoard db;
    private SoftSwitchBoard ssb;
    private DriveTrain dt;
    
    private BettyDash() {
        db = DashBoard.getInstance();
        ssb = SoftSwitchBoard.getInstance();
        dt= DriveTrain.getInstance();
    }
    
    public static BettyDash getInstance() {
        if(instance == null) {
            instance = new BettyDash();
        }
        return instance;
    }
    
    public void setupDash() {
        db.post("Robot Status", "Robot Init");
        db.post("Stopped", false);
        db.post("Mode", "Arcade");
        db.post("Left Drive", 0.0);
        db.post("Right Drive", 0.0);
        db.post("Drive Error", "Null");
    }
    
    public void updateDash() {
        db.post("Stopped", ssb.getStopModeSwitch().getState());
        if(ssb.getTankModeSwitch().getState()) {
            db.post("Mode", "Tank");
        } else {
            db.post("Mode", "Arcade");
        }
        db.post("Left Drive",dt.getLeftThrottle());
        db.post("Right Drive",dt.getRightThrottle());
    }
}
