package StudentEnrollmentPackage;

public class Course {

    private final String code;
    private final String title;
    private final int units;
    private final DegreeProgram degreeProgram;

    public Course(String code, String title, int units, DegreeProgram degreeProgram) {
        this.code = code;
        this.title = title;
        this.units = units;
        this.degreeProgram = degreeProgram;

        if (degreeProgram != null) {
            degreeProgram.addCourse(this);
        }
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getUnits() {
        return units;
    }

    public DegreeProgram getDegreeProgram() {
        return degreeProgram;
    }

    @Override
    public String toString() {
        return code + " - " + title + " (" + units + " units)";
    }
}
