package system;

import system.services.Dao;
import system.services.FrontService;


public class Main {

    /*------------------------------------------------------------MAIN------------------------------------------------------------*/

    public static void main(String[] args) {

        dao.getData(); // Carga los datos.

        frontService.menu(); // Muestra el menu.

    }

    private static final FrontService frontService = new FrontService();
    private static final Dao dao = new Dao();

}
