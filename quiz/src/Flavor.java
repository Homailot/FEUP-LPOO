import java.util.Objects;

public class Flavor {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flavor flavor = (Flavor) o;
        return flavor_name.equals(flavor.flavor_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavor_name);
    }

    private String flavor_name;

    Flavor(String flavor_name) {
        this.flavor_name = flavor_name;
    }


    public String getName() {
        return flavor_name;
    }
}
