package system.models;

public class Shift {

    private int day;
    private int id;
    private Person person;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Shift(int day, int id, Person person) {

        this.person = person;
        this.day = day;
        this.id = id;
    }

}
