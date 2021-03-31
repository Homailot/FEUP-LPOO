import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Event {
    private String title;
    private String date;
    private String description;
    private final List<Person> audience = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return title.equals(event.title) && date.equals(event.date) && description.equals(event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, description);
    }

    public Event(String title) {
        this.title = title;
        this.date = "";
        this.description = "";
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
        this.description = "";
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public Event(Event e) {
        this.description = e.description;
        this.date = e.date;
        this.title = e.title;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title + " is a " + description + " and will be held at " + date + ".";
    }

    public void addPerson(Person person) {
        for(Person audience_person : audience) {
            if(audience_person.getName().equals(person.getName())) return;
        }
        audience.add(person);
    }

    public int getAudienceCount() {
        return audience.size();
    }
}
