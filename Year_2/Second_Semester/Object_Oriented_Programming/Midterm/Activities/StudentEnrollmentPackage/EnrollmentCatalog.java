package StudentEnrollmentPackage;

import java.util.ArrayList;
import java.util.List;

public final class EnrollmentCatalog {

    private EnrollmentCatalog() {
    }

    public static List<School> createSchools() {
        List<School> schools = new ArrayList<School>();

        School scs = new School("School of Computer Studies");
        School sbm = new School("School of Business and Management");
        School soe = new School("School of Engineering");
        School sea = new School("School of Education and Arts");

        DegreeProgram bsit = new DegreeProgram("BSIT", "BS Information Technology", scs);
        DegreeProgram bscs = new DegreeProgram("BSCS", "BS Computer Science", scs);
        DegreeProgram bsinf = new DegreeProgram("BSIS", "BS Information Systems", scs);

        DegreeProgram bsa = new DegreeProgram("BSA", "BS Accountancy", sbm);
        DegreeProgram bshrm = new DegreeProgram("BSHRM", "BS Hospitality Management", sbm);
        DegreeProgram bsba = new DegreeProgram("BSBA", "BS Business Administration", sbm);
        DegreeProgram bsent = new DegreeProgram("BSENT", "BS Entrepreneurship", sbm);

        DegreeProgram bsee = new DegreeProgram("BSEE", "BS Electrical Engineering", soe);
        DegreeProgram bsce = new DegreeProgram("BSCE", "BS Civil Engineering", soe);
        DegreeProgram bsme = new DegreeProgram("BSME", "BS Mechanical Engineering", soe);

        DegreeProgram bsed = new DegreeProgram("BSED", "BS Secondary Education", sea);
        DegreeProgram beed = new DegreeProgram("BEED", "Bachelor of Elementary Education", sea);

        addItCourses(bsit);
        addCsCourses(bscs);
        addIsCourses(bsinf);

        addAccountancyCourses(bsa);
        addHospitalityCourses(bshrm);
        addBusinessAdminCourses(bsba);
        addEntrepreneurshipCourses(bsent);

        addElectricalCourses(bsee);
        addCivilCourses(bsce);
        addMechanicalCourses(bsme);

        addSecondaryEducationCourses(bsed);
        addElementaryEducationCourses(beed);

        schools.add(scs);
        schools.add(sbm);
        schools.add(soe);
        schools.add(sea);

        return schools;
    }

    private static void addItCourses(DegreeProgram program) {
        new Course("PROG1", "Programming 1", 3, program);
        new Course("PROG2", "Programming 2", 3, program);
        new Course("NET1", "Fundamentals of Networking", 3, program);
        new Course("IMDB", "Information Management", 3, program);
        new Course("WEBDEV", "Web Development", 3, program);
        new Course("SYSANA", "Systems Analysis and Design", 3, program);
    }

    private static void addCsCourses(DegreeProgram program) {
        new Course("PROG1", "Programming 1", 3, program);
        new Course("DSA", "Data Structures and Algorithms", 3, program);
        new Course("ALGO", "Design and Analysis of Algorithms", 3, program);
        new Course("AUTO", "Automata Theory", 3, program);
        new Course("OS", "Operating Systems", 3, program);
        new Course("AI", "Introduction to Artificial Intelligence", 3, program);
    }

    private static void addIsCourses(DegreeProgram program) {
        new Course("ISFUND", "Information Systems Fundamentals", 3, program);
        new Course("ERPM", "Enterprise Resource Planning", 3, program);
        new Course("ITPM", "IT Project Management", 3, program);
        new Course("BISAN", "Business Process Analysis", 3, program);
        new Course("DBM", "Database Management", 3, program);
        new Course("EBCOM", "E-Business and E-Commerce", 3, program);
    }

    private static void addAccountancyCourses(DegreeProgram program) {
        new Course("ACT1", "Financial Accounting 1", 3, program);
        new Course("ACT2", "Financial Accounting 2", 3, program);
        new Course("COST", "Cost Accounting", 3, program);
        new Course("AUDIT", "Auditing Theory", 3, program);
        new Course("TAXN", "Income Taxation", 3, program);
        new Course("BAWL", "Business Law and Regulations", 3, program);
    }

    private static void addHospitalityCourses(DegreeProgram program) {
        new Course("HM101", "Introduction to Hospitality", 3, program);
        new Course("FBSVC", "Food and Beverage Service", 3, program);
        new Course("FRTOF", "Front Office Operations", 3, program);
        new Course("HKMGT", "Housekeeping Management", 3, program);
        new Course("TOUROP", "Tour Operations", 3, program);
        new Course("CULART", "Culinary Arts Fundamentals", 3, program);
    }

    private static void addBusinessAdminCourses(DegreeProgram program) {
        new Course("MKTG", "Principles of Marketing", 3, program);
        new Course("FINM", "Financial Management", 3, program);
        new Course("HRM", "Human Resource Management", 3, program);
        new Course("OPMAN", "Operations Management", 3, program);
        new Course("STRAT", "Strategic Management", 3, program);
        new Course("BUSSTAT", "Business Statistics", 3, program);
    }

    private static void addEntrepreneurshipCourses(DegreeProgram program) {
        new Course("ENTREP1", "Entrepreneurial Mind", 3, program);
        new Course("IDEATE", "Business Ideation", 3, program);
        new Course("NEWV", "New Venture Creation", 3, program);
        new Course("SMEMGT", "SME Management", 3, program);
        new Course("BUSPLAN", "Business Plan Writing", 3, program);
        new Course("INNOV", "Innovation Management", 3, program);
    }

    private static void addElectricalCourses(DegreeProgram program) {
        new Course("CIRCUITS", "Basic Circuits", 3, program);
        new Course("ELECTRO", "Electronics", 3, program);
        new Course("CALC", "Engineering Calculus", 4, program);
        new Course("ELECMACH", "Electrical Machines", 3, program);
        new Course("CTRL", "Control Systems", 3, program);
        new Course("POWER", "Power Systems", 3, program);
    }

    private static void addCivilCourses(DegreeProgram program) {
        new Course("SURVEY", "Surveying", 3, program);
        new Course("STRUCT", "Structural Theory", 3, program);
        new Course("HYDRO", "Hydraulics", 3, program);
        new Course("GEOTECH", "Geotechnical Engineering", 3, program);
        new Course("TRANS", "Transportation Engineering", 3, program);
        new Course("CONST", "Construction Management", 3, program);
    }

    private static void addMechanicalCourses(DegreeProgram program) {
        new Course("THERMO", "Thermodynamics", 3, program);
        new Course("MECHDES", "Machine Design", 3, program);
        new Course("HEATTR", "Heat Transfer", 3, program);
        new Course("FLUID", "Fluid Mechanics", 3, program);
        new Course("DYNAM", "Dynamics of Machinery", 3, program);
        new Course("MATENG", "Engineering Materials", 3, program);
    }

    private static void addSecondaryEducationCourses(DegreeProgram program) {
        new Course("PRINCED", "Principles of Teaching", 3, program);
        new Course("CURDEV", "Curriculum Development", 3, program);
        new Course("EDPSY", "Educational Psychology", 3, program);
        new Course("ASSESS", "Classroom Assessment", 3, program);
        new Course("INCL", "Inclusive Education", 3, program);
        new Course("PRAC1", "Practice Teaching 1", 3, program);
    }

    private static void addElementaryEducationCourses(DegreeProgram program) {
        new Course("CHILDDEV", "Child Development", 3, program);
        new Course("LIT1", "Early Literacy", 3, program);
        new Course("MATHED", "Math for Elementary Grades", 3, program);
        new Course("SCIINQ", "Science Inquiry Teaching", 3, program);
        new Course("ARTINT", "Arts Integration", 3, program);
        new Course("PRAC2", "Practice Teaching 2", 3, program);
    }
}
