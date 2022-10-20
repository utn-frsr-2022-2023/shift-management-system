package system.models;

public class Shift {

    int day;
    int id;

    Patient patient;

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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Shift(int day, int id, Patient patient) {

        this.patient = patient;
        this.day = day;
        this.id = id;
    }

    public Shift(Shift shift) {

        this.patient = shift.patient;
        this.day = shift.day;
        this.id = shift.id;
    }
}
