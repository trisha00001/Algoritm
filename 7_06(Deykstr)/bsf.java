/**
 *
 * Алгоритм работает следующим образом:
 *
 * Начните с размещения любой вершины графа в конце очереди.
 * Возьмите передний элемент очереди и добавьте его в список посещенных.
 * Создайте список смежных узлов этой вершины. Добавьте те, которых нет в списке посещенных, в конец очереди.
 * Продолжайте повторять шаги 2 и 3, пока очередь не опустеет.
 * Граф может иметь две разные несвязанные части, поэтому, чтобы убедиться, что мы покрываем каждую
 *вершину, мы также можем запустить алгоритм BFS на каждом узле
 */

import java.util.*;
public class bsf {
    private int V;
    private LinkedList<Integer> adj[];

    // Create a graph
    bsf(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Add edges to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS algorithm
    void BFS(int s) {

        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    public static void main(String args[]) {
        bsf g = new bsf(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
        g.BFS(2);
    }
}


