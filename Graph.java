import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > max) {
                max = degree(G, v);
            }
        }
        return max;
    }

    public static int avgDegree(Graph G) {
        return 2 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) count++;
            }
        }
        return count / 2;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(V + " vertices, " + E + " edges\n");
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (int w : this.adj(v)) {
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
