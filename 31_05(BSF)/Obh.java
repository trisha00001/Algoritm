/*
От матрицы смежности к списку ребер, неориентированный вариант
Простой неориентированный граф задан матрицей смежности, выведите его представление в виде списка ребер.

Входные данные
Входные данные включают число n ( 1≤n≤100 ) – количество вершин в графе, а затем n строк по n чисел, каждое из которых равно 0 или 1, – его матрицу смежности.

Выходные данные
 */
import java.util.Scanner;

public class Obh {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[][] Ma2 = new int[a][a];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                Ma2[i][j] = in.nextInt();
            }
        }


        for (int i = 0; i < a; i++) {
            for (int j = i; j < a; j++) {
                if (Ma2[i][j] != 0){
                    System.out.print(i+1 + " ");
                    System.out.println(j+1);
                }
            }
        }


    }


}
