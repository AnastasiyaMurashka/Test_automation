package epam.test.automation.java_io.main_task;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MethodClass {

    public static void createFiles(String path) {
        File newTreeFile = new File("data" + File.separator + "treeFile.txt");
        File mainFile = new File(path);
        try (FileWriter fileWriter = new FileWriter(newTreeFile, false)) {
            if (mainFile.isDirectory()) {
                fileWriter.write(mainFile.getName());
                fileWriter.write('\n');
                int numberOfFiles = 0;
                List<File> fileList = Arrays.asList(mainFile.listFiles());
                for (File file : fileList) {
                    if (file.isDirectory()) {
                        fileWriter.write("|-----" + file.getName() + ":");
                        fileWriter.write('\n');
                        List<File> listOfFiles = Arrays.asList(file.listFiles());
                        for (File f : listOfFiles) {
                            fileWriter.write("- " + ++numberOfFiles + ". " + f.getName());
                            fileWriter.write('\n');
                        }
                        numberOfFiles = 0;
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void getInformationFromFile(String filePath) {
        File treeFile = new File(filePath);
        String line;
        int numberOfDirectory = 0;
        int numberOfFiles = 0;
        int sumLengthOfFileNames = 0;
        try (FileReader fileReader = new FileReader(treeFile)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.startsWith("|")) {
                    numberOfDirectory++;
                }
                if (line.startsWith("-")) {
                    numberOfFiles++;
                    sumLengthOfFileNames += line.length() - (line.indexOf('.') + 2);
                }
            }
            System.out.println("Number of directories: " + numberOfDirectory);
            System.out.println("Number of files: " + numberOfFiles);
            System.out.println("Average number of file in directories: " + numberOfFiles / numberOfDirectory);
            System.out.println("Average length of file in directories: " + sumLengthOfFileNames / numberOfFiles);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}