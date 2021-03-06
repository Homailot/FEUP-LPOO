import java.util.ArrayList;
import java.util.List;

public class Band extends Act {
    private final List<Artist> artists;

    public Band(String name, String country) {
        super.name = name;
        super.country = country;
        this.artists = new ArrayList<>();
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public boolean containsArtist(Artist artist) {
        return artists.contains(artist);
    }
}
