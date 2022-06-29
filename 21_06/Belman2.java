import java.util.Scanner;
public class Belman2 {
    static int [] L;
    static final int INF= Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        L=new int [N+1];
        for (int i=2; i<=N; i++)
            L[i]=INF;

        for (int i=1; i<=N; ++i)
            for (int j=1; j<=N; ++j)
                if (i<j)
                    if (L[i]+(179*i+719*j)%1000-500<L[j])
                        L[j]=L[i]+(179*i+719*j)%1000-500;
        System.out.println(L[N]);
    }
}
