package system.services;

import system.Main;
import system.models.Person;
import system.models.Shift;

import java.util.ArrayList;
import java.util.List;

import static system.Main.*;

public class ShiftService {

    public List<Shift> getShifts() {

        loadList();
        return  shiftsList;
    }

    public  void displayShifts() {

        if ( shifts.isEmpty() ) {

            System.out.println("There's no shifts yet.");

        }
        else {

            System.out.println("************************************************************");
            System.out.printf("%7s %20s %20s %7s", "ID", "NAME", "LASTNAME", "DATE");
            System.out.println();
            System.out.println("************************************************************");
            for(Shift s: shiftsList){
                System.out.format("%7s %20s %20s %7s",
                        s.getId(), s.getPerson().getName(), s.getPerson().getLastname(), s.getDay());
                System.out.println();
            }
            System.out.println("************************************************************");

            Main.submenu();
        }

    }

    public  void addShift() {

        System.out.print("Is the user actually registered?");
        String response = sc.nextLine().toLowerCase();

        if (response.equals("y")) {

            System.out.print("Please enter the id: ");
            int id = Integer.parseInt(sc.nextLine());





        } else {

            //addPeoples();
            confirmShift();
        }


        clear();
        menu();
    }

    public  void updateShift(){}

    public  void deleteShift(){}

    public  void searchShifts() {


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

    private static void loadList() {

        shiftsList.add(new Shift(1, 10, new Person("Jack", "Spar", 15)));
    }

    public static List<Shift> shiftsList = new ArrayList<>();




    }
