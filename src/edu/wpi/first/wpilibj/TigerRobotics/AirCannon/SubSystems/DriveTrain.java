/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.SubSystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 * Handles driving the AirCannon
 * @author Gus Michel
 */
public class DriveTrain {
    private int LEFT_VICTOR_SLOT = 1;
    private int RIGHT_VICTOR_SLOT = 2;
    private static DriveTrain instance = null;
    private Victor left;
    private Victor right;
    private RobotDrive robotDrive;
    
    private void DriveTrain() {
        left = new Victor(LEFT_VICTOR_SLOT);
        right = new Victor(RIGHT_VICTOR_SLOT);
        robotDrive = new RobotDrive(left,right);
    }
    
    /**
     * Get Instance of DriveTrain
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
        robotDrive.drive(throttle, curve);
    }
    
    /**
     * Tank Drive Method
     * @param leftThrottle Speed for Left Victor
     * @param rightThrottle Speed for Right Victor
     */
    public void tankDrive(double leftThrottle, double rightThrottle) {
        robotDrive.tankDrive(leftThrottle, rightThrottle);
    }
    
    /**
     * Arcade Drive Method
     * @param throttle How fast to go
     * @param curve How much to turn
     */
    public void arcadeDrive(double throttle, double curve) {
        robotDrive.arcadeDrive(throttle, curve);
    }
    
    /**
     * Get Speed of Left Victor
     * @return Current Speed of Left Victor
     */
    public double getLeftThrottle() {
        return left.getSpeed();
    }
    
    /**
     * Get Speed of Right Victor
     * @return Current Speed of Right Victor
     */
    public double getRightThrottle() {
        return right.getSpeed();
    }
}
