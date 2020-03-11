public class Speaker extends User {
    private int fee = 0;

    public Speaker(String name) {
        super(name);
    }

    public Speaker(String name, int age) {
        super(name, age);
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Speaker " + this.name + " has a fee value of " + this.fee + ".";
    }
}
