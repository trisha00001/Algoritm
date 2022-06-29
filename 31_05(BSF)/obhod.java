/**
 * Дан неориентированный невзвешенный граф. Для него вам необходимо найти количество вершин, лежащих в одной компоненте связности с данной вершиной (считая эту вершину).
 *
 * Входные данные
 * В первой строке входных данных содержатся два числа: N и S (1 ≤ N ≤ 100; 1 ≤ S ≤ N), где N – количество вершин графа, а S – заданная вершина. В следующих N строках записано по N чисел – матрица смежности графа, в которой 0 означает отсутствие ребра между вершинами, а 1 – его наличие. Гарантируется, что на главной диагонали матрицы всегда стоят нули.
 *
 * Выходные данные
 * Выведите одно целое число – искомое количество вершин.
 */
import java.util.Scanner;
public class obhod {

    static Scanner in = new Scanner(System.in);
    static int a = in.nextInt();
    static int x = in.nextInt();
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
        dfs2(x);
        int count = 0;
        for (int i = 0; i < a; i++) {
            if (used[i] == true) {
                count++;
            }

        }
        System.out.println(count);
    }

}
