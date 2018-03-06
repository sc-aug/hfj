package collections.sort2;

public class Song implements Comparable<Song> {
    String title;
    String artist;
    int rating;
    String bpm;
    
    Song(String t, String a, int r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }
    
    public int compareTo(Song o) {
        return this.title.compareTo(o.title);
    }
    
    public String toString() {
        return title + " - " + artist + " - " + rating + " - " + bpm;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public int getRating() {
        return rating;
    }
    
    public String getBpm() {
        return bpm;
    }
}
