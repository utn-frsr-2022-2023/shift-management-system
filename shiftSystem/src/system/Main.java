package system;

import system.models.Person;
import system.models.Shift;
import system.services.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*------------------------------------------------------------MAIN------------------------------------------------------------*/

    public static void main(String[] args) {

        //welcome(); // Muestra el cartel de bienvenida.

        getData(); // Cargar datos desde services.

        menu(); // Muestra el menu.

    }
    
    // FRONT //
    static void menu(){
        //clear();
        do {

            System.out.println("Enter an option below: \n1. Display shifts. " +
                    "                                  \n2. Display people. " +
                    "                                  \n3. Add shifts." +
                    "                                  \n4. Add people." +
                    "                                  \n5. Update shifts." +
                    "                                  \n6. Update people." +
                    "                                  \n7. Delete shifts." +
                    "                                  \n8. Delete people." +
                    "                                  \n9. Search shifts." +
                    "                                 \n10. Search people." +
                    "                                 \n11. Exit.");
            option = Integer.parseInt(sc.nextLine());

        } while (option < 1 || option >= 12);

        switch (option){

            case 1: displayShifts();
                break;

            case 2: displayPeople();
                break;

            case 3: addShift();
                break;

            case 4: addPeople();
                break;
            case 5: updateShift();
                break;

            case 6: updatePeople();
                break;

            case 7: deleteShift();
                break;

            case 8: deletePeople();
                break;

            case 9: searchShifts();
                break;

            case 10 : searchUsers();
                break;

            case 11: break;

        }
    }

    static void welcome() {

        // FRONT //
        System.out.println("""
                     ==
                   //_\\\\_
                 ."\\\\    ".
                /          \\
                |           \\_
                |       ,--.-.)
                 \\     /  o \\o\\
                 /\\/\\  \\    /_/
                  (_.   `--'__)
                   |     .-'  \\
                   |  .-'.     )
                   | (  _/--.-'
                   |  `.___.'
                         (""");

        System.out.println("######################################################################");
        System.out.println("\t\t\t\tWelcome to the shift system");
        System.out.println("######################################################################");
        System.out.print("\nPress 1 to continue: ");
        int x = Integer.parseInt(sc.nextLine());
    }

    public static void clear() {

        for (int i = 0; i < 25; i++) {

            System.out.println();
            
        }
    }
    
    // BACK //
    public static void displayPeople(){

        PersonService personService = new PersonService();

        people = personService.getPersons();

        System.out.println("**************************************************");
        System.out.printf("%7s %20s %20s", "ID", "NAME", "LASTNAME");
        System.out.println();
        System.out.println("**************************************************");
        for(Person p: people){
            System.out.format("%7s %20s %20s",
                    p.getId(), p.getName(), p.getLastname());
            System.out.println();
        }
        System.out.println("**************************************************");



    }

    public static void displayShifts() {

        int x = shifts.size();

        if ( x > 0 ) {

            System.out.println("#######################################################################");
            System.out.format( "%15s %15s %10s %10s", "NAME", "LASTNAME", "ID", "SHIFT" );
            System.out.println();
            System.out.println("#######################################################################");
            for (Shift shift : shifts) {

                System.out.format("%15s %15s %10d %10c",
                        (shift.getPerson().getName()), (shift.getPerson().getLastname()),
                        (shift.getPerson().getId()), (shift.getDay()));
                System.out.println();

            }
            System.out.println("#######################################################################");
        }
        else {

            System.out.println("There's no shifts yet.");
        }

        menu();
    }

    public static void addShift() {

        System.out.print("Is the user actually registered?");
        String response = sc.nextLine().toLowerCase();

        if (response.equals("y")) {

            System.out.print("Please enter the id: ");
            int id = Integer.parseInt(sc.nextLine());



        } else {

            addPeople();
            confirmShift();
        }


        clear();
        menu();
    }

    public static void addPeople() {


        Person person = new Person();

        System.out.print("Enter the name: ");
        person.setName(sc.nextLine());

        System.out.print("Enter the lastname: ");
        person.setLastname(sc.nextLine());

        System.out.print("Enter the identification number: ");
        person.setId(Integer.parseInt(sc.nextLine()));

        // Llamado a la funcion para confirmar a la persona.
        confirmPeople(person);

        clear();
        menu();
    }

    public static void updateShift(){}

    public static void updatePeople(){}

    public static void deletePeople() {}

    public static void deleteShift(){}

    public static void searchShifts() {


    }

    public static void searchUsers() {}
    
    public static void getData() {

        PersonService dataSrc = new PersonService();
        people = dataSrc.getPersons();
    }


    public static void confirmPeople(Person person) {

        if( people.contains(person)) {

            System.out.println("The user already exists! \nTry again...");
            addPeople();
        }
        else {

            people.add(person);

            PersonService personService = new PersonService();
            personService.setPersons(people);
            System.out.println("The user has been added successflly!");
        }

    }

    public static void confirmShift() {

        System.out.print("Enter the date: ");
        int date = Integer.parseInt(sc.nextLine());

        /*int day, day2;
        day2 = shift.getDay();

        if(shifts != null) {

            for (Shift value : shifts) {

                day = value.getDay();

                if (day != day2) {

                    break;

                } else {

                    // Se cambia la fecha.
                    System.out.print("Please, enter another date: ");
                    day2 = Integer.parseInt(sc.nextLine());
                    shift.setDay(day2);

                }
            }
        }*/


    }


    static int option;
    public static List<Person> people = new ArrayList<>();
    public static List<Shift> shifts = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

}
