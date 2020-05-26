package Java_Collection.Optional_task;


import  java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.List;

public class OptionalTask{
    public static void main(String[] args) throws IOException {
        //1.Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
        try {
            ArrayList<String> textFromFile = new ArrayList<String>();
            BufferedReader br = new BufferedReader(new FileReader("D://text.txt"));
            try{
                String s;
                while ((s = br.readLine()) != null) {

                    textFromFile.add(s);
                }
                System.out.println(textFromFile);

            } finally {
                br.close();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter("D://text.txt"));
            try {
                for (int i = textFromFile.size() - 1; i >= 0; i--) {
                    bw.write(textFromFile.get(i));
                    bw.newLine();
                }
            }
            finally {
                bw.close();
            }
        }
        catch (IOException exc){
            System.out.println(exc.getMessage());
        }
        //2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
        String number;
        Stack<Character> integerStack = new Stack<Character>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number=br.readLine();

        for(int i=0; i<number.length();i++){
            integerStack.push(number.charAt(i));
        }
        System.out.println(integerStack);
        while (!integerStack.isEmpty()){
            System.out.print(integerStack.pop());
        }
        //3. Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
        ArrayList<String> poem = new ArrayList<>();
        poem.add("Always stays the same");
        poem.add("Nothing ever changes");
        poem.add("English summer rain");
        poem.add("Seems to last for ages");
        poem.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        System.out.println(poem);
//
        //4. Создать список из элементов каталога и его подкаталогов.
        List<File> fileList = new ArrayList<File>();
        File file = new File("D://Directory1");
        if (file.isDirectory()) {
            for (File i : file.listFiles()
            ) {
                fileList.add(i);
            }
        }
    }
}