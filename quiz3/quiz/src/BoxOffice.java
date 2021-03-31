import java.util.ArrayList;
import java.util.List;

public class BoxOffice {

    public static List<Ticket> buy(Concert concert, int num) throws InvalidTicket {
        List<Ticket> tickets = new ArrayList<>();

        while(num > 0) {
            tickets.add(new Ticket(concert.getLast_ticket(), concert));

            num--;
        }

        return tickets;
    }
}
