package Java_Fundamental.Optional_task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

    public class OptionalTask {
        // метод для создания массива
        public String[] createArray() {
            Scanner input = new Scanner(System.in);
            System.out.println("Введите размер массива");
            int size=input.nextInt();
            String array[] = new String[size];
            for (int i = 0; i < size; i++) {
                System.out.println("Заполните массив числами");
                array[i] = input.next();
            }
            return array;
        }
        // метод для находжения самого короткого и самого длинного числа
        public void findLongShort(String array[]){
            int min = array[0].length();
            int max = array[0].length();
            String maxStr = array[0];
            String minStr = array[0];
            for (int i = 1; i < array.length; i++) {
                if (max < array[i].length()) {
                    max = array[i].length();
                    maxStr = array[i];
                }
                if (min > array[i].length()) {
                    min = array[i].length();
                    minStr = array[i];
                }
            }
            System.out.println("Минимальная длинна: " + min + " числа " + minStr);
            System.out.println("Максимальная длинна: " + max + " числа " + maxStr);
        }
        // метод для вывода чисел в порядке возрастания значений их длины.
        public void sort(String array[]) {

            String t;
            for (int i = 0; i < array.length; i++) {
                int min = i;
                for (int j = i; j < array.length; j++) {
                    if (array[min].length() > array[j].length())
                        min = j;
                }
                t = array[min];
                array[min] = array[i];
                array[i] = t;
            }
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        }
        // метод для вывода на консоль чисел, длина которых меньше средней длины по всем числам, а также их длину.
        public void lessThenAverage(String array[]){
            int average;
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i].length();
            }
            average = sum / array.length;
            for (int i = 0; i < array.length; i++) {
                if (array[i].length() < average) {
                    System.out.println("Длина числа меньше средней длины по всем числам " + array[i] + " равна "
                            + array[i].length());
                }
            }
        }
        // метод для находжения числа, в котором количество различных цифр минимально. Если таких чисел несколько,
        //  найти первое из них.
        public void findMinDifferentNum(String array[]) {
            int counter[] = new int[array.length];
            HashSet<Character> digits = new HashSet<Character>();
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length(); j++) {
                    digits.add(array[i].charAt(j));
                }
                counter[i] = digits.size();
                digits.clear();
            }
            int numElement = 0;
            for (int i = 1; i < counter.length; i++) {
                if (counter[i] < counter[numElement])
                    numElement = i;
            }
            System.out.println("Число в котором количество различных цифр минимально: " + array[numElement]);
        }
        // метод для находжения чисел, содержащих только четные цифры,
        // а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
        public void findEven(String array[]){
            int even=0;
            int odd=0;
            int onlyEven=0;
            int evenOdd=0;
            int numInt[]=new int[array.length];
            for(int i=0; i<array.length;i++){
                numInt[i]= Integer.parseInt(array[i]);
                ArrayList<Integer> intList=new ArrayList<>();
                while(numInt[i]!=0){
                    intList.add(numInt[i]%10);
                    numInt[i]/=10;
                }
                for(int j=0;j<intList.size();j++){
                    if(intList.get(j)%2==0) even++;
                    else odd++;
                }
                if(even==intList.size()) onlyEven++;
                if(even==odd) evenOdd++;
                even=0;
                odd=0;
            }
            System.out.println("Количество чисел с только четными цифрами: "+onlyEven);
            System.out.println("Количество чисел с равным числом четных и нечетных цифр: "+evenOdd);
        }
        // метод для нахождения числа, цифры в котором идут в строгом порядке возрастания.
        // Если таких чисел несколько, найти первое из них.
        public void findFigureSort(String array[]) {
            int count = 0;
            int numInt[] = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                numInt[i] = Integer.parseInt(array[i]);
                ArrayList<Integer> intList = new ArrayList<>();
                while (numInt[i] != 0) {
                    intList.add(numInt[i] % 10);
                    numInt[i] /= 10;
                }
                for (int j = intList.size() - 1; j > 0; j--) {
                    if (intList.get(j) < intList.get(j - 1)) count++;
                }
                if (count == intList.size() - 1) {
                    System.out.println("Число, цифры в котором идут в строгом порядке возрастания: " + array[i]);
                    break;
                }
                count = 0;
            }
        }
        // метод для нахождения числа, состоящее только из различных цифр. Если таких чисел несколько,
        // найти первое из них.
        public void findOnlyDifferent(String array[]){
            int count=0;
            int numInt[]=new int[array.length];
            for(int i=0; i<array.length;i++){
                numInt[i]= Integer.parseInt(array[i]);
//System.out.println("Array of numbers: "+ numInt[x]);
                ArrayList<Integer> intList=new ArrayList<>();
                while(numInt[i]!=0){
                    intList.add(numInt[i]%10);
                    numInt[i]/=10;
                }
                for(int j=0; j<intList.size();j++){
                    for(int z=1;z<intList.size();z++){
                        if(j==z) continue;
                        if(intList.get(j)==intList.get(z))count++;
                    }
                }
                if(count==0){
                    System.out.println("Число, состоящее только из разных цифр: "+array[i]);
                    break;
                }
                count=0;
            }
        }

    }
