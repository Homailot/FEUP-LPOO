import java.util.ArrayList;
import java.util.List;

public class Party extends Event {
    List<Event> eventList = new ArrayList<>();

    public Party(String name) {
        super(name);
    }

    public Party(String name, String date) {
        super(name, date);
    }

    public Party(String name, String date, String description) {
        super(name, date, description);
    }

    public void addEvent(Event e) {
        eventList.add(e);
    }

    @Override
    public int getAudienceCount() {
        int sum = 0;

        for(Event event : eventList) {
            sum += event.getAudienceCount();
        }

        return super.getAudienceCount() + sum;
    }
}
