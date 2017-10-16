package hello.entities;

import javax.persistence.*;

@Entity
@Table(name="songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    private String song_name;
    private String artist_name;
    private int song_stat;

    public Song(String song_name, String artist_name, int song_stat) {
        this.song_name = song_name;
        this.artist_name = artist_name;
        this.song_stat = song_stat;
    }
    private Song(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public int getSong_stat() {
        return song_stat;
    }

    public void setSong_stat(int song_stat) {
        this.song_stat = song_stat;
    }
}