/**
 Дорожная карта у программиста Васи записана как матрица смежности графа. Напишите программу, которая поможет Васе определить, верно ли, что из первого города можно проехать во все остальные (не обязательно напрямую).

 Входные данные
 В первой строке вводится количество городов на карте N ( 1 ≤ N ≤ 1000 ). В следующих N строках записано по N чисел, разделённых пробелами – элементы матрицы смежности графа, который описывает схему дорог.

 Выходные данные
 Программа должна вывести слово 'YES', если из первого по порядку города можно проехать во все остальные, и 'NO', если это не так.
 */

import java.util.Scanner;

public class DFS {
    static Scanner in = new Scanner(System.in);
    static int a = in.nextInt();
    static boolean []  used = new boolean[a];
    static  int [] [] Ma2 = new int [a] [a] ;
    public static void dfs2(int v){

        used[v] = true;
        for (int i =0; i <a; i++ ){
            if (Ma2[v][i] == 1 && !used[i]){
                dfs2(i);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < a; i++)
        {
            for (int j = 0; j < a; j++) {
                Ma2[i][j] = in.nextInt();
            }
        }
        dfs2(0);
        int count = 1;
        for (int i = 0; i < a; i++){
            if (used[i] == false){
                count =0;
                break;
            }
        }
        if (count == 0){
            System.out.println("NO");

        }
        else
            System.out.println("YES");

    }
}
