package springboot.model;

public class TimeData {
    private final int minutes;
    private final String dayOfWeek;

    public TimeData(int minutes, String dayOfWeek) {
        this.minutes = minutes;
        this.dayOfWeek = dayOfWeek;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}
