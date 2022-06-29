import java.util.Scanner;
public class floid1 {
    static int[][]D;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // ввод матрицы
        int N = scan.nextInt();
        int[][]C = new int[N][N];
        for (int i = 0;i<N;i++) {
            for (int j=0;j<N;j++) {
                C[i][j]=scan.nextInt();
            }
        }
        // матрица с кратч. расстояниями
        D = new int[N][N];
        for (int i = 0;i<N;i++) {
            for (int j=0;j<N;j++) {
                D[i][j]=C[i][j];
            }
        }

        // флойд
        for (int K = 0;K<N;K++) {
            for (int i = 0;i<N;i++) {
                for (int j=0;j<N;j++) {
                    D[i][j]=Math.min(D[i][j], D[i][K]+D[K][j]);
                }
            }
        }
        // ввывод
        for (int i = 0;i<N;i++) {
            for (int j=0;j<N;j++) {
                System.out.print(D[i][j]+" ");
            }
            System.out.println();
        }
    }


}
