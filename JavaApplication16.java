/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.io.*;

/**
 *
 * @author USER
 */


public class JavaApplication16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //Qustion1//////////////////////////////////////////////////////////////////    
        // The name of the file to open.
        String fileName = "albums.txt";
        // This will reference one line at a time
        String line = null;
        AlbumCollection albmClction = new AlbumCollection();
        Album  albm = null ;
        
        try {            
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) 
            {
                // Here code to create all classes
                //System.out.println(line);
                String[] albumArr=line.split(" : ");
                if(albumArr.length>1)
                {
                    albm = new Album(albumArr[0], albumArr[1], 20);                    
                    albmClction.addAlbum(albm);
                    //System.out.println(albumArr[0]);
                }
                String[] trackArr=line.split(" - ");
                
                if(trackArr.length>1)
                {
                    String[] DurationArr=trackArr[0].split(":");
                    Duration dur = new Duration(Integer.parseInt(DurationArr[0])
                            ,Integer.parseInt(DurationArr[1])
                            ,Integer.parseInt(DurationArr[2]));                    
                    Track trk= new Track(dur, trackArr[1]);
                    albm.addTrackToAlbum(trk);                    
                    
                }
            }   
            //Qustion2//////////////////////////////////////////////////////////
            System.out.println("//Qustion2//");
            albmClction.display();
            //Qustion3//////////////////////////////////////////////////////////
            System.out.println("//Qustion3//");
            int totalTime=albmClction.getTotalTime("Pink Floyd");
            System.out.println("Total Time Of Album Pink Floyd is : " + 
                    totalTime + " sec.");
            //Qustion4//////////////////////////////////////////////////////////
            System.out.println("//Qustion4//");
            String albumName=albmClction.getAlbumLargestTrakNum();
            System.out.println("Album With greatest Album num is : " + 
                   albumName + ".");
            //Qustion5//////////////////////////////////////////////////////////
            System.out.println("//Qustion5//");
            String trkTitle=albmClction.getLongestTrack();
            System.out.println("Longest Track is : " + trkTitle + ".");
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println( "Error reading file '" + fileName + "'");                  
        }
        //Qustion6//////////////////////////////////////////////////////////////
        // The name of the file to open.
        System.out.println("//Qustion6//");
        fileName = "playlist.txt";
        // This will reference one line at a time
        line = null;        
        Playlist  playList1 = new Playlist(albmClction);
        Album albm1 = null;
        try {            
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int totalTimPLst=0;
            while((line = bufferedReader.readLine()) != null) 
            {
                // Here code to create all classes
                String[] albumArr=line.split("\\(");
                String[] strAlbmInfo=albumArr[1].split(" : ");
                albm1=albmClction.getAlbum(strAlbmInfo[0],
                                           strAlbmInfo[1].replace(")", ""));
                //System.out.println(albm1.getAlbumTitle());
                if(albm1!=null)
                {//playList1.addTracksToPlaylist(albm1);
                totalTimPLst+=playList1.getTotalTimToAlbumInOPlayList(albm1);}
            }   
            System.out.println("total play time of the PlayList :"+
                    totalTimPLst+" sec.");
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println( "Error reading file '" + fileName + "'");                  
        }    
    }
}
