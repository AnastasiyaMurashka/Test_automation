package epam.test.automation.java_exceptions;

import epam.test.automation.java_exceptions.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Subject math = new Subject("Math", "A.V.Voronov");
        Subject physic = new Subject("Physic", "A.A.Savchenko");
        Subject drawing = new Subject("Drawing", "D.Y.Mironov");
        Subject philosophy = new Subject("Philosophy", "B.B.Dronovich");
        Subject history = new Subject("History", "S.V.Zmeina");
        Subject theoreticalMechanics = new Subject("Teoretical mechanics", "E.G.Horovodov");
        Subject worldEconomy = new Subject("World economy", "T.K. Kytc");
        Subject statistic = new Subject("Statistic", "O.F. Raskazov");
        Subject civilEngineering = new Subject("Civil ingineering", "R.A.Prosol");
        Subject architecture = new Subject("Architecture", "E.B.Avroshkina");
        Subject microeconomics = new Subject("Microconomics", "E.G.Gromiko");
        Subject macroeconomics = new Subject("Macroeconomics", "E.G.Gromiko");
        List<Student> studentsForGroupPs11 = Arrays.asList(new Student(12345, "Egor", "Ivanov",
                        new ArrayList<Subject>(Arrays.asList(math, history, physic, drawing))),
                new Student(12346, "Andrei", "Korotchenko",
                        new ArrayList<Subject>(Arrays.asList(math, history, physic, drawing))),
                new Student(12340, "Alesy", "Bygaeva",
                        new ArrayList<Subject>(Arrays.asList(math, history, physic, drawing))),
                new Student(12341, "Gled", "Boreiko",
                        new ArrayList<Subject>(Arrays.asList(math, history, physic, drawing))));
        List<Student> studentsForGroupPs21 = Arrays.asList(new Student(12347, "Denis", "Golubev",
                        new ArrayList<Subject>(Arrays.asList(theoreticalMechanics, math, architecture, civilEngineering))),
                new Student(12348, "Anna", "Solomikina",
                        new ArrayList<Subject>(Arrays.asList(theoreticalMechanics, math, architecture, civilEngineering))),
                new Student(12349, "Kirill", "Beliy",
                        new ArrayList<Subject>(Arrays.asList(theoreticalMechanics, math, architecture, civilEngineering))),
                new Student(12350, "Svetlana", "Uranova",
                        new ArrayList<Subject>(Arrays.asList(theoreticalMechanics, math, architecture, civilEngineering))));
        List<Student> studentsForGroupGT12 = Arrays.asList(new Student(12355, "Elena", "Radchenko",
                        new ArrayList<Subject>(Arrays.asList(worldEconomy, history, philosophy, math))),
                new Student(12356, "Maria", "Tkachenko",
                        new ArrayList<Subject>(Arrays.asList(worldEconomy, history, philosophy, math))),
                new Student(12357, "Valiria", "Zyevich",
                        new ArrayList<Subject>(Arrays.asList(worldEconomy, history, philosophy, math))),
                new Student(12358, "Alexandra", "Verenchikova",
                        new ArrayList<Subject>(Arrays.asList(worldEconomy, history, philosophy, math))));
        List<Student> studentsForGroupGT22 = Arrays.asList(new Student(12359, "Antonina", "Egozova",
                        new ArrayList<Subject>(Arrays.asList(macroeconomics, microeconomics, math, worldEconomy, statistic))),
                new Student(12360, "Inna", "Ivanova",
                        new ArrayList<Subject>(Arrays.asList(macroeconomics, microeconomics, math, worldEconomy, statistic))),
                new Student(12361, "Galina", "Saltinova",
                        new ArrayList<Subject>(Arrays.asList(macroeconomics, microeconomics, math, worldEconomy, statistic))),
                new Student(12362, "Anna", "Filipchenko",
                        new ArrayList<Subject>(Arrays.asList(macroeconomics, microeconomics, math, worldEconomy, statistic))));
        Group ps11 = new Group("PS-11", new TreeSet<Student>(studentsForGroupPs11));
        Group ps21 = new Group("PS-21", new TreeSet<>(studentsForGroupPs21));
        Group gt12 = new Group("GT-12", new TreeSet<Student>(studentsForGroupGT12));
        Group gt22 = new Group("GT-22", new TreeSet<Student>(studentsForGroupGT22));
        Faculty pgs = new Faculty("PGS", new ArrayList<Group>(Arrays.asList(ps11, ps21)));
        Faculty economics = new Faculty("Economics", new ArrayList<Group>(Arrays.asList(gt12, gt22)));
        University university = new University("University of industry", "O.P.Ermoshin",
                new ArrayList<Faculty>(Arrays.asList(pgs, economics)));

        try {
            ps11.addMark(12340, math, 6);
            ps11.addMark(12340, math, 7);
            ps11.addMark(12340, history, 5);
            ps21.addMark(12349, math, 6);
            ps21.addMark(12349, math, 5);
            gt12.addMark(12356, math, 8);
            gt22.addMark(12361, math, 5);
            gt22.addMark(12362, math, 9);
        } catch (MarkIsIncorrectException | StudentDoesNotHaveSubjectsException e) {
            System.out.println(e.getMessage());
        }

        try {
            ps11.getGPA(12340);
        } catch (StudentDoesNotHaveSubjectsException e) {
            System.out.println(e.getMessage());
        }

        try {
            university.getGPA(math, pgs);
            university.getGPA(math);
        } catch (UniversityDoesNotHaveFacultyException | FacultyDoesNotHaveGroupsException |
                GroupDoesNotHaveStudentsException | StudentDoesNotHaveSubjectsException e) {
            System.out.println(e.getMessage());
        }
    }
}
