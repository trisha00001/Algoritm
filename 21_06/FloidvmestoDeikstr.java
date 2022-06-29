import java.util.Scanner;

/**
 * Дан ориентированный граф, рёбрам которого приписаны некоторые неотрицательные веса (длины).
 * Найти длину кратчайшего пути из вершины s в вершину t.
 *
 * Входные данные
 * В первой строке заданы три числа: число вершин в графе N ≤50, номера вершин s и t.
 * Далее идёт матрица смежности графа, то есть N строк, в каждой из которых записано N чисел.
 * j-ое число в i-ой строке матрицы смежности задает длину ребра, ведущего из i-й вершину в j-ую.
 * Длины могут принимать любые значения от 0 до 1000000, число -1 означает отсутствие соответствующего ребра.
 * Гарантируется, что на главной диагонали матрицы стоят нули.
 *
 * Выходные данные
 * Выведите одно число – минимальную длину пути. Если пути не существует, выведите -1.
 *
 * Примеры
 * входные данные
 * 3 1 2
 * 0 -1 3
 * 7 0 1
 * 2 -1 0
 */
import java.util.Scanner;
public class FloidvmestoDeikstr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int start = in.nextInt()-1;
        int end = in.nextInt() - 1;
        int INF = Integer.MAX_VALUE;
        int[][] G = new int[n][n];
        for (int i = 0; i<n; i++){
            for (int j = 0; j <n; j++){
                G[i][j] = in.nextInt();
                if (G[i][j] == -1){
                    G[i][j] = INF;
                }
            }

        }
        for (int k = 0; k <n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (G[i][j] > G[i][k]+G[k][j]){
                        G[i][j] = G[i][k]+G[k][j];

                    }

                }
            }
        }
        if (G[start][end] == -2147483644){
            System.out.println("-1");
        }
        else{
            System.out.println(G[start][end]);
        }

    }


}
