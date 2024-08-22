package pdsamusicplyer;

public class Song {
    private String title;
    private String artist;
    private Song next;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.next = null;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Song getNext() {
        return next;
    }

    public void setNext(Song next) {
        this.next = next;
    }
}
