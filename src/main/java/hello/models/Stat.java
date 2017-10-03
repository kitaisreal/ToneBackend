package hello.models;


import javax.persistence.*;

@Entity
@Table(name="stats")
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    private int song_id;
    private int mean;
    private int median;
    private int stdev;
    private int kurtosis;
    private int skew;
    private int amplitude;
    private int offset;

    public Stat(int song_id, int mean, int median, int stdev, int kurtosis, int skew, int amplitude, int offset) {
        this.song_id = song_id;
        this.mean = mean;
        this.median = median;
        this.stdev = stdev;
        this.kurtosis = kurtosis;
        this.skew = skew;
        this.amplitude = amplitude;
        this.offset = offset;
    }
    private Stat(){

    }
    public int getSong_id() {

        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public int getMean() {
        return mean;
    }

    public void setMean(int mean) {
        this.mean = mean;
    }

    public int getMedian() {
        return median;
    }

    public void setMedian(int median) {
        this.median = median;
    }

    public int getStdev() {
        return stdev;
    }

    public void setStdev(int stdev) {
        this.stdev = stdev;
    }

    public int getKurtosis() {
        return kurtosis;
    }

    public void setKurtosis(int kurtosis) {
        this.kurtosis = kurtosis;
    }

    public int getSkew() {
        return skew;
    }

    public void setSkew(int skew) {
        this.skew = skew;
    }

    public int getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(int amplitude) {
        this.amplitude = amplitude;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
