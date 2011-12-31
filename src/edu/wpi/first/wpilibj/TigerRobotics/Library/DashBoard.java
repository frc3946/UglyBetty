/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.Library;

import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 *
 * @author gixxy
 */
public class DashBoard {
    private static DashBoard instance = null;
    private static SmartDashboard sd;
    
    private DashBoard() {
        sd = new SmartDashboard();
    }
    
    public static DashBoard getInstance() {
        if(instance == null) {
            instance = new DashBoard();
        }
        return instance;
    }
    
    public void post(String key, int value) {
        SmartDashboard.putInt(key, value);
    }
    
    public void post(String key, double value) {
        SmartDashboard.putDouble(key, value);
    }
    
    public void post(String key, boolean value) {
        SmartDashboard.putBoolean(key, value);
    }
    
    public void post(String key, String value) {
        SmartDashboard.putString(key, value);
    }

    
}
