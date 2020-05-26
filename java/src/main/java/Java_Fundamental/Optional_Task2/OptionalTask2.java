package Java_Fundamental.Optional_Task2;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class OptionalTask2 {
    public static int [][] createArray() throws IOException{
        System.out.println("Input size of array");
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println("Input range of variety");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        int range =Integer.parseInt(br.readLine());
        int [][] array = new int [n][n];
        for(int i=0; i<n;i++){
            for(int j=0;j<n; j++)
                array[i][j]=(int) (Math.random()*(2*range)-range);

        }
        return array;
    }
    // Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
    public static void sortArray(int array [][], int line){
        for(int i =0; i<array[i].length-1; i++){
            for(int j=i+1;j<array[i].length;j++){
                int t;
                if(array[line-1][i]>array[line-1][j]){


                    t=array[line-1][i];
                    array[line-1][i]=array[line-1][j];
                    array[line-1][j]=t;
                }
            }
        }
    }
    // Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
    public static int maxRise(int array[][]){
        int c=0;
        int [] arrayOne= new int[array.length*array.length];
        for(int[]x:array){
            for(int z:x){
                arrayOne[c++] =z;
            }
        }
        int more=0;
        int index;
        int max=0;
        for(int i=0; i<arrayOne.length-1; i++){
            if(arrayOne[i]<arrayOne[i+1]){
                more++;
                index=i;
            }
            else{
                if(max<more){
                    max=more;
                }
                more=0;
            }
        }
        return max+1;
    }
}
