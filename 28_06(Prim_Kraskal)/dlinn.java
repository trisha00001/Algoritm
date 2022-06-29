/**
 Задача №96. Самый длинный путь
 Ввод и вывод данных производятся через стандартные потоки ввода-вывода.
 Дан ориентированный граф, рёбрам которого приписаны некоторые неотрицательные веса (длины). Надо найти две вершины, кратчайший путь между которыми имеет наибольшую длину.

 Входные данные
 В первой строке задано число вершин N ≤50. Далее идёт матрица смежности графа, то есть N строк, в каждой из которых записано N чисел. j-ое число в i-ой строке матрицы смежности задает длину ребра, ведущего из i-й вершину в j-ую. Длины могут принимать любые значения от от 0 до 1000000. Гарантируется, что на главной диагонали матрицы стоят нули.

 Выходные данные
 Выведите одно число – длину искомого пути.

 Примеры
 входные данные
 3
 0 7 3
 7 0 10
 2 215 0
 выходные данные
 10
 */
import java.util.Scanner;

public class dlinn {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int infinum = Integer.MAX_VALUE;
        int maxim = - Integer.MAX_VALUE;


// Ввела граф
        int[][] G = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                G[i][j] = in.nextInt();
                if (G[i][j] == -1) {
                    G[i][j] = infinum;
                }
            }

        }

        // Floid
        for (int k = 0; k <n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (G[i][j] > G[i][k] + G[k][j]) {
                        G[i][j] = G[i][k] + G[k][j];

                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (G[i][j] != infinum && i !=j){
                    maxim = Math.max(G[i][j], maxim);
                }

            }
        }
        boolean a = false;

        for (int i = 0; i < n; i++) {
            if (G[i][i] <0) {
                a = true;
            }

        }
         if (a == true){
             System.out.println("-1");

         }
         else{
             System.out.println(maxim);
         }




     }
}
