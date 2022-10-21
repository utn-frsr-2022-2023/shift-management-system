package system;

import system.models.Person;
import system.models.Shift;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*------------------------------------------------------------MAIN------------------------------------------------------------*/

    public static void main(String[] args) {

        welcome();
        menu();



    }

    static void menu(){
        clear();
        do {

            System.out.println("Enter an option below: \n1. Enter shifts. \n2. See shifts. \n3. Search shift. \n4. Exit"    );
            option = Integer.parseInt(sc.nextLine());

        } while (option < 1 || option >=5);

        switch (option){

            case 1: newShift();

            case 2: displayShifts();

            case 3: searchShifts();

            case 4: break;

        }
    }

    static void welcome() {

        // FRONT //
        System.out.println("--------------------------------------------------------");
        System.out.println("\t\t\t\tWelcome to the shift system");
        System.out.println("--------------------------------------------------------");

        System.out.println("""
                  ___
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

    }

    public static void clear() {

        for (int i = 0; i < 25; i++) {

            System.out.println();
            
        }
    }

    public static void newShift() {

        System.out.println("Enter the name: ");
        String name = sc.nextLine();

        System.out.println("Enter the lastname: ");
        String lastname = sc.nextLine();

        System.out.println("Enter the ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the day: ");
        int day = Integer.parseInt(sc.nextLine());

        // Instancia de persona
        Person person = new Person(name, lastname, id);
        // Agregar a la persona a la base de datos.
        people.add(person);

        // Instancia de turno.
        Shift shift = new Shift(day,id, person);
        // Agregar el turno a la base de datos.
        shifts.add(shift);

        //Llamado a la funcion para confirmar el turno.
        //confirmShift(shift, person);

        // A modular.
        /*while (!approved) {

            System.out.println("Try another day: ");
            day = Integer.parseInt(sc.nextLine());
            shift.setDay(day);
            confirmShift(shift, person);
        }*/


        clear();
        menu();
    }

    public static void confirmShift(Shift shift, Person person) {

        int day, day2;


        //Si el Arraylist esta vacío el turno es insertado.
        if(shifts == null) {

            approved = true;

            System.out.println("The shift has been confirmed!");


        }
        else {

            for (int i = 0; i < shifts.size(); i++) {

                day = shifts.get(i).getDay();

                day2 = shift.getDay();



                if(day != day2) {
                    approved = true;
                    shifts.add(shift);
                    System.out.println("The shift has been confirmed!");
                    break;

                }
                else {

                    approved = false;
                }


            }
        }

    }

    public static void displayShifts() {

        int x = shifts.size();

        if (x > 0 ) {

                System.out.println("#######################################################################");
                System.out.format("%15s %15s %10s %10s", "NAME", "LASTNAME", "ID", "SHIFT");
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
    public static boolean approved;

}
