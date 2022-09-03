/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

/**
 *
 * @author zaid
 */
public class PlaylistTrack extends Track
{
    private Album albm1;
    
    public PlaylistTrack(Duration tDuration1, String t1) {
        super(tDuration1, t1);
    }
    
    public void SetTrackToPlayList(Album a) 
    {
        albm1=a;    
    }     
}
