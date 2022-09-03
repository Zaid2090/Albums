/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author USER
 */
public class AlbumCollection {
    private Album[] album_collection1;
    private ArrayList<Album> album_collection = new ArrayList<Album>();
    private int albmCount=19;
    private int nElements=0;
    static private Comparator<Album> ascArtistName;
    static private Comparator<Album> ascAlbumTitle;
    static private Comparator<Album> ascArtistName_AlbumTitle;

    //private int size;
    
    static {
        ascArtistName = new Comparator<Album>(){
            @Override
            public int compare(Album a1, Album a2){
                return a1.getArtistName().compareTo(a2.getArtistName());
            }
        };

        ascAlbumTitle = new Comparator<Album>(){
            @Override
            public int compare(Album a1, Album a2){               
                return a1.getAlbumTitle().compareTo(a2.getAlbumTitle());
            }
        };
        
        ascArtistName_AlbumTitle = new Comparator<Album>(){
            @Override
            public int compare(Album a1, Album a2){
                int value1 = a1.getArtistName().compareTo(a2.getArtistName());
                if(value1 == 0) 
                {
                    return a1.getAlbumTitle().compareTo(a2.getAlbumTitle());
                } 
                else 
                {
                    return value1;
                }
            }
        };
    }

    public AlbumCollection()
    {
        this.album_collection1= new Album[albmCount];
        this.nElements=0;
    }
    public boolean addAlbum(Album a)
    {
        if(nElements<albmCount)
        {
            album_collection1[nElements]=a;
            nElements=nElements+1;
            return true;
        }
        else
            return false;        
    }
    
    public void display()
    {
        //System.out.println("Albums Befor sorting:");
        //for(int i=0; i<nElements; i++)
        //    System.out.println(album_collection1[i].toString());        
        Arrays.sort(album_collection1, ascArtistName_AlbumTitle);
        //System.out.println("Albums After sorting:");
        for(int i=0; i<nElements; i++)
            System.out.println(album_collection1[i].toString());
        System.out.println("");
    }
    
    public Album getAlbum(String artistNm, String albmTitl)
    {
        for(int i=0; i<nElements; i++)
            if(album_collection1[i].getArtistName().equals(artistNm))
                if(album_collection1[i].getAlbumTitle().equals(albmTitl))
                    return album_collection1[i];
        return null;
    }
    
    public int getTotalTime(String artistName)
    {
        int tTime1=0;
        for(int i=0; i<nElements; i++)
        {
            if(album_collection1[i].getArtistName().equals(artistName))
            {
                Track[] trackArr=album_collection1[i].getTracks();
                for(int j=0; j<trackArr.length; j++)
                {
                    if(trackArr[j]!=null)
                    {
                        tTime1=tTime1+trackArr[j].getplaytimeBySeconds();
                    }
                }
            }
        }
        return tTime1;        
    }
    
    public String getAlbumLargestTrakNum()
    {
        int t=0, tt=0;
        String albumName="";
        for(int i=0; i<nElements; i++)
        {
            Track[] trackArr=album_collection1[i].getTracks();
            t=0;
            for(int j=0; j<trackArr.length; j++)
            {
                if(trackArr[j]!=null)
                {
                    t=t+1;
                }
            }
            if(t>tt)
            {
               tt=t;     
               albumName=album_collection1[i].getAlbumTitle();
            }
        }
        return albumName;        
    }
    
    public String getLongestTrack()
    {
        int t=0, tt=0;
        String trackTitle="";
        for(int i=0; i<nElements; i++)
        {
            Track[] trackArr=album_collection1[i].getTracks();
            t=0;
            for(int j=0; j<trackArr.length; j++)
            {
                if(trackArr[j]!=null)
                {
                    t=trackArr[j].getplaytimeBySeconds();
                }
                if(t>tt)
                {
                    tt=t;     
                    trackTitle=trackArr[j].getTitle();
                }
            }
            
        }
        return trackTitle;        
    }
}
