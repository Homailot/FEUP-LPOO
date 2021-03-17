public class AreaStringOutputter {
    private final SumProvider sumProvider;

    AreaStringOutputter(SumProvider sumProvider) {
        this.sumProvider = sumProvider;
    }

    public String output() {
        return "Sum of areas: " + sumProvider.sum();
    }
}
