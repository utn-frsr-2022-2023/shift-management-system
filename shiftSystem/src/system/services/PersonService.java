package system.services;

import system.Main;
import system.models.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService {

    public List<Person>getPersons() {

        loadList();
        return  personsList;
    }
    public  void addPeople() {


        Person person = new Person();

        System.out.print("Enter the name: ");
        person.setName(sc.nextLine());

        System.out.print("Enter the lastname: ");
        person.setLastname(sc.nextLine());

        System.out.print("Enter the identification number: ");
        person.setId(Integer.parseInt(sc.nextLine()));

        // Llamado a la funcion para confirmar a la persona.
        confirmPeople(person);

        //clear();
        Main.menu();
    }
    public  void updatePeople(List<Person> people){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the identification number: ");
        int id = Integer.parseInt(sc.nextLine());

        Person personToUpdate = new Person();


        for (int i = 0; i < people.size(); i++) {

            if (id == (people.get(i).getId())) {

                personToUpdate = people.get(i);

            }

        }

        System.out.print("Enter the name: ");
        personToUpdate.setName(sc.nextLine());

        System.out.print("Enter the lastname: ");
        personToUpdate.setLastname(sc.nextLine());

        System.out.println("The person has been updated!");
        System.out.println("Press 1 to return to the principal menu.");
        System.out.println("Press 2 to exit.");
        int option = Integer.parseInt(sc.nextLine());

        if (option == 1)
            Main.menu();
    }
    public  void deletePeople(List<Person> people) {

        //Scanner sc = new Scanner(System.in);

        Person personToRemove = new Person();

        System.out.print("Enter the name: ");
        personToRemove.setName(sc.nextLine());

        System.out.print("Enter the lastname: ");
        personToRemove.setLastname(sc.nextLine());

        System.out.print("Enter the identification number: ");
        personToRemove.setId(Integer.parseInt(sc.nextLine()));

        for (int i = 0; i < people.size(); i++) {

            if (personToRemove.getName().equals(people.get(i).getName()) || personToRemove.getLastname().equals(people.get(i).getLastname()) || personToRemove.getId() == (people.get(i).getId())) {

                people.remove(i);
                System.out.println("The person has been deleted!");
                break;


            } else if (i == people.size()-1) {

                System.out.println("The person couldn't be found.");
                System.out.println("Press 1 to try again.");
                System.out.println("Press 2 to go to the principal menu.");
                System.out.println("Press 3 to exit.");
                int option = Integer.parseInt(sc.nextLine());

                if (option == 1) {
                    deletePeople(people);
                } else if (option == 2) {
                    Main.menu();
                }
                else {
                    break;
                }

            }
        }


        //clear();
        Main.menu();
    }
    public  void confirmPeople(Person person) {

        if( personsList.contains(person)) {

            System.out.println("The user already exists! \nTry again...");
            addPeople();
        }
        else {

            personsList.add(person);
            System.out.println("The user has been added successflly!");
        }

    }
    public  void displayPeople(List<Person> people){

        if ( people.isEmpty() ) {

            System.out.println("There's no people yet.");

        }
        else {

            System.out.println("**************************************************");
            System.out.printf("%7s %20s %20s", "ID", "NAME", "LASTNAME");
            System.out.println();
            System.out.println("**************************************************");
            for (Person p : people) {
                System.out.format("%7s %20s %20s",
                        p.getId(), p.getName(), p.getLastname());
                System.out.println();
            }
            System.out.println("**************************************************");
        }
        Main.submenu();
    }
    public  void searchPeople(List<Person> people) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the identification number: ");
        int id = Integer.parseInt(sc.nextLine());

        Person foundedPerson = new Person();


        for (int i = 0; i < people.size(); i++) {

            if (id == (people.get(i).getId())) {

                foundedPerson = people.get(i);

                System.out.println("************************************************************");
                System.out.println("Id: " + id);
                System.out.println("Name: " + foundedPerson.getName());
                System.out.println("Lastname: " + foundedPerson.getLastname());
                System.out.println("************************************************************");
                Main.menu();
                break;

            }
            else if (i == people.size()-1) {

                System.out.println("The person doesn't exist!.");
                System.out.println("Press 1 to try again.");
                System.out.println("Press 2 to return to the principal menu.");
                System.out.println("Press 3 to exit.");
                int option = Integer.parseInt(sc.nextLine());

                if (option == 1) {
                    searchPeople(people);
                } else if (option == 2) {
                    Main.menu();
                }
                else {
                    break;
                }
            }
        }

    }
    public static List<Person> personsList = new ArrayList<>();
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

    private static final Scanner sc = new Scanner(System.in);



}
