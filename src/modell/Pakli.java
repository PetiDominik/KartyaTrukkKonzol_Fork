
package modell;

public class Pakli {
    
    private Lap[] lapok = new Lap[22];
    
    public Pakli() {
        this.feltolt();
    }
    
    public void feltolt() {
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
        int i = 1;
        for (String szin : szinek) {
            for (int e = 0; e < ertekek.length && i < this.lapok.length; e++) {
                this.lapok[i++] = new Lap(szin + "_" + ertekek[e]);
            }
        }
    }
    
    public String kirak() {
        String txt = "";
        for (int i = 1; i < this.lapok.length; i++) {
            txt += "%-8s".formatted(this.lapok[i].getLeiras());
            if (i % 3 == 0) {
                txt += "\n";
            }
        }
        
        return txt;
    }
    
    public void kever(int oszlop) {
        // mindig középre a választott
        Lap[] ujPakli = new Lap[22];
        switch (oszlop) {
            case 1:
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = this.lapok[20 - (i - 1) * 3];
                    ujPakli[i + 7] = this.lapok[19 - (i - 1) * 3];
                    ujPakli[i + 14] = this.lapok[21 - (i - 1) * 3];
                }
                break;
            case 2:
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = this.lapok[19 - (i - 1) * 3];
                    ujPakli[i + 7] = this.lapok[20 - (i - 1) * 3];
                    ujPakli[i + 14] = this.lapok[21 - (i - 1) * 3];
                }
                break;
            case 3:
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = this.lapok[19 - (i - 1) * 3];
                    ujPakli[i + 7] = this.lapok[21 - (i - 1) * 3];
                    ujPakli[i + 14] = this.lapok[20 - (i - 1) * 3];
                }
                break;
        }
        this.lapok = ujPakli;
    }
    
    public Lap ezVolt() {
        return this.lapok[11];
    }
}
