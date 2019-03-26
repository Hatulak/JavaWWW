package utils;

import java.util.Calendar;

public class FunkcjeFormatujaceDate {

    public static String formatujZliczb(int dzien, int miesiac, int rok) {
        String[] miesiace = new String[]{"styczeń", "luty", "marzec",
                "kwiecień", "maj", "czerwiec", "lipiec", "sierpień",
                "wrzesień", "październik", "listopad", "grudzień"};
        switch (miesiac) {
            case 1:
                return dzien + "-" + miesiace[0] + "-" + rok;
            case 2:
                return dzien + "-" + miesiace[1] + "-" + rok;
            case 3:
                return dzien + "-" + miesiace[2] + "-" + rok;
            case 4:
                return dzien + "-" + miesiace[3] + "-" + rok;
            case 5:
                return dzien + "-" + miesiace[4] + "-" + rok;
            case 6:
                return dzien + "-" + miesiace[5] + "-" + rok;
            case 7:
                return dzien + "-" + miesiace[6] + "-" + rok;
            case 8:
                return dzien + "-" + miesiace[7] + "-" + rok;
            case 9:
                return dzien + "-" + miesiace[8] + "-" + rok;
            case 10:
                return dzien + "-" + miesiace[9] + "-" + rok;
            case 11:
                return dzien + "-" + miesiace[10] + "-" + rok;
            case 12:
                return dzien + "-" + miesiace[11] + "-" + rok;
            default:
                return "Month number is wrong";
        }
    }

    public static String formatujZNapisow(String dzien, String miesiac, String rok) {
        return dzien + "-" + miesiac + "-" + rok;
    }

    public static String dzisiejszaData() {
        return Calendar.getInstance().getTime().toString();
    }


}
