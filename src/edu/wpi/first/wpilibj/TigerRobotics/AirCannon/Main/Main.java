/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Main;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TigerRobotics.AirCannon.SubSystems.DriveTrain;
import edu.wpi.first.wpilibj.TigerRobotics.Library.DashBoard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Main extends IterativeRobot {
    TeleopController tc;
    BettyDash bd;
    DashBoard db;
    DriveTrain dt;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        tc = new TeleopController();
        bd = BettyDash.getInstance();
        db = DashBoard.getInstance();
        dt = DriveTrain.getInstance();
        bd.setupDash();
    }
    
    /**
     * This function is called periodically while disabled
     */
    public void disabledPeriodic() {
        db.post("Robot Status", "Disabled");
        dt.drive(0,0);
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        db.post("Robot Status", "Autonomous");
        dt.drive(0,0);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        tc.handle();
        db.post("Robot Status", "Teleop");
        bd.updateDash();
    }
    
}
