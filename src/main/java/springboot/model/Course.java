package springboot.model;

public class Course {
    private final String course;
    private final Hour[] hours = new Hour[24];

    public Course(String course) {
        this.course = course;

        for (int i = 0; i < hours.length; i++) {
            hours[i] = new Hour(i,course);
        }

    }


    public String getCourse() {
        return course;
    }

    public Hour[] getHours() {
        return hours;
    }
}
