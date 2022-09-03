/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

/**
 *
 * @author USER
 */
public class Duration {
    private int hours;
    private int minutes;
    private int seconds;
    
    public Duration(int h1, int m1 , int s1 )
    {
      this.hours = h1;
      this.minutes = m1;
      this.seconds = s1;
    }    
    
    public int getHours()
    {
        return hours;
    }
    public int getMinutes()
    {
        return minutes;
    }
    public int getSeconds()
    {
        return seconds;
    }
    
}
