/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

/**
 *
 * @author USER
 */
public class Playlist {
    private PlaylistTrack[] plt;
    private AlbumCollection albmClction;
    private int nElements=0;
    
    public Playlist(AlbumCollection albmClction)
    {
       plt=new PlaylistTrack[200];
       nElements=0;
       albmClction=albmClction;
    }    
   
    //add album tracks to playlist
    public void addTracksToPlaylist(Album a)
    {
        //System.out.print("nElements="+nElements+",plt.lenght="+plt.length);
        plt[nElements].SetTrackToPlayList(a);
        nElements=nElements+1;
        //return true;
    }
    
    public int getTotalTimToAlbumInOPlayList(Album a)
    {
        int t=0;
        Track[] trkArr = a.getTracks();
        for(int i=0; i<trkArr.length; i++)
        {
            if(trkArr[i]!=null)
            {
                t+=trkArr[i].getplaytimeBySeconds();
            }
        }
        return t;
    }
}