public class User extends Person {
    public User(String name) {
        super(name);
    }

    public User(String name, int age) {
        super(name, age);
    }

    public String getUsername() {
        return name + age;
    }
}
