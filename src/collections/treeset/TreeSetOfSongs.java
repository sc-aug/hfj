package collections.treeset;

import java.util.*;
import java.io.*;

public class TreeSetOfSongs {
    
    ArrayList<Song> songList = new ArrayList<Song>();
    
    public static void main(String[] args) {
        new TreeSetOfSongs().go();
    }
    
    private void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
        TreeSet<Song> set = new TreeSet<Song>();
        set.addAll(songList);
        System.out.println(set);
    }
    
    private void getSongs() {
        try {
            String filePath = System.getProperty("user.dir");
            File file = new File(filePath + "/src/files/songlist.txt");
            System.out.println(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void addSong(String line) {
        String[] tokens = line.split("/");
        Song s = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(s);
    }
}
