package data_structures.graphs;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class AdjacencyMatrix {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private boolean[][] adjMatrix;

    // empty graph with V vertices
    public AdjacencyMatrix(int V) {
        if (V < 0) throw new IllegalArgumentException("Too few vertices");
        this.V = V;
        this.E = 0;
        this.adjMatrix = new boolean[V][V];
    }
    // random graph with V vertices and E edges
    public AdjacencyMatrix(int V, int E) {
        this(V);
        if (E > (long) V*(V-1)/2 + V) throw new IllegalArgumentException("Too many edges");
        if (E < 0) throw new IllegalArgumentException("Too few edges");
        Random random = new Random();
        // can be inefficient
        while (this.E != E) {
            int u = random.nextInt(V);
            int v = random.nextInt(V);
            addEdge(u, v);
        }
    }

    // number of vertices and edges
    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    // add undirected edge u-v
    public void addEdge(int u, int v) {
        if (!adjMatrix[u][v]) E++;
        adjMatrix[u][v] = true;
        adjMatrix[v][u] = true;
    }

    // does the graph contain the edge u-v?
    public boolean contains(int u, int v) {
        return adjMatrix[u][v];
    }

    // return list of neighbors of u
    public Iterable<Integer> adjMatrix(int u) {
        return new AdjIterator(u);
    }

    // support iteration over graph vertices
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        private int u;
        private int v = 0;
        AdjIterator(int u) {
            this.u = u;
        }

        public Iterator<Integer> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (v < V) {
                if (adjMatrix[u][v]) return true;
                v++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return v++;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    // string representation of Graph - takes quadratic time
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Undirected graph" + NEWLINE);
        s.append("Vertices:"+ V + " and edges:" + E + NEWLINE);

        for (int u = 0; u < V; u++) {
            s.append(u + ": ");
            for (int v = 0; v < V; v++) {
                s.append(String.format("%7s", adjMatrix[v][u]) + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) { //test code
        int V = 5;
        int E = 7;
        AdjacencyMatrix am = new AdjacencyMatrix(V, E);
        System.out.println(am.toString());
    }

}
