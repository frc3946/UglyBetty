/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.TigerRobotics.AirCannon.Controls;


/**
 * Common Interface for various controls system layouts
 * @author Gus Michel
 */
public interface ControlMap {
    public double getThrottle();
    public double getTurn();
    public double getLeftThrottle();
    public double getRightThrottle();
    public boolean getFire();
    public void setStopSwitch();
    public void setTankSwitch();
}
