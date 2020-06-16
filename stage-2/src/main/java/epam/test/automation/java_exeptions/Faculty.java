package epam.test.automation.java_exeptions;

import java.util.List;

public class Faculty {
    private String nameFaculty;
    private List<Group> listOfGroups;

    public Faculty(String nameFaculty, List<Group> listOfGroups) {
        this.nameFaculty = nameFaculty;
        this.listOfGroups = listOfGroups;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public List<Group> getListOfGroups() {
        if (listOfGroups.isEmpty()) throw new NullPointerException(this + " " + "doesn't have any groups");
        return listOfGroups;
    }

    public void setListOfGroups(List<Group> listOfGroups) {
        this.listOfGroups = listOfGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faculty faculty = (Faculty) o;

        if (nameFaculty != null ? !nameFaculty.equals(faculty.nameFaculty) : faculty.nameFaculty != null) return false;
        return listOfGroups != null ? listOfGroups.equals(faculty.listOfGroups) : faculty.listOfGroups == null;
    }

    @Override
    public int hashCode() {
        int result = nameFaculty != null ? nameFaculty.hashCode() : 0;
        result = 31 * result + (listOfGroups != null ? listOfGroups.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "nameFaculty='" + nameFaculty + '\'' +
                ", listOfGroups=" + listOfGroups +
                '}';
    }
}
