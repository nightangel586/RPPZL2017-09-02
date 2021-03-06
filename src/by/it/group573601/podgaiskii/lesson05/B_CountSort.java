package by.it.group573601.podgaiskii.lesson05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Первая строка содержит число 1<=n<=10000, вторая - n натуральных чисел, не превышающих 10.
Выведите упорядоченную по неубыванию последовательность этих чисел.

При сортировке реализуйте метод со сложностью O(n)

Пример: https://karussell.wordpress.com/2010/03/01/fast-integer-sorting-algorithm-on/
Вольный перевод: http://programador.ru/sorting-positive-int-linear-time/
*/

public class B_CountSort {


    int[] countSort(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //размер массива
        int n = scanner.nextInt();
        int[] points=new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //читаем точки
        for (int i = 0; i < n; i++) {
            points[i]=scanner.nextInt();
            if (points[i] < min)
                min = points[i];
            if (points[i] > max)
                max = points[i];
        }
        //тут реализуйте логику задачи с применением сортировки подсчетом
        int[] counter = new int[max - min + 1];
        for (int i = 0; i < n; i++)
            counter[-min + points[i]]++;
        int i = 0;
        for (int j = 0; j < counter.length; j++)
            for (int k = 0; k < counter[j]; k++)
                points[i++] = j + min;





        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return points;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group573601/podgaiskii/lesson05/dataB.txt");
        B_CountSort instance = new B_CountSort();
        int[] result=instance.countSort(stream);
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}
