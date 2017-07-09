package springboot.model;

import springboot.ParserXLS.ExcelParser;

import java.util.ArrayList;

public class Hour {

    private final int hour;
    private final ArrayList<TimeData> td = new ArrayList<>();

    public Hour(int hour, String course) {
        final String[] allDayName = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        this.hour = hour;
        ArrayList<int[]> time = new ArrayList<>();

        // паринг дня i из документа и получение данных
        for (int i = 0; i < allDayName.length; i++) {

            ExcelParser.parseDay(i);

            //выбор расписания из направления движения
            if (course.equals("fromMetro")) {
                time = ExcelParser.getMetro_BC();
            } else {
                time = ExcelParser.getBC_Metro();
            }

            // проход по всему расписанию дня и выборка нужного часа
            for (int j = 0; j < time.size(); j++) {
                if (time.get(j)[0] == hour) {
                    td.add(new TimeData(time.get(j)[1], allDayName[i]));
                }
            }
        }
    }


    public int getHour() {
        return hour;
    }

    public ArrayList<TimeData> getTd() {
        return td;
    }
}
