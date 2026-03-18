package StudentEnrollmentPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {

    public static final int MAX_UNITS = 24;

    private final String studentNumber;
    private final String fullName;
    private final DegreeProgram degreeProgram;
    private final List<Course> enrolledCourses;

    public Student(String studentNumber, String fullName, DegreeProgram degreeProgram) {
        this.studentNumber = studentNumber;
        this.fullName = fullName;
        this.degreeProgram = degreeProgram;
        this.enrolledCourses = new ArrayList<Course>();
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public DegreeProgram getDegreeProgram() {
        return degreeProgram;
    }

    public List<Course> getEnrolledCourses() {
        return Collections.unmodifiableList(enrolledCourses);
    }

    public int getTotalUnits() {
        int totalUnits = 0;
        for (Course course : enrolledCourses) {
            totalUnits += course.getUnits();
        }
        return totalUnits;
    }

    public boolean enrollCourse(Course course) {
        if (course == null || degreeProgram == null) {
            return false;
        }
        if (!degreeProgram.equals(course.getDegreeProgram())) {
            return false;
        }
        if (enrolledCourses.contains(course)) {
            return false;
        }
        if (getTotalUnits() + course.getUnits() > MAX_UNITS) {
            return false;
        }

        enrolledCourses.add(course);
        return true;
    }

    public boolean dropCourse(Course course) {
        return enrolledCourses.remove(course);
    }
}
