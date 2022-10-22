package system.services;

import system.Main;
import system.models.Person;
import system.models.Shift;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static system.Main.*;

public class ShiftService {

    public List<Shift> getShifts() {

        loadList();
        return  shiftsList;
    }

    public  void displayShifts() {

        if ( shifts.isEmpty() ) {

            System.out.println("There's no shifts yet.");

            Main.submenu();

        }
        else {

            System.out.println("************************************************************");
            System.out.printf("%7s %20s %20s %7s", "ID", "NAME", "LASTNAME", "DATE");
            System.out.println();
            System.out.println("************************************************************");
            for(Shift s: shiftsList){
                System.out.format("%7s %20s %20s %7s",
                        s.getPerson().getId(), s.getPerson().getName(), s.getPerson().getLastname(), s.getDay());
                System.out.println();
            }
            System.out.println("************************************************************");

            Main.submenu();
        }

    }

    public  void addShift(List<Person> people) {

        System.out.print("Is the user actually registered? PRESS 1");
        option = sc.nextInt();

        if (option == 1 ) {

            System.out.print("Please enter the id: ");
            int id = sc.nextInt();

            int index = personService.getIndex(id);

            System.out.print("Please enter the date: ");
            int date = sc.nextInt();

            Shift shift = new Shift(date, people.get(index));

            confirmShift(shift);

            //shiftsList.add(shift);



        } else {

            personService.addPeople();

            addShift(people);

        }


        Main.submenu();
    }

    public  void updateShift(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the identification number: ");
        int id = Integer.parseInt(sc.nextLine());

        Person personShift = new Person();

        Shift shiftFounded = null;

        for (int i = 0; i < people.size(); i++) {

            if (id == (people.get(i).getId())) {

                personShift = people.get(i);

            }

        }

        for (int i = 0; i < shiftsList.size(); i++) {

            if( shiftsList.get(i).getPerson().equals(personShift)) {

                shiftFounded = shiftsList.get(i);
                break;
            }
            else if (shiftsList.size()-1 == i ){

                System.out.println("the shift hasn't been founded!");

            }

        }

        if (shiftFounded != null) {

            System.out.println("Enter the new date: ");
            shiftFounded.setDay(sc.nextInt());
            System.out.println("The shift has been changed!");

        }

        System.out.println("Press 1 to return to the principal menu.");
        System.out.println("Press 2 to exit.");
        option = sc.nextInt();

        if (option == 1)
            menu();
    }

    public  void deleteShift(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the identification number: ");
        int id = Integer.parseInt(sc.nextLine());

        Person personShift = new Person();

        Shift shiftFounded = null;

        for (int i = 0; i < people.size(); i++) {

            if (id == (people.get(i).getId())) {

                personShift = people.get(i);
                break;

            }

        }

        for (int i = 0; i < shiftsList.size(); i++) {

            if( shiftsList.get(i).getPerson().equals(personShift)) {

                shiftFounded = shiftsList.get(i);
                break;
            }
            else if (shiftsList.size()-1 == i ){

                System.out.println("the shift hasn't been founded!");

            }

        }

        if(shiftFounded != null) {
            System.out.println("The shift has been deleted!");
            shiftsList.remove(shiftFounded);
        }


        System.out.println("Press 1 to return to the principal menu.");
        System.out.println("Press 2 to exit.");
        option = sc.nextInt();

        if (option == 1)
            menu();
    }

    public  void searchShifts() {

        System.out.print("Enter the identification number: ");
        int id = sc.nextInt();

        Person personShift = new Person();

        Shift shiftFounded = null;

        for (int i = 0; i < people.size(); i++) {

            if (id == (people.get(i).getId())) {

                personShift = people.get(i);

            }

        }

        for (int i = 0; i < shiftsList.size(); i++) {

            if( shiftsList.get(i).getPerson().equals(personShift)) {

                shiftFounded = shiftsList.get(i);
                break;
            }
            else if (shiftsList.size()-1 == i ){

                System.out.println("the shift hasn't been founded!");

            }

        }

        if (shiftFounded != null) {

            System.out.println("************************************************************");
            System.out.println("Id: " + shiftFounded.getPerson().getId());
            System.out.println("Name: " + shiftFounded.getPerson().getName());
            System.out.println("Lastname: " + shiftFounded.getPerson().getLastname());
            System.out.println("Day: " + shiftFounded.getDay());
            System.out.println("************************************************************");
            Main.menu();


        }

    }

    public  void confirmShift(Shift shift) {

        if( shiftsList.contains(shift)) {

            System.out.println("The shift already exists! \nTry another day...");
            addShift(people);
        }
        else {

            shiftsList.add(shift);
            System.out.println("The shift has been saved successflly!");
        }


    }

    private static void loadList() {


        //shiftsList.add(new Shift(1, new Person("Megan", "Wallace", 45)));
    }

    public static List<Shift> shiftsList = new ArrayList<>();

    private static int option;
    private PersonService personService = new PersonService();



    }
