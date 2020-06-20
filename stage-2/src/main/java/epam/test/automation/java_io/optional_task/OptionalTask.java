package epam.test.automation.java_io.optional_task;

import java.io.*;
import java.util.*;

public class OptionalTask {
    public static void main(String[] args) {
        //1. Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
        Random random = new Random();
        ArrayList<String> list = new ArrayList<>();
        File numbers = new File("data" + File.separator + "optional_1.txt");
        try (FileWriter fw = new FileWriter(numbers, false);) {
            for (int i = 0; i < 20; i++) {
                String line = String.valueOf(random.nextInt(100));
                fw.write(line);
                fw.write('\n');
            }
        } catch (IOException e) {
            e.getMessage();
        }
        try (FileReader fr = new FileReader(numbers)) {
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                list.add(scan.nextLine());
            }
            list.sort(Comparator.comparing(Integer::valueOf));
        } catch (IOException e) {
            e.getMessage();
        }
        try (FileWriter fwSort = new FileWriter(numbers)) {
            for (int i = 0; i < list.size(); i++) {
                fwSort.write(list.get(i));
                fwSort.write('\n');
            }
        } catch (IOException e) {
            e.getMessage();
        }

        // 2.Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.
        File fileJava = new File("D:\\Test_automation\\stage-2\\src\\main\\java\\epam\\test\\automation\\java_io\\optional_task", "CheckClass.java");
        ArrayList<String> listJava = new ArrayList<>();
        try (FileReader fr = new FileReader(fileJava)) {
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                listJava.add(scan.nextLine());
            }
        } catch (IOException e) {
            e.getMessage();
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileJava))) {
            for (String s : listJava) {
                br.write(s.replace("public", "private"));
                br.write('\n');
            }
        } catch (IOException e) {
            e.getMessage();
        }

        //3.Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.
        File fileReverse = new File("data" + File.separator + "reverse.txt");
        ArrayList<String> listReverse = new ArrayList<>();
        String line;
        try (FileReader fr = new FileReader(fileJava)) {
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                StringBuilder stringBuffer = new StringBuilder(line);
                listReverse.add(String.valueOf(stringBuffer.reverse()));
            }
        } catch (IOException e) {
            e.getMessage();
        }
        try (FileWriter fw = new FileWriter(fileReverse)) {
            for (int i = 0; i < listReverse.size(); i++) {
                fw.write(listReverse.get(i));
                fw.write('\n');
            }
        } catch (IOException e) {
            e.getMessage();
        }

        //4.  Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.
        try (FileReader fr = new FileReader(fileJava)) {
            ArrayList<String> stringToUpperCase = new ArrayList<>();
            Scanner scanner = new Scanner(fr);
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