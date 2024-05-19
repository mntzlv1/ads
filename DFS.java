import java.util.ArrayList;
import java.util.List;

public class DFS {
    private boolean[] marked;
    private List<Integer> trace;

    public DFS(Graph G, int s) {
        marked = new boolean[G.V()];
        trace = new ArrayList<>();
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        trace.add(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public Iterable<Integer> trace() {
        return trace;
    }
}
