import java.util.Objects;

public abstract class Act {
    protected String name;
    protected String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Act act = (Act) o;
        return name.equals(act.name) && country.equals(act.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public abstract boolean containsArtist(Artist artist);
}
