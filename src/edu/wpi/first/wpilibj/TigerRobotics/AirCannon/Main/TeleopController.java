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
 * @author Gus Michel
 */
public class TeleopController {
    private static TeleopController instance = null;
    private DriveTrain driveTrain;
    private AirCannon airCannon;
    private ControlMap controlMap;
    public SoftSwitchBoard softSwitchBoard;
    
    private void TeleopController() {
        driveTrain = DriveTrain.getInstance();
        airCannon = AirCannon.getInstance();
        controlMap = ArcadeControl.getInstance();
        softSwitchBoard = SoftSwitchBoard.getInstance();
    }
    /**
     * Get Instance of TeleopController
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
        controlMap.setStopSwitch();
        controlMap.setTankSwitch();
        
        if(!softSwitchBoard.getStopModeSwitch().getState()) { //Robot is not stopped
            if(controlMap.getFire()) { //Robot is firing
                driveTrain.drive(0,0);
                airCannon.fire();
                softSwitchBoard.getStopModeSwitch().setState(true);
            } else { //Robot is not firing
                if(softSwitchBoard.getTankModeSwitch().getState()) {
                    controlMap = TankControl.getInstance();
                    driveTrain.tankDrive(controlMap.getLeftThrottle(), controlMap.getRightThrottle());
                } else {
                    controlMap = ArcadeControl.getInstance();
                    driveTrain.arcadeDrive(controlMap.getThrottle(), controlMap.getTurn());
                }
            }
        } else { //Robot is Stopped
            driveTrain.drive(0,0);
        }
    }
}
