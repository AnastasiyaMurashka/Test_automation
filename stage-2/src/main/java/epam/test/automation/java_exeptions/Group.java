package epam.test.automation.java_exeptions;

import java.util.Set;

public class Group {
    private String nameOfGroup;
    private Set<Student> listOfStudents;

    public Group(String nameOfGroup, Set<Student> listOfStudents) {
        this.nameOfGroup = nameOfGroup;
        this.listOfStudents = listOfStudents;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public Set<Student> getListOfStudents() {
        if (listOfStudents.isEmpty()) throw new NullPointerException(this + "doesn't have any students");
        return listOfStudents;
    }

    public void setListOfStudents(Set<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (nameOfGroup != null ? !nameOfGroup.equals(group.nameOfGroup) : group.nameOfGroup != null) return false;
        return listOfStudents != null ? listOfStudents.equals(group.listOfStudents) : group.listOfStudents == null;
    }

    @Override
    public int hashCode() {
        int result = nameOfGroup != null ? nameOfGroup.hashCode() : 0;
        result = 31 * result + (listOfStudents != null ? listOfStudents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "nameOfGroup='" + nameOfGroup + '\'' +
                ", listOfStudents=" + listOfStudents +
                '}';
    }

    public void addMark(long id, Subject subject, Integer mark) {
        if (mark > 10 || mark < 0) {
            throw new IllegalArgumentException("Marks should be 0-10");
        } else {
            for (Student s : listOfStudents) {
                if (s.getId() == id) {
                    s.getMarks().get(subject).add(mark);
                }
            }
        }
    }

    public double getGPA(long id) {
        int sum = 0;
        int numberOfMarks = 0;
        for (Student s : listOfStudents) {
            if (s.getId() == id) {
                for (Subject sub : s.getSubjects()) {
                    for (Integer i : s.getMarks().get(sub)) {
                        sum += i;
                        if (i != null) numberOfMarks++;
                    }
                }
            }
        }
        return (double) sum / numberOfMarks;
    }
}
