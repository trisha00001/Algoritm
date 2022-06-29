/**
 *  Дейкстра
 *  Дан ориентированный взвешенный граф. Найдите кратчайшее расстояние от одной заданной вершины до другой.
 *
 * Входные данные
 * В первой строке содержатся три числа: N, S и F (1≤ N≤ 100, 1≤ S, F≤ N), где N – количество вершин графа, S – начальная вершина, а F – конечная. В следующих N строках вводится по N чисел, не превосходящих 100, – матрица смежности графа, где -1 означает отсутствие ребра между вершинами, а любое неотрицательное число – присутствие ребра данного веса. На главной диагонали матрицы записаны нули.
 *
 * Выходные данные
 * Требуется вывести искомое расстояние или -1, если пути между указанными вершинами не существует.
 */
import java.util.Scanner;
public class Dey {
    static Scanner in = new Scanner(System.in);
    static int n = in.nextInt();
    static int start = in.nextInt();
    static int fin = in.nextInt();
    static boolean [] used = new boolean[n];
    static int[] distance = new int[n];
    static int [][] G = new int[n][n];
    static int[] path = new int[n];

    public static void D(int start){
        distance[start] = 0;
        for (int i = 0; i < n; i++){
            int imin = -1;
            for (int j = 0; j <n; j++){
                if (!used[j] && (imin == -1  || distance[j] < distance[imin]))
                    imin = j;}
                used[imin] = true;
                for (int j = 0; j <n; j++){
                    if (!used[j] &&    G[imin][j] != -1){
                    distance[j] = Math.min(distance[j], distance[imin] +G[imin][j]);
                    path[j] = imin + 1;
                }

            }

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < G.length; i++){
            for (int j = 0; j < G.length; j++){
                G[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < G.length; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        D(start -1);
        if (distance[fin -1] == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(distance[fin -1]);
        }

    }
}
