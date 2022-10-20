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

        Patient patient = new Patient(name, lastname, id);

        Shift shift = new Shift(day,id, patient);

        confirmShift(shift);
        
        while (!approved) {

            System.out.println("Try another day: ");
            day = Integer.parseInt(sc.nextLine());
            shift.setDay(day);
            confirmShift(shift);
        }


        clear();
        menu();
    }

    public static boolean confirmShift(Shift shift) {


        if(shifts != null) {

            for (int i = 0; i <shifts.length; i++) {

                if((shifts[i].getDay()) != shift.getDay()) {

                    approved = true;
                    shifts[0] = new Shift(shift);
                    System.out.println("The shift has been confirmed!");
                }
                else {

                    approved = false;
                }
            }

        }
        else {

            approved = true;
            shifts[0] = new Shift(shift);
            System.out.println("The shift has been confirmed!");
        }

        return approved;
    }

    public static void displayShifts() {

        for (int i = 0; i < shifts.length; i++) {

            if (shifts[i] != null) {
                System.out.println("Patient: " + shifts[i].getPatient().getName() + " " + shifts[i].getPatient().getLastname());
                System.out.println("Id: " + shifts[i].getId());
                System.out.println("Day: " + shifts[i].getDay());


            }
        }
    }

    public static void searchShifts() {


    }

    static int option;
    public static Patient[] patients = new Patient[1000];
    public static Shift[] shifts = new Shift[1000];
    public static Scanner sc = new Scanner(System.in);

    public static boolean approved;

}
