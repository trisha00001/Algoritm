/*
Задача №7. Заправки
В стране N городов, некоторые из которых соединены между собой дорогами.
Для того, чтобы проехать по одной дороге, требуется один бак бензина.
В каждом городе бак бензина имеет разную стоимость. Вам требуется добраться из первого города в N-ый, потратив как можно меньшее денег. Покупать бензин впрок нельзя.

Входные данные
В первой строке вводится число N (1≤N≤100), в следующей строке идет N чисел, i-ое из которых задает стоимость бензина в i-ом городе (всё это целые числа из диапазона от 0 до 100). Затем идет число M – количество дорог в стране, далее идет описание самих дорог. Каждая дорога задается двумя числами – номерами городов, которые она соединяет. Все дороги двухсторонние (то есть по ним можно ездить как в одну, так и в другую сторону), между двумя городами всегда существует не более одной дороги, не существует дорог, ведущих из города в себя.

Выходные данные
Требуется вывести одно число – суммарную стоимость маршрута или -1, если добраться невозможно.
 */
import java.util.Scanner;
public class zap {
    static int [][] Gr;
    static int N;
    static int key = 0;
    static int [] way;
    static int [] cost;

    static void D(int v) {
        for(int i=1; i<=N; i++) {
            if(Gr[v][i]==1 && way[v]+cost[v]<way[i] && v!=i) {
                way[i]=way[v]+cost[v]; D(i);
            }
            if (i==N && Gr[v][i]==1)
                key=1;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        cost = new int[N + 1];
        for (int i=1; i<=N; i++) {
            cost[i]=in.nextInt();
        }
        way=new int [N+1];
        for (int i=2; i<=N; i++) {
            way[i]= Integer.MAX_VALUE;
        }
        Gr=new int [N+1][N+1];
        int M = in.nextInt();
        for (int i=1; i<=M; i++) {
            int a=in.nextInt(), b=in.nextInt(); Gr[a][b]=1; Gr[b][a]=1;
        }
        D(1);

        if (way[N] == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(way[N]);
        }


    }



}