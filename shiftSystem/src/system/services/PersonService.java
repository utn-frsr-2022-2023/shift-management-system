package system.services;

import system.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    public List<Person> getPersons() {
        loadList();
        return  personsList;
    }

    public void setPersons( List<Person> personList) {

        personsList = personList;
    }

    public static List<Person> personsList = new ArrayList<>();



    public static Person[] arrayPeople = new Person[10];

    public static void loadList() {

        personsList.add(new Person("Daenerys", "Targaryen", 1));
        personsList.add(new Person("Jon", "Snow", 2));
        personsList.add(new Person("Catelyn", "Stark", 3));
        personsList.add(new Person("Eddard", "Stark", 4));
        personsList.add(new Person("Robb", "Stark", 5));
        personsList.add(new Person("Sansa", "Stark", 6));
        personsList.add(new Person("Aria", "Stark", 7));
        personsList.add(new Person("Khal", "Drogo", 8));
        personsList.add(new Person("Tyrion", "Lannister", 9));
        personsList.add(new Person("Cersei", "Lannister", 10));
    }



}
