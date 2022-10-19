package system;

import system.models.Patient;
import system.models.Shift;

import java.util.Scanner;

public class Main {

    /*------------------------------------------------------------MAIN------------------------------------------------------------*/

    public static void main(String[] args) {

        welcome();
        menu();



    }

    static void menu(){

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

        int menu;
        //Scanner sc = new Scanner(System.in);

        // FRONT //
        System.out.println("--------------------------------------------------------");
        System.out.println("\t\t\t\tWelcome to the shift system");
        System.out.println("--------------------------------------------------------");

        System.out.println("  ___\n" +
                "   //_\\\\_\n" +
                " .\"\\\\    \".\n" +
                "/          \\\n" +
                "|           \\_\n" +
                "|       ,--.-.)\n" +
                " \\     /  o \\o\\\n" +
                " /\\/\\  \\    /_/\n" +
                "  (_.   `--'__)\n" +
                "   |     .-'  \\\n" +
                "   |  .-'.     )\n" +
                "   | (  _/--.-'\n" +
                "   |  `.___.'\n" +
                "         (");

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

        Patient patient = new Patient(name, lastname, id);

        Shift shift = new Shift(day,id, patient);

        System.out.println("shift.getDay() = " + shift.getDay());
        //shifts.

        menu();
    }

    public static void displayShifts() {


    }

    public static void searchShifts() {


    }

    static int option;
    static Patient[] patients;
    public static Shift[] shifts;
    public static Scanner sc = new Scanner(System.in);

}
