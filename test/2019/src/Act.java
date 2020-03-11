import java.util.ArrayList;
import java.util.Objects;

public abstract class Act {
    protected String name;
    protected String country;
    protected ArrayList<Artist> artists = new ArrayList<>();

    public Act(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    public void addArtist(Artist artist) {
        this.artists.add(artist);
    }

    public boolean containsArtist(Artist artist) {
        for (Artist a : this.artists)
            if (a.equals(artist))
                return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Act act = (Act) o;
        return Objects.equals(name, act.name) &&
                Objects.equals(country, act.country) &&
                Objects.equals(artists, act.artists);
    }
}
