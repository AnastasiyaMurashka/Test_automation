package epam.test.automation.java_exceptions;

import epam.test.automation.java_exceptions.exceptions.FacultyDoesNotHaveGroupsException;
import epam.test.automation.java_exceptions.exceptions.GroupDoesNotHaveStudentsException;
import epam.test.automation.java_exceptions.exceptions.StudentDoesNotHaveSubjectsException;
import epam.test.automation.java_exceptions.exceptions.UniversityDoesNotHaveFacultyException;

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

    public List<Faculty> getFacultyList() throws UniversityDoesNotHaveFacultyException {
        if (facultyList.isEmpty())
            throw new UniversityDoesNotHaveFacultyException();
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

    public double getGPA(Subject subject, Faculty faculty) throws GroupDoesNotHaveStudentsException, FacultyDoesNotHaveGroupsException,
            UniversityDoesNotHaveFacultyException, StudentDoesNotHaveSubjectsException {
        int sumMarks = 0;
        int numberOfMarks = 0;
        if (facultyList.isEmpty())
            throw new UniversityDoesNotHaveFacultyException();
        for (Faculty f : facultyList) {
            if (f.equals(faculty)) {
                if (f.getListOfGroups().isEmpty())
                    throw new FacultyDoesNotHaveGroupsException(this + " " + "doesn't have any groups");
                for (Group g : f.getListOfGroups()) {
                    if (g.getListOfStudents().isEmpty())
                        throw new GroupDoesNotHaveStudentsException(this + "doesn't have any students");
                    for (Student s : g.getListOfStudents()) {
                        if (s.getSubjects().isEmpty())
                            throw new StudentDoesNotHaveSubjectsException(this + "doesn't have any subjects");
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

    public double getGPA(Subject subject) throws GroupDoesNotHaveStudentsException, FacultyDoesNotHaveGroupsException,
            UniversityDoesNotHaveFacultyException, StudentDoesNotHaveSubjectsException {
        int sumMarks = 0;
        int numberOfMarks = 0;
        if (facultyList.isEmpty()) throw new UniversityDoesNotHaveFacultyException();
        for (Faculty f : facultyList) {
            if (f.getListOfGroups().isEmpty())
                throw new FacultyDoesNotHaveGroupsException(this + " " + "doesn't have any groups");
            for (Group g : f.getListOfGroups()) {
                if (g.getListOfStudents().isEmpty())
                    throw new GroupDoesNotHaveStudentsException(this + "doesn't have any students");
                for (Student s : g.getListOfStudents()) {
                    if (s.getSubjects().isEmpty())
                        throw new StudentDoesNotHaveSubjectsException(this + "doesn't have any subjects");
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
