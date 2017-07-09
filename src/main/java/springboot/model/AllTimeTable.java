package springboot.model;


public class AllTimeTable {
    private final Course[] timeTable = new Course[2];
    private static AllTimeTable instance;

    // приватный класс для создания единственного объекта через getInstance
    private AllTimeTable() {
        timeTable[0] = new Course("fromMetro");
        timeTable[1] = new Course("fromTechnopolis");
    }

    public static AllTimeTable getInstance() {
        if (instance == null) {
            instance = new AllTimeTable();
        }
        return instance;
    }

    public Course[] getTimeTable() {
        return timeTable;
    }
}
