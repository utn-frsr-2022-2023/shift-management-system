package system;

import system.models.Person;
import system.models.Shift;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*------------------------------------------------------------MAIN------------------------------------------------------------*/

    public static void main(String[] args) {


        // Llamado al cartel de bienvenida.
        //welcome();
        // Llamado al menu.
        menu();

    }

    static void menu(){
        clear();
        do {

            System.out.println("Enter an option below: \n1. Enter shifts. \n2. See shifts. \n3. Search shift. \n4. Exit"    );
            option = Integer.parseInt(sc.nextLine());

        } while (option < 1 || option >= 5);

        switch (option){

            case 1: newShift();

            case 2: displayShifts();

            case 3: searchShifts();

            case 4: break;

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

    public static void newShift() {

        System.out.print("Enter the name: ");
        String name = sc.nextLine();

        System.out.print("Enter the lastname: ");
        String lastname = sc.nextLine();

        System.out.print("Enter the identification number: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter the day: ");
        int day = Integer.parseInt(sc.nextLine());

        // Instancia de persona
        Person person = new Person(name, lastname, id);

        // Llamado a la funcion para confirmar a la persona.
        confirmPerson(person);

        // Agregar a la persona a la base de datos.
        people.add(person);
        System.out.println(person.getName() + " " + person.getLastname() + " has been added successfully to our database!");

        // Instancia de turno.
        Shift shift = new Shift(day,id, person);

        // Llamado a la funcion para confirmar el turno.
        confirmShift(shift);

        // Agregar el turno a la base de datos.
        shifts.add(shift);
        System.out.println("The shift has been added successfully to our database!");

        clear();
        menu();
    }

    public static void addPerson() {

        System.out.print("Enter the name: ");
        String name = sc.nextLine();

        System.out.print("Enter the lastname: ");
        String lastname = sc.nextLine();

        System.out.print("Enter the identification number: ");
        int id = Integer.parseInt(sc.nextLine());

        // Instancia de persona
        Person person = new Person(name, lastname, id);

        // Llamado a la funcion para confirmar a la persona.
        confirmPerson(person);

        // Agregar a la persona a la base de datos.
        people.add(person);
        System.out.println(person.getName() + " " + person.getLastname() + " has been added successfully to our database!");

    }

    // BACK //

    public static void confirmPerson(Person person) {

        int id, id2;
        id2 = person.getId();

        if(shifts != null) {

            for (Shift value : shifts) {

                id = value.getId();

                if (id != id2) {

                    break;

                } else {

                    // Se cambia el Id.
                    System.out.print( "Please, enter another identification number: " );
                    id2 = Integer.parseInt(sc.nextLine());
                    person.setId(id2);

                }
            }
        }

    }

    public static void confirmShift(Shift shift) {



        int day, day2;
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
        }


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

    public static void searchShifts() {


    }

    static int option;
    public static List<Person> people = new ArrayList<>();
    public static List<Shift> shifts = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

}
