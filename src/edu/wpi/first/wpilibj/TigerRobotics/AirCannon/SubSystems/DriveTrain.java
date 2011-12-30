/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.SubSystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author gixxy
 */
public class DriveTrain {
    private int LEFT_VICTOR_SLOT = 1;
    private int RIGHT_VICTOR_SLOT = 2;
    public static DriveTrain instance = null;
    private Victor left;
    private Victor right;
    private RobotDrive rd;
    
    private void DriveTrain() {
        left = new Victor(LEFT_VICTOR_SLOT);
        right = new Victor(RIGHT_VICTOR_SLOT);
        rd = new RobotDrive(left,right);
    }
    
    public static DriveTrain getInstance() {
        if(instance == null) {
            instance = new DriveTrain();
        }
        return instance;
    }
    
    public void drive(double throttle, double curve) {
        rd.drive(throttle, curve);
    }
    
    public void tankDrive(double leftThrottle, double rightThrottle) {
        rd.tankDrive(leftThrottle, rightThrottle);
    }
    
    public void arcadeDrive(double throttle, double curve) {
        rd.arcadeDrive(throttle, curve);
    }
}
