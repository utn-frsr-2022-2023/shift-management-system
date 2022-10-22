package system.models;

public class Shift {

    private int day;
    private Person person;

    public Shift(int day, Person person) {

        this.person = person;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }



}
