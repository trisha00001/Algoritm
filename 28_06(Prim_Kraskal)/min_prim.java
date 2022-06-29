/**
 * Задача №185. Минимальный каркас
 * Максимальное время работы на одном тесте:	5 секунд
 * От вас требуется определить вес минимального остовного дерева для неориентированного взвешенного связного графа.
 *
 * Входные данные
 * В первой строке входных данных находятся числа N и M (1 <= N <= 100; 1 <= M <= 6000), где N – количество вершин в графе, а M – количество рёбер. В каждой из последующих M строк записано по тройке чисел A, B, C, где A и B – номера вершин, соединённых ребром, а C – вес ребра (натуральное число, не превышающее 30000)
 *
 * Выходные данные
 * Вывести одно число – искомый вес.
 *
 */
import java.util.Scanner;
import java.util.Arrays;
public class min_prim {
    static int sum = 0;
    static Scanner in = new Scanner(System.in);
    static int n = in.nextInt();
    static int m = in.nextInt();
   //заполним граф 0
    static int[][] G = new int[n][n];


    // Implementing floyd warshall algorithm
    public static void prim(int graph[][], int V) {
        int INF = Integer.MAX_VALUE;

        int no_edge; // number of edge
        // create a array to track selected vertex
        // selected will become true otherwise false
        boolean[] selected = new boolean[V];
        // set selected false initially
        Arrays.fill(selected, false);
        // set number of edge to 0
        no_edge = 0;
        // the number of egde in minimum spanning tree will be
        // always less than (V -1), where V is number of vertices in
        // graph
        // choose 0th vertex and make it true
        selected[0] = true;
        // print for edge and weight
        System.out.println("Edge : Weight");
        while (no_edge < V - 1) {
            // For every vertex in the set S, find the all adjacent vertices
            // , calculate the distance from the vertex selected at step 1.
            // if the vertex is already in the set S, discard it otherwise
            // choose another vertex nearest to selected vertex at step 1.
            int min = INF;
            int x = 0; // row number
            int y = 0; // col number

            for (int i = 0; i < V; i++) {
                if (selected[i] == true) {
                    for (int j = 0; j < V; j++) {
                        // not in selected and there is an edge
                        if (!selected[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            sum += G[x][y];
            selected[y] = true;
            no_edge++;
        }
    }




        public static void main(String[] args) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    G[i][j] = 0;
                }
            }

            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                G[a - 1][b - 1] = c;
                G[b - 1][a - 1] = c;
            }


            min_prim a = new min_prim();
            min_prim.prim(G, n);
            System.out.println(sum);

        }

}
