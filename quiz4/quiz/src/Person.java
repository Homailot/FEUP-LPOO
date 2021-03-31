import java.util.Objects;

public abstract class Person extends User implements Comparable<Person>{
    private final String name;
    private final int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Person(String name) {
        this.name = name;
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        int ret;

        if((ret = this.getName().compareTo(o.getName())) == 0) {
            return Integer.compare(this.getAge(), o.getAge());
        }

        return ret;
    }

    @Override
    public String getUsername() {
        return name + age;
    }
}
