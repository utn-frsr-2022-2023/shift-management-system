package system.services;

import system.models.Shift;

import java.util.ArrayList;
import java.util.List;

public class ShiftService {

    public List<Shift> getShifts() {

        return  shifts2;
    }

    public void setShifts( List<Shift> shiftList) {

        shifts2 = shiftList;
    }

    public String getVar() {

        return myVar;
    }

    public static List<Shift> shifts2 = new ArrayList<>();

    private final String myVar = "Hello World!";
}
