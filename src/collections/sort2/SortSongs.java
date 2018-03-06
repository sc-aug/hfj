package collections.sort2;

import java.util.*;

import collections.sort2.comparator.*;

import java.io.*;

public class SortSongs {
    
    ArrayList<Song> songList = new ArrayList<Song>();
    
    public static void main(String[] args) {
        new SortSongs().go();
    }
    
    private void go() {
        getSongs();
        printList(songList);
        Collections.sort(songList, new TitleComparator());
        printList(songList);
        Collections.sort(songList, new ArtistComparator());
        printList(songList);
        Collections.sort(songList, new RatingComparator());
        printList(songList);
    }
    
    private void getSongs() {
        try {
            File file = new File("src/files/songlist.txt");
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
        Song s = new Song(tokens[0], tokens[1], Integer.parseInt(tokens[2]), tokens[3]);
        songList.add(s);
    }
    
    private void printList(List<Song> list) {
        System.out.println("*********************");
        for (Song s: list) {
            System.out.println(s.toString());
        }
        System.out.println("*********************");
    }
    
}
