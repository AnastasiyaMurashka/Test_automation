package Java_Fundamental.Main_task;

import java.util.Scanner;

public class MainTask {
    public static void main(String[] args) {

        //   1. Приветствовать любого пользователя при вводе его имени через командную строку.
        Scanner in = new Scanner(System.in);
        System.out.println("Input your name: ");
        String name = in.nextLine();
        System.out.printf("Hello, %s \n", name);

        // 2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
        for(int i=args.length-1; i>=0; i--){
            System.out.println(args[i]);
        }
        // 3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
        System.out.println("Input a number");
        int number = in.nextInt();
        for(int y=0;y<number;y++){
            int num=(int)(Math.random()*100);
            System.out.println(num);
            System.out.print(num + " ");
        }
        // 4.  Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и
        // вывести результат на консоль.
        int sum=0;
        if (args.length>0){
            for(int i=0; i<args.length;i++){
                sum+= Integer.parseInt(args[i]);
            }
            System.out.println(sum);
        }
        // 5. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
        // Осуществить проверку корректности ввода чисел.
        String month[]={"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        System.out.println("Input the month as number");
        int num=in.nextInt();
        if(num<1|| num>12) {
            System.out.println("Incorrect input");
        }
        String mon=month[num-1];
        System.out.println(mon);


    }
}
