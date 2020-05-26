package Java_Fundamental.Optional_Task2;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  throws IOException{

        int [][] newArray = OptionalTask2.createArray();
        for(int i = 0; i<newArray.length; i++){
            for(int j = 0; j<newArray.length; j++){
                System.out.print(newArray[i][j]+" ");
            }
            System.out.println();
        }
        OptionalTask2.sortArray(newArray,1);
        for(int i = 0; i<newArray.length; i++){
            for(int j = 0; j<newArray.length; j++){
                System.out.print(newArray[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Наибольшее число возрастающих элементов матрицы: "+ OptionalTask2.maxRise(newArray) );
    }
}
