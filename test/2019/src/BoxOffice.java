import java.util.ArrayList;

public class BoxOffice {
    private static ArrayList<Ticket> tickets = new ArrayList<>();

    private static int getHigherTicket(Concert concert) {
        int max = 0;
        for (Ticket t : tickets)
            if (t.getConcert().equals(concert) && (t.getNumber() > max || max == 0))
                max = t.getNumber();
        return max;
    }

    public static ArrayList<Ticket> buy(Concert concert, int n) throws InvalidTicket {
        int m = getHigherTicket(concert) + 1;
        ArrayList<Ticket> result = new ArrayList<>();
        for (int i = m; i < n + m; ++i) {
            Ticket ticket = new Ticket(i, concert);
            tickets.add(ticket);
            result.add(ticket);
        }
        return result;
    }
}
