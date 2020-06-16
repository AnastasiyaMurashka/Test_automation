package epam.test.automation.java_exeptions;

import java.util.List;

public class University {
    private String name;
    private String rector;
    private List<Faculty> facultyList;

    public University(String name, String rector, List<Faculty> facultyList) {
        this.name = name;
        this.rector = rector;
        this.facultyList = facultyList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRector() {
        return rector;
    }

    public void setRector(String rector) {
        this.rector = rector;
    }

    public List<Faculty> getFacultyList() {
        if (facultyList.isEmpty()) throw new NullPointerException("University doesn't have any faculties");
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        University that = (University) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (rector != null ? !rector.equals(that.rector) : that.rector != null) return false;
        return facultyList != null ? facultyList.equals(that.facultyList) : that.facultyList == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (rector != null ? rector.hashCode() : 0);
        result = 31 * result + (facultyList != null ? facultyList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", rector='" + rector + '\'' +
                ", facultyList=" + facultyList +
                '}';
    }

    public double getGPA(Subject subject, Faculty faculty) {
        int sumMarks = 0;
        int numberOfMarks = 0;
        for (Faculty f : facultyList) {
            if (f.equals(faculty)) {
                for (Group g : f.getListOfGroups()) {
                    for (Student s : g.getListOfStudents()) {
                        for (Integer i : s.getMarks().get(subject)) {
                            sumMarks += i;
                            numberOfMarks++;
                        }
                    }
                }
            }
        }
        return (double) sumMarks / numberOfMarks;
    }

    public double getGPA(Subject subject) {
        int sumMarks = 0;
        int numberOfMarks = 0;
        for (Faculty f : facultyList) {
            for (Group g : f.getListOfGroups()) {
                for (Student s : g.getListOfStudents()) {
                    for (Integer i : s.getMarks().get(subject)) {
                        sumMarks += i;
                        numberOfMarks++;
                    }
                }
            }
        }
        return (double) sumMarks / numberOfMarks;
    }
}
