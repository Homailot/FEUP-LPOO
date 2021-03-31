import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    private final String city;
    private final String country;
    private final String date;
    private final List<Act> acts;
    private int last_ticket;

    public int getLast_ticket() {
        last_ticket++;
        return last_ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return city.equals(concert.city) && country.equals(concert.country) && date.equals(concert.date) && acts.equals(concert.acts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date, acts);
    }

    public Concert(String city, String country, String date) {
        this.date = date;
        this.country = country;
        this.last_ticket = 0;
        this.city = city;
        this.acts = new ArrayList<>();
    }

    public void addAct(Act act) {
        this.acts.add(act);
    }

    public List<Act> getActs() {
        return acts;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    public boolean isValid(Ticket ticket) {
        return ticket.getConcert().equals(this);
    }

    public boolean participates(Artist artist) {
        for(Act act : acts) {
            if(act.containsArtist(artist)) {
                return true;
            }
        }

        return false;
    }
}
