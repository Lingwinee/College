package StudentEnrollmentPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DegreeProgram {

    private final String code;
    private final String name;
    private final School school;
    private final List<Course> courses;

    public DegreeProgram(String code, String name, School school) {
        this.code = code;
        this.name = name;
        this.school = school;
        this.courses = new ArrayList<Course>();

        if (school != null) {
            school.addDegreeProgram(this);
        }
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public School getSchool() {
        return school;
    }

    public void addCourse(Course course) {
        if (course != null && !courses.contains(course)) {
            courses.add(course);
        }
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}
