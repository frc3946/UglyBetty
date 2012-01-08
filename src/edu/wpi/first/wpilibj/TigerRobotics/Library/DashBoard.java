/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.Library;

import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 * Used to redo the deprecated log() methods as post(). 
 * Handles actual posting to SmartDashboard
 * @author Gus Michel
 */
public class DashBoard {
    private static DashBoard instance = null;
    private static SmartDashboard smartDashBoard;
    
    private DashBoard() {
        smartDashBoard = new SmartDashboard();
    }
    
    /**
     * Get instance of DashBoard
     * @return Singleton Instance
     */
    public static DashBoard getInstance() {
        if(instance == null) {
            instance = new DashBoard();
        }
        return instance;
    }
    
    /**
     * Posts INT to SmartDashboard
     * @param key What slot on Dashboard to put this in
     * @param value What value to put in the slot
     */
    public void post(String key, int value) {
        SmartDashboard.putInt(key, value);
    }
    
    /**
     * Posts DOUBLE to SmartDashboard
     * @param key What slot on Dashboard to put this in
     * @param value What value to put in the slot
     */
    public void post(String key, double value) {
        SmartDashboard.putDouble(key, value);
    }
    
    /**
     * Posts BOOLEAN to SmartDashboard
     * @param key What slot on Dashboard to put this in
     * @param value What value to put in the slot
     */
    public void post(String key, boolean value) {
        SmartDashboard.putBoolean(key, value);
    }
    
    /**
     * Posts STRING to SmartDashboard
     * @param key What slot on Dashboard to put this in
     * @param value What value to put in the slot
     */
    public void post(String key, String value) {
        SmartDashboard.putString(key, value);
    }

    
}
