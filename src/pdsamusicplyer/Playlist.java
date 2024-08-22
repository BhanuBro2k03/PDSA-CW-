package pdsamusicplyer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Playlist {
    private Song head;
    private Song current;
    private boolean isShuffle;
    private boolean isRepeat;
    private ArrayList<Song> history;
    private LinkedList<String> songs;

    public Playlist() {
        this.songs = new LinkedList<>();
        this.head = null;
        this.current = null;
        this.isShuffle = false;
        this.isRepeat = false;
        this.history = new ArrayList<>();
    }

    public void addSong(String title, String artist) {
        Song newSong = new Song(title, artist);
        if (head == null) {
            head = newSong;
        } else {
            Song temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newSong);
        }
    }

    public void removeSong(String title) {
        if (head == null) return;
        if (head.getTitle().equals(title)) {
            head = head.getNext();
            return;
        }
        Song temp = head;
        while (temp.getNext() != null && !temp.getNext().getTitle().equals(title)) {
            temp = temp.getNext();
        }
        if (temp.getNext() != null) {
            temp.setNext(temp.getNext().getNext());
        }
    }

    public Song getCurrentSong() {
        return current;
    }

    public void play() {
        if (current == null) {
            current = head;
            history.clear();
        }
    }

    public void pause() {
        // Logic to pause playback (Placeholder)
    }

    public void next() {
        if (current != null) {
            history.add(current);  // Add the current song to history
            current = current.getNext();
            if (current == null && isRepeat) {
                current = head;  // Start from the beginning if repeat is on
            }
        }
    }

    public void previous() {
        if (!history.isEmpty()) {
            current = history.remove(history.size() - 1);  // Move back to the previous song
        }
    }

    public void toggleShuffle() {
        isShuffle = !isShuffle;
        if (isShuffle) {
            shufflePlaylist();
        } else {
            unshufflePlaylist();
        }
    }

    private void shufflePlaylist() {
        LinkedList<Song> songsList = new LinkedList<>();
        Song temp = head;
        while (temp != null) {
            songsList.add(temp);
            temp = temp.getNext();
        }
        Collections.shuffle(songsList);
        head = songsList.get(0);
        for (int i = 0; i < songsList.size() - 1; i++) {
            songsList.get(i).setNext(songsList.get(i + 1));
        }
        songsList.get(songsList.size() - 1).setNext(null);
    }

    private void unshufflePlaylist() {
        // Implement logic to revert back to the original order, if needed
    }

    public void toggleRepeat() {
        isRepeat = !isRepeat;
    }

    public boolean isShuffle() {
        return isShuffle;
    }

    public boolean isRepeat() {
        return isRepeat;
    }

    public Song getHead() {
        return head;
    }
    
    public LinkedList<String> getSongs() {
        return songs;
    }
}
