package epam.test.automation.java_exeptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements Comparable<Student> {
    private long id;
    private String name;
    private String surname;
    private Map<Subject, ArrayList<Integer>> marks;
    private List<Subject> subjects;

    public Student(long id, String name, String surname, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.marks = new HashMap<>();
        this.subjects = subjects;
        for (Subject s : subjects) {
            marks.put(s, new ArrayList<Integer>());
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Map<Subject, ArrayList<Integer>> getMarks() {
        return marks;
    }

    public void setMarks(Map<Subject, ArrayList<Integer>> marks) {
        this.marks = marks;
    }

    public List<Subject> getSubjects() {
        if (subjects.isEmpty()) throw new NullPointerException(this + "doesn't have any subjects");
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
        if (marks != null ? !marks.equals(student.marks) : student.marks != null) return false;
        return subjects != null ? subjects.equals(student.subjects) : student.subjects == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (marks != null ? marks.hashCode() : 0);
        result = 31 * result + (subjects != null ? subjects.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", marks=" + marks +
                ", subjects=" + subjects +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return surname.compareTo(o.getSurname());
    }
}
