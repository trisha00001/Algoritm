/*
Дано неориентированное невзвешенное дерево. Требуется найти самую удаленную вершину от данной.

Входные данные
В первой строке дано число n — количество вершин дерева и число k — номер вершины, для которой
нужно найти самую удаленную от нее ( 1 ≤ k ≤ n ≤ 100 ).
Далее в n строках дана матрица смежности дерева.

Выходные данные
Выведите номер самой удаленной вершины от данной. Если таких вершин несколько,
выведите наименьший номер.
Примеры
входные данные
4 2
0 1 0 1
1 0 1 0
0 1 0 0
1 0 0 0
выходные данные
4
 */
import java.util.Scanner;
public class dlin_versh {
    static Scanner in = new Scanner(System.in);
    static int n = in.nextInt();
    static int start = in.nextInt()-1;
    static int [] [] Graf = new int [n] [n] ;
    static int [] visit = new int [n] ;

    public static void main(String[] args) {
        int temp = start;
        for (int i = 0; i < n; i++)
        {
            visit [i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++)
            {
                Graf[i][j] = in.nextInt();
            }
        }

        bfs(start);
        for (int i = 0; i < n; i++)
            if(visit[i]>visit[temp])
                temp = i;

        System.out.print(temp+1);
    }


    static void bfs(int s) {
        int k = 0;
        int [] q = new int [n] ;
        visit[s] = 0;
        q[k]=s;
        k++;
        while(k != 0)
        {
            k--;
            int v = q[k];

            for (int i = 0; i < n; i++)
            {
                if (Graf[v][i] == 1 && visit[i] == Integer.MAX_VALUE)
                {
                    visit[i] = visit[v] + 1;
                    q[k]=i;
                    k++;
                }
            }
        }
    }


}
