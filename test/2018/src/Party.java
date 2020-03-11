import java.util.ArrayList;

public class Party extends Event {
    private ArrayList<Event> events = new ArrayList<>();

    public Party(String title) {
        super(title);
    }

    public Party(String title, String date) {
        super(title, date);
    }

    public Party(String title, String date, String description) {
        super(title, date, description);
    }

    public Party(Event event) {
        super(event);
    }

    public void addEvent(Event event) {
        for (Event e : this.events)
            if (e.equals(event))
                return;
        this.events.add(event);
    }

    @Override
    public int getAudienceCount() {
        int res = super.getAudienceCount();
        for (Event event : this.events)
            res += event.getAudienceCount();
        return res;
    }
}
