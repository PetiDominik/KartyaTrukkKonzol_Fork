package nezet;

import modell.Pakli;
import java.util.Scanner;
import modell.Lap;

public class KartyaTrukk {

    private static final Scanner sc = new Scanner(System.in);
    private Pakli pakli;
    
    public KartyaTrukk() {
        this.pakli = new Pakli();
        this.indit();
    }
    
    public void indit() {
        
        for (int i = 0; i < 3; i++) {
            kiir(this.pakli.kirak());
            int oszlop = melyik();
            this.pakli.kever(oszlop);
        }
        kiir("A választott lap: " + this.pakli.ezVolt().getLeiras());
    }
            
    private int melyik() {
        boolean jo;
        int oszlop;
        do {
            System.out.print("melyik oszlop (1-3): ");
            oszlop = sc.nextInt();
            jo = oszlop >= 1 && oszlop <= 3;
        } while (!jo);
        return oszlop;
    }
    
    private void kiir(String szoveg) {
        System.out.println(szoveg);
    }
}
