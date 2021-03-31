import java.util.Objects;

public class Ingredient {
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
