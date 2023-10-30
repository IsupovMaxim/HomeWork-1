package HomeWork2;
// Объявить целочисленную переменную, в которой количество пехотинцев у Ланнистеров.

// Объявить целочисленную переменную, в которой количество орков в войске Сарумана.

// Объявить целочисленную переменную, в которой общее количество пехоты в
// союзе Ланнистеров и Сармана.
public class SarumanLannisters {
         static final int soldiers = 3000;
         static final  int orcs = 2000;
    public static void main(String[] args) {
        int union = soldiers + orcs;

        System.out.println("Количество пехотинцев у Ланнистеров - " + soldiers);
        System.out.println("Количество орков в войске Сарумана - " + orcs);
        System.out.println("Общее количество пехоты в союзе Ланнистеров и Сарумана - " + union);
    }
}
