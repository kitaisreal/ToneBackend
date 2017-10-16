package hello.entities;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class AppArtist {
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    String artist_name;
    String artist_genre;
    String artist_artwork_url;
    public AppArtist(){
    }
    public AppArtist(Long id, String pArtistName, String pArtistArtUrl, String pArtistGenre) {
        this.id = id;
        this.artist_name = pArtistName;
        this.artist_genre = pArtistGenre;
        this.artist_artwork_url = pArtistArtUrl;
    }

    public String getArtist_genre() {
        return artist_genre;
    }

    public void setArtist_genre(String artist_genre) {
        this.artist_genre = artist_genre;
    }

    public String getArtist_artwork_url() {
        return artist_artwork_url;
    }

    public void setArtist_artwork_url(String artist_artwork_url) {
        this.artist_artwork_url = artist_artwork_url;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
