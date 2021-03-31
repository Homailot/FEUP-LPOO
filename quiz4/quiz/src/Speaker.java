public class Speaker extends Person {
    private final int fee=0;

    public Speaker(String name) {
        super(name);
    }

    public Speaker(String name, int age) {
        super(name, age);
    }

    public int getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "Speaker " + getName() + " has a fee value of " + fee + ".";
    }
}
