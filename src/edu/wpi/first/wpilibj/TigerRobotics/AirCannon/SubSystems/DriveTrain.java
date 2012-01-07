/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.SubSystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 * Handles driving the AirCannon
 * @author gixxy
 */
public class DriveTrain {
    private int LEFT_VICTOR_SLOT = 1;
    private int RIGHT_VICTOR_SLOT = 2;
    private static DriveTrain instance = null;
    private Victor left;
    private Victor right;
    private RobotDrive rd;
    
    private void DriveTrain() {
        left = new Victor(LEFT_VICTOR_SLOT);
        right = new Victor(RIGHT_VICTOR_SLOT);
        rd = new RobotDrive(left,right);
    }
    
    /**
     * 
     * @return Singleton Instance
     */
    public static DriveTrain getInstance() {
        if(instance == null) {
            instance = new DriveTrain();
        }
        return instance;
    }
    
    /**
     * General Drive Method
     * @param throttle How fast to go
     * @param curve How much to turn
     */
    public void drive(double throttle, double curve) {
        rd.drive(throttle, curve);
    }
    
    /**
     * Tank Drive Method
     * @param leftThrottle Speed for Left Victor
     * @param rightThrottle Speed for Right Victor
     */
    public void tankDrive(double leftThrottle, double rightThrottle) {
        rd.tankDrive(leftThrottle, rightThrottle);
    }
    
    /**
     * Arcade Drive Method
     * @param throttle How fast to go
     * @param curve How much to turn
     */
    public void arcadeDrive(double throttle, double curve) {
        rd.arcadeDrive(throttle, curve);
    }
    
    /**
     * 
     * @return Current Speed of Left Victor
     */
    public double getLeftThrottle() {
        return left.getSpeed();
    }
    
    /**
     * 
     * @return Current Speed of Right Victor
     */
    public double getRightThrottle() {
        return right.getSpeed();
    }
}
