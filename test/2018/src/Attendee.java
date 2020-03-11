public class Attendee extends User {
    private boolean paid = false;

    public Attendee(String name) {
        super(name);
    }

    public Attendee(String name, int age) {
        super(name, age);
    }

    public boolean hasPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Attendee " + this.name + (this.paid ? " has" : " hasn't") + " paid its registration.";
    }
}
