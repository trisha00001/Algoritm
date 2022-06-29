/**
 * Задача №178. Форд-Беллман
 * Дан ориентированный граф, в котором могут быть кратные ребра и петли. Каждое ребро имеет вес, выражающийся целым числом (возможно, отрицательным). Гарантируется, что циклы отрицательного веса отсутствуют.
 *
 * Требуется посчитать длины кратчайших путей от вершины номер 1 до всех остальных вершин.
 *
 * Входные данные
 * Программа получает сначала число N (1 <= N <= 100) – количество вершин графа и число M (0 <= M <= 10000) – количество ребер. В следующих строках идет M троек чисел, описывающих ребра: начало ребра, конец ребра и вес (вес – целое число от -100 до 100).
 *
 * Выходные данные
 * Программа должна вывести N чисел – расстояния от вершины номер 1 до всех вершин графа. Если пути до соответствующей вершины не существует, вместо длины пути выведите число 30000.
 *
 * Примеры
 * входные данные
 * 6 4
 * 1 2 10
 * 2 3 10
 * 1 3 100
 * 4 5 -10
 */
import java.util.Scanner;
public class Task178 {
    static class edge{
        int a,b,cost;
        public edge (int a, int b, int cost) {
            this.a=a;
            this.b=b;
            this.cost=cost;}
    }
    static edge e[];
    static int [] L;
    static final int INF=30000;


    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt(), R=in.nextInt(); // N количество вершин графа
        e=new edge[R+1];
        L=new int [N+1];
        for (int i=1; i<=R; i++)
            e[i]=new edge (in.nextInt(), in.nextInt(), in.nextInt());
        for (int i=2; i<=N; i++) L[i]=INF;
        for (int i=1; i<=N-1; i++)
            for (int j=1; j<=R; ++j)
                if (L[e[j].a] < INF)
                    L[e[j].b]=Math.min(L[e[j].b], L[e[j].a] + e[j].cost);
        for (int i=1; i<N; i++)
            System.out.print(L[i] + " ");
        System.out.println(L[N]);

    }
}
