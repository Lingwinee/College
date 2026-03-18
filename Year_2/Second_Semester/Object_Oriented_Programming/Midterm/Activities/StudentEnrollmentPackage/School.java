package StudentEnrollmentPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class School {

    private final String name;
    private final List<DegreeProgram> degreePrograms;

    public School(String name) {
        this.name = name;
        this.degreePrograms = new ArrayList<DegreeProgram>();
    }

    public String getName() {
        return name;
    }

    public void addDegreeProgram(DegreeProgram degreeProgram) {
        if (degreeProgram != null && !degreePrograms.contains(degreeProgram)) {
            degreePrograms.add(degreeProgram);
        }
    }

    public List<DegreeProgram> getDegreePrograms() {
        return Collections.unmodifiableList(degreePrograms);
    }

    @Override
    public String toString() {
        return name;
    }
}
