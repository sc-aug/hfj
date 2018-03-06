package collections.sort2.comparator;

import java.util.Comparator;

import collections.sort2.Song;

public class RatingComparator implements Comparator<Song> {
    public int compare(Song a, Song b) {
        return a.getRating() - b.getRating();
    }
}