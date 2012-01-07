/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Main;

import edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Controls.ArcadeControl;
import edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Controls.ControlMap;
import edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Controls.TankControl;
import edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Controls.SoftSwitchBoard;
import edu.wpi.first.wpilibj.TigerRobotics.AirCannon.SubSystems.DriveTrain;
import edu.wpi.first.wpilibj.TigerRobotics.AirCannon.SubSystems.AirCannon;
/**
 * Handles getting inputs from Controls and sending data to Subsystems
 * @author gixxy
 */
public class TeleopController {
    private static TeleopController instance = null;
    private DriveTrain dt;
    private AirCannon ac;
    private ControlMap cm;
    public SoftSwitchBoard ssb;
    
    private void TeleopController() {
        dt = DriveTrain.getInstance();
        ac = AirCannon.getInstance();
        cm = ArcadeControl.getInstance();
        ssb = SoftSwitchBoard.getInstance();
    }
    /**
     * 
     * @return Singleton Instance
     */
    public static TeleopController getInstance() {
        if(instance == null) {
            instance = new TeleopController();
        }
        return instance;
    }
    /**
     * Gets inputs from Control package and sends them to the SubSystems package
     */
    public void handle() {
        cm.setStopSwitch();
        cm.setTankSwitch();
        
        if(!ssb.getStopModeSwitch().getState()) { //Robot is not stopped
            if(cm.getFire()) { //Robot is firing
                dt.drive(0,0);
                ac.fire();
                ssb.getStopModeSwitch().setState(true);
            } else { //Robot is not firing
                if(ssb.getTankModeSwitch().getState()) {
                    cm = TankControl.getInstance();
                    dt.tankDrive(cm.getLeftThrottle(), cm.getRightThrottle());
                } else {
                    cm = ArcadeControl.getInstance();
                    dt.arcadeDrive(cm.getThrottle(), cm.getTurn());
                }
            }
        } else { //Robot is Stopped
            dt.drive(0,0);
        }
    }
}
