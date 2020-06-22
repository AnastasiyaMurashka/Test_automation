package epam.test.automation.java_io.optional_task;

import java.io.*;
import java.util.*;

public class OptionalTaskMethods {
    File numbers = new File("data" + File.separator + "optional_1.txt");
    Random random = new Random();
    ArrayList<String> list = new ArrayList<>();

    public void createFileWithNumbers() {
        try (FileWriter fileWriter = new FileWriter(numbers, false);) {
            for (int i = 0; i < 20; i++) {
                String line = String.valueOf(random.nextInt(100));
                fileWriter.write(line);
                fileWriter.write('\n');
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void sortNumbersInTheFile() {
        try (
                FileReader fileReader = new FileReader(numbers)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            list.sort(Comparator.comparing(Integer::valueOf));
        } catch (
                IOException e) {
            e.getMessage();
        }
        try (
                FileWriter fileWriterSort = new FileWriter(numbers)) {
            for (int i = 0; i < list.size(); i++) {
                fileWriterSort.write(list.get(i));
                fileWriterSort.write('\n');
            }
        } catch (
                IOException e) {
            e.getMessage();
        }
    }

    public void replacePublicByPrivate(String path) {
        File fileJava = new File(path, "CheckClass.java");
        ArrayList<String> listJava = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileJava)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                listJava.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.getMessage();
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileJava))) {
            for (String s : listJava) {
                bufferedWriter.write(s.replace("public", "private"));
                bufferedWriter.write('\n');
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void reverseTextInTheJavaFile(String path) {
        File fileJava = new File(path, "CheckClass.java");
        File fileReverse = new File("data" + File.separator + "reverse.txt");
        ArrayList<String> listReverse = new ArrayList<>();
        String line;
        try (FileReader fileReader = new FileReader(fileJava)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                StringBuilder stringBuffer = new StringBuilder(line);
                listReverse.add(String.valueOf(stringBuffer.reverse()));
            }
        } catch (IOException e) {
            e.getMessage();
        }
        try (FileWriter fileWriter = new FileWriter(fileReverse)) {
            for (int i = 0; i < listReverse.size(); i++) {
                fileWriter.write(listReverse.get(i));
                fileWriter.write('\n');
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void replaceWordsByWordsToUpperCase(String path) {
        File fileJava = new File(path, "CheckClass.java");
        try (FileReader fileReader = new FileReader(fileJava)) {
            ArrayList<String> stringToUpperCase = new ArrayList<>();
            Scanner scanner = new Scanner(fileReader);
            String word;
            while (scanner.hasNextLine()) {
                word = scanner.nextLine();
                String[] words = word.split(" ");
                for (String s : words) {
                    if (s.length() > 2) {
                        stringToUpperCase.add(s.toUpperCase());
                    } else {
                        stringToUpperCase.add(s);
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
