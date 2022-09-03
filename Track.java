/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

/**
 *
 * @author USER
 */
public class Track {
    private Duration tDuration;
    private String title;
    
    
    public Track(Duration tDuration1, String t1)
    {
      this.tDuration = tDuration1;
      this.title = t1;
    }
    
    public String getTitle()
    {
        return title;
    }
    public int getplaytimeBySeconds()
    {
        int time1=0;
        time1=tDuration.getHours()*60*60+tDuration.getMinutes()*60+tDuration.getSeconds();
        return time1;
    }
}
