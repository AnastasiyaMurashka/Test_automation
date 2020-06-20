package epam.test.automation.java_io.main_task;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MethodClass {
    private MethodClass() {
    }

    public static void createFiles(String path) {
        File newTreeFile = new File("data" + File.separator + "treeFile.txt");
        File mainFile = new File(path);
        try (FileWriter fw = new FileWriter(newTreeFile, false)) {
            if (mainFile.isDirectory()) {
                fw.write(mainFile.getName());
                fw.write('\n');
                int numberOfFiles = 0;
                List<File> fileList = Arrays.asList(mainFile.listFiles());
                for (File file : fileList) {
                    if (file.isDirectory()) {
                        fw.write("|-----" + file.getName() + ":");
                        fw.write('\n');
                        List<File> listOfFiles = Arrays.asList(file.listFiles());
                        for (File f : listOfFiles) {
                            fw.write("- " + ++numberOfFiles + ". " + f.getName());
                            fw.write('\n');
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
        try (FileReader fr = new FileReader(treeFile)) {
            Scanner scanner = new Scanner(fr);
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