import java.util.ArrayList;
import java.util.List;

import Controller.SIAController;
import Model.*;
import java.util.Date;


public class App {
    public static void main(String[] args) {
        MahasiswaSarjana mahasiswaSarjana1 = new MahasiswaSarjana("Machp", "Jl. Merdeka No. 10", new Date(), "081237266789", "1123070", "Teknik Informatika");
        MahasiswaSarjana mahasiswaSarjana2 = new MahasiswaSarjana("Andi", "Jl. Raya No. 5", new Date(), "08923654321", "3123034", "Sistem Informasi");
        SIAController.users.add(mahasiswaSarjana1);
        SIAController.users.add(mahasiswaSarjana2);
        
      
        SIAController controller = new SIAController();
        controller.run();
    }
}
