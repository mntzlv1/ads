public class Main {
    public static void main(String[] args) {
        Graph G = new Graph(7);
        G.addEdge(0, 2);
        G.addEdge(0, 1);
        G.addEdge(0, 3);
        G.addEdge(1, 4);
        G.addEdge(1, 6);
        G.addEdge(1, 2);
        G.addEdge(4, 6);
        G.addEdge(4, 5);
        G.addEdge(6, 5);
        G.addEdge(3, 2);

        DFS dfs = new DFS(G, 0);
        System.out.println("DFS trace starting from A:");
        for (int v : dfs.trace()) {
            System.out.print((char) ('A' + v) + " ");
        }
    }
}
