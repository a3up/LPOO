import java.util.ArrayList;
import java.util.Objects;

public class Concert {
    private String city;
    private String country;
    private String date;
    private ArrayList<Act> acts = new ArrayList<>();

    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Act> getActs() {
        return this.acts;
    }

    public void addAct(Act act) {
        this.acts.add(act);
    }

    public boolean isValid(Ticket ticket) {
        return this.equals(ticket.getConcert());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(city, concert.city) &&
                Objects.equals(country, concert.country) &&
                Objects.equals(date, concert.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date);
    }

    public boolean participates(Artist artist) {
        for (Act act : acts) {
            if (act.equals(artist))
                return true;
            for (Artist a : act.getArtists())
                if (a.equals(artist))
                    return true;
        }
        return false;
    }
}
