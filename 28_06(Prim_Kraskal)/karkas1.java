/**
 * Задача №183. Каркас - разминка 1
 * Максимальное время работы на одном тесте:	5 секунд
 * Входные данные
 * Сначала вводится число N (1 <= N <= 100), а затем N чисел от 1 до 100 – элементы массива A[i]. Далее записаны два числа q и w (от 1 до N, не обязательно различные).
 *
 * Требуется все элементы, которые равны A[q], сделать равными A[w]. Постарайтесь сначала считать данные, потом сделать то, что требуется, и только потом вывести результат (а не делать преобразование на этапе вывода). Постарайтесь не пользоваться допoлнительными массивами.
 *
 * Выходные данные
 * Выведите N чисел - элементы массива A[i] после преобразования.
 *
 * Примеры
 * входные данные
 * 5
 * 1 4 2 2 5
 * 3 2
 * выходные данные
 * 1 4 4 4 5
 */
import java.util.Scanner;
import java.util.Arrays;
public class karkas1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] a = new int[n];
        for (int i = 0; i <n; i++){
            a[i] = in.nextInt();
        }
        int q = in.nextInt();
        int w = in.nextInt();
        boolean[] selected = new boolean[n];

        // set selected false initially
        Arrays.fill(selected, false);
        for (int i = 0; i <n; i++){
            if (a[i] == a[q-1]){
                selected[i] = true;
            }
        }


        for (int i = 0; i <n; i++){
            if (selected[i] == true){
                a[i] =a[w-1];
            }
        }


        for (int i = 0; i <n; i++){
            System.out.print(a[i]+" ") ;
        }




    }

}
