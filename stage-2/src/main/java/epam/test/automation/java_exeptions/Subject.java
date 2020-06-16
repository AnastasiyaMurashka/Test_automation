package epam.test.automation.java_exeptions;

public class Subject {
    private String nameOfSubject;
    private String teacher;

    public Subject(String nameOfSubject, String teacher) {
        this.nameOfSubject = nameOfSubject;
        this.teacher = teacher;
    }

    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (nameOfSubject != null ? !nameOfSubject.equals(subject.nameOfSubject) : subject.nameOfSubject != null)
            return false;
        return teacher != null ? teacher.equals(subject.teacher) : subject.teacher == null;
    }

    @Override
    public int hashCode() {
        int result = nameOfSubject != null ? nameOfSubject.hashCode() : 0;
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "nameOfSubject='" + nameOfSubject + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
