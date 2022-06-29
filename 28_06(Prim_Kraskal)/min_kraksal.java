import java.io.*;
import java.util.ArrayList;
import java.util.*;
public class min_kraksal {
    class Edge implements Comparable<Edge>{
        public int compareTo(Edge b){
            if (this.c != b.c) return this.c - b.c;
            if (this.b != b.b) return this.b - b.b;
            return 0;
        }

        int a, b, c;
        Edge next;
        Edge(int a, int b, int c, Edge next){
            this.a = a;
            this.b = b;
            this.c = c;
            this.next = next;
        }
    }

    class Graph{
        int n, m;
        Edge sm[];

        Edge[] getEdgeList(){
            ArrayList<Edge> tmp = new ArrayList<Edge>();
            for (int i = 0; i < n; i++){
                Edge e = sm[i];
                while (e != null){
                    tmp.add(e);
                    e = e.next;
                }
            }
            Edge[] res = new Edge[tmp.size()];
            for (int i = 0; i < tmp.size(); i++)
                res[i] = tmp.get(i);
            return res;
        }

        void scanMatrixIncidence(StreamTokenizer in) throws IOException{
            in.nextToken();
            n = (int)in.nval;
            m = 0;
            sm = new Edge[n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++){
                    in.nextToken();
                    int p = (int)in.nval;
                    if (p != 0){
                        sm[i] = new Edge(i, j, p, sm[i]);
                        m++;
                    }
                }
        }
        public Graph clone(){
            Graph res = new Graph();
            res.n = this.n;
            res.m = this.m;
            res.sm = new Edge[n];
            for (int i = 0; i < this.n; i++){
                Edge tmp = this.sm[i];
                while (tmp != null){
                    res.sm[i] = new Edge(i, tmp.b, tmp.c, res.sm[i]);
                    tmp = tmp.next;
                }
            }
            return res;
        }
        void scanListEdges(StreamTokenizer in) throws IOException{
            in.nextToken();
            n = (int)in.nval;
            in.nextToken();
            m = (int)in.nval;
            sm = new Edge[n];
            for (int i = 0; i < m; i++){
                in.nextToken();
                int p = (int)in.nval - 1;
                in.nextToken();
                int q = (int)in.nval - 1;
                in.nextToken();
                int d = (int)in.nval;
                sm[p] = new Edge(p, q, d, sm[p]);
            }
        }
    }

    class DSU{
        int p[];
        int rank[];

        int rest;

        DSU(int n){
            p = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++){
                p[i] = i;
                rank[i] = 0;
            }
            rest = n;
        }
        private int getP(int a){
            if (p[a] != a)
                p[a] = getP(p[a]);
            return p[a];
        }
        public void Union(int a, int b){
            a = getP(a);
            b = getP(b);
            if (a != b)
                rest--;
            else
                return;
            if (rank[a] <= rank[b]){
                p[a] = b;
                if (rank[a] == rank[b])
                    rank[b]++;
            }
            else
                p[b] = a;
        }
        boolean Check(int a, int b){
            return getP(a) == getP(b);
        }
    }

    void solve() throws IOException{
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        Graph a = new Graph();
        a.scanListEdges(in);

        DSU b = new DSU(a.n);
        Edge[] edges = a.getEdgeList();

        Arrays.sort(edges);
        int res = 0;
        for (int i = 0; i < edges.length; i++)
            if (!b.Check(edges[i].a, edges[i].b)){
                b.Union(edges[i].a, edges[i].b);
                res += edges[i].c;
            }
        out.println(res);
        out.close();
    }

    public static void main(String[] args) throws IOException{
        min_kraksal a = new min_kraksal();
        a.solve();
    }


}
