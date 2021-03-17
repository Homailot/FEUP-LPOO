public class AreaXMLOutputter {
    private final SumProvider sumProvider;

    AreaXMLOutputter(SumProvider sumProvider) {
        this.sumProvider = sumProvider;
    }

    public String output() {
        return "<area>" + sumProvider.sum() + "</area>";
    }
}
