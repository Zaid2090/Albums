/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.util.Comparator;
/**
 *
 * @author USER
 */
public class Album {
    
    private String artistName;
    private String albumTitle;
    private Track[] collection;
    private int nElements;
    private int trkCount;
    //private int size;
    
    
    public Album(String arNm, String alTl, int trkCount)
    {
      this.artistName = arNm;
      this.albumTitle = alTl;
      this.collection= new Track[trkCount];      
      this.trkCount=trkCount;      
    }

    public String getArtistName() {
         return artistName;
    }
    public String getAlbumTitle() {
         return albumTitle;
    }
    public int getTrackNum() {
         return collection.length;
    }
    public Track[] getTracks(){
         return collection;
    }
    
    public boolean addTrackToAlbum(Track t)
    {
        if(nElements<trkCount)
        {
            collection[nElements++]=t;
            return true;
        }
        else
            return false;        
    }
    @Override
    public String toString()
    {
        return "[ Album Title:" + albumTitle + ", Artist Name=" + artistName + "]";
    }
}
