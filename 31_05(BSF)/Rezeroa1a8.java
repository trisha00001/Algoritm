import java.util.Scanner;

/*
Задача №112635. Независимость
На острове расположены несколько государств, изолированных друг от друга. У программиста Васи есть данные обо всех дорогах острова, заданные в виде весовой матрицы соответствующего графа, узлы которого – города, а веса рёбер – расстояния между ними. Напишите программу, которая определяет, сколько государств находится на острове.

Входные данные
В первой строке вводится количество городов на карте N ( 1 ≤ N ≤ 1000 ). В следующих N строках записано по N чисел, разделённых пробелами – элементы весовой матрицы графа, который описывает схему дорог.

Выходные данные
Программа должна вывести одно число – количество отдельных государств на карте острова.
 */

public class Rezeroa1a8 {
    static Scanner in = new Scanner(System.in);
    static int a = in.nextInt();
    static boolean[] used = new boolean[a];
    static int[][] Ma2 = new int[a][a];

    public static void dfs2(int v) {

        used[v] = true;
        for (int i = 0; i < a; i++) {
            if (Ma2[v][i] > 0 && !used[i]) {
                dfs2(i);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                Ma2[i][j] = in.nextInt();
            }
        }
        dfs2(0);
        int count = 1;
        for (int i = 0; i < a; i++) {
            if (used[i] == false) {
                dfs2(i);
                count++;
            }

        }
        System.out.println(count);


    }
}
