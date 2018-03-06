package collections.hashset;

public class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;
    
    Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }
    
    public int compareTo(Song o) {
        return this.title.compareTo(o.title);
    }
    
    public String toString() {
        return title;
    }
    
    public boolean equals(Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }
    
    public int hashCode() {
        return title.hashCode();
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public String getRating() {
        return rating;
    }
    
    public String getBpm() {
        return bpm;
    }
}