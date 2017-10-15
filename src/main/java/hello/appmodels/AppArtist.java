package hello.appmodels;

public class AppArtist {
    String mArtistName;
    String mArtistArtUrl;
    String mArtistGenre;
    public AppArtist(String pArtistName,String pArtistArtUrl, String pArtistGenre){
        this.mArtistName=pArtistName;
        this.mArtistArtUrl=pArtistArtUrl;
        this.mArtistGenre=pArtistGenre;
    }

    public String getmArtistArtUrl() {
        return mArtistArtUrl;
    }

    public void setmArtistArtUrl(String mArtistArtUrl) {
        this.mArtistArtUrl = mArtistArtUrl;
    }

    public String getmArtistGenre() {
        return mArtistGenre;
    }

    public void setmArtistGenre(String mArtistGenre) {
        this.mArtistGenre = mArtistGenre;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public void setmArtistName(String mArtistName) {
        this.mArtistName = mArtistName;
    }
}
