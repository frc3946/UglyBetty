/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Main;

import edu.wpi.first.wpilibj.TigerRobotics.AirCannon.SubSystems.DriveTrain;
import edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Controls.SoftSwitchBoard;
import edu.wpi.first.wpilibj.TigerRobotics.Library.DashBoard;

/**
 * Handles setup and periodic updating of SmartDashboard
 * @author Gus Michel
 */
public class BettyDash {
    private static BettyDash instance = null;
    private DashBoard dashBoard;
    private SoftSwitchBoard softSwitchBoard;
    private DriveTrain driveTrain;
    
    private BettyDash() {
        dashBoard = DashBoard.getInstance();
        softSwitchBoard = SoftSwitchBoard.getInstance();
        driveTrain= DriveTrain.getInstance();
    }
    
    /**
     * Get Instance of BettyDash
     * @return Singleton Instance
     */
    public static BettyDash getInstance() {
        if(instance == null) {
            instance = new BettyDash();
        }
        return instance;
    }
    /**
     * Sets up all spaces on the Dashboard.
     */
    public void setupDash() {
        dashBoard.post("Robot Status", "Robot Init");
        dashBoard.post("Stopped", false);
        dashBoard.post("Mode", "Arcade");
        dashBoard.post("Left Drive", 0.0);
        dashBoard.post("Right Drive", 0.0);
        dashBoard.post("Drive Error", "Null");
    }
    
    /**
     * Updates most spaces in the Dashboard.
     */
    public void updateDash() {
        dashBoard.post("Stopped", softSwitchBoard.getStopModeSwitch().getState());
        if(softSwitchBoard.getTankModeSwitch().getState()) {
            dashBoard.post("Mode", "Tank");
        } else {
            dashBoard.post("Mode", "Arcade");
        }
        dashBoard.post("Left Drive",driveTrain.getLeftThrottle());
        dashBoard.post("Right Drive",driveTrain.getRightThrottle());
    }
}
