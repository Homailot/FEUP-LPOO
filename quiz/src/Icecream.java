
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Icecream {
    private List<Flavor> flavors;

    Icecream(){
        flavors = new ArrayList<>();
    }

    public void addScoop(Flavor flavor) {
        flavors.add(flavor);
    }

    public boolean removeScoop(Flavor flavor) {
        return flavors.remove(flavor);
    }

    public int getScoopCount() {
        return flavors.size();
    }

    public int getFlavorCount() {
        Set<Flavor> unique = new HashSet<>(flavors);
        return unique.size();
    }

    public Boolean contains(String flavor_name) {
        return flavors.contains(new Flavor(flavor_name));
    }
}
