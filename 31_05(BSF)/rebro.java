/*
Простой неориентированный граф задан списком ребер, выведите его представление в виде матрицы смежности.

Входные данные
На вход программы поступают числа n ( 1≤n≤100 ) – количество вершин в графе и m ( 1≤m≤n(n−1)/2 ) – количество ребер. Затем следует m пар чисел – ребра графа.

Выходные данные
Выведите матрицу смежности заданного графа.
 */
import java.util.Scanner;

public class rebro {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int razmer = in.nextInt();
        int [] [] Ma2 = new int [razmer] [razmer] ;
        int kol = in.nextInt();
        for (int i = 0; i < kol; i++)
        {
            int temp1 = in.nextInt()-1;
            int temp2 = in.nextInt()-1;
            Ma2[temp1][temp2] = 1;
            Ma2[temp2][temp1] = 1;
        }

        for (int i = 0; i < razmer; i++)
        {
            for (int j = 0; j < razmer; j++)
            {
                System.out.print(Ma2[i] [j] + " ");
            }
            System.out.println();
        }
    }
}
