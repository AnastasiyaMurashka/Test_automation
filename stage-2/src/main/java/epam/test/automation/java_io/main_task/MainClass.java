package epam.test.automation.java_io.main_task;

public class MainClass {
    public static void main(String[] args) {
        MethodClass.createFiles(args[0]);
        MethodClass.getInformationFromFile(args[0]);
    }
}
