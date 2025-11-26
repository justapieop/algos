package net.justapie.algos.structure.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UndirectedSimpleGraph {
    private final List<List<Boolean>> adj;
    private final int vertices;

    /**
     * Initialize an undirected simple graph with a specified number of vertices. The first edge starts at index 1.
     * @param vertices number of vertices
     */
    public UndirectedSimpleGraph(int vertices) {
        this.adj = new ArrayList<>();
        this.vertices = vertices;

        for (int i = 0; i <= vertices; i++) {
            this.adj.add(Collections.nCopies(vertices + 1, null));
        }
    }

    /**
     * Add an edge to connect two vertices x and y.
     * @param x vertices x
     * @param y vertices y
     */
    public void addEdge(int x, int y) {
        this.adj.get(x).set(y, true);
        this.adj.get(y).set(x, true);
    }

    /**
     * Check if two vertices x and y are connected.
     * @param x vertices x
     * @param y vertices y
     * @return a boolean value indicating whether x and y are connected
     */
    public boolean isConnected(int x, int y) {
        return this.adj.get(x).get(y);
    }

    /**
     * Get a list of adjacent vertices with x.
     * @param x vertices x
     * @return a list of vertices that are adjacent to x
     * @throws IllegalArgumentException if x is not vertices in graph
     */
    public List<Integer> getAdjacent(int x) throws IllegalArgumentException {
        if (x > this.vertices || x <= 0) {
            throw new IllegalArgumentException(String.format("x must be in range [1, %d]", this.vertices));
        }
        List<Integer> a = new ArrayList<>();

        for (int i = 1; i < this.adj.get(x).size(); i++) {
            if (this.adj.get(x).get(i)) {
                a.add(i);
            }
        }

        return a;
    }

    public int getVertices() {
        return this.vertices;
    }

    protected List<List<Boolean>> getAdj() {
        return this.adj;
    }
}
