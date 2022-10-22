package system.services;

import java.util.Scanner;

public class FrontService {

    public  void welcome() {

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
        option = sc.nextInt();
    }
    public  void menu(){
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
            option = sc.nextInt();

        } while (option < 1 || option >= 12);

        switch (option){

            case 1: shiftService.displayShifts();
                break;

            case 2: personService.displayPeople(personService.getPersons());
                break;

            case 3: shiftService.addShift(personService.getPersons());
                break;

            case 4: personService.addPeople();
                break;
            case 5: shiftService.updateShift();
                break;

            case 6: personService.updatePeople(personService.getPersons());
                break;

            case 7: shiftService.deleteShift();
                break;

            case 8: personService.deletePeople(personService.getPersons());
                break;

            case 9: shiftService.searchShifts();
                break;

            case 10 : personService.searchPeople(personService.getPersons());
                break;

            case 11: break;

        }
    }

    public  void submenu() {


        int option;

        do {

            System.out.println("1. Press 1 to return to the principal menu: ");
            System.out.println("2. Press 2 to exit");
            option = sc.nextInt();

        } while (option < 1 || option >= 3);

        switch (option){

            case 1: menu();
                break;

            case 2: break;

        }
    }

    public  void clear() {

        for (int i = 0; i < 25; i++) {

            System.out.println();

        }
    }

    private static int option;
    private static final Scanner sc = new Scanner(System.in);

    private static final PersonService personService = new PersonService();
    private static final ShiftService shiftService = new ShiftService();
}
