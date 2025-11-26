package net.justapie.algos.structure.graph;

public class DirectedSimpleGraph extends UndirectedSimpleGraph {
    /**
     * Initialize an undirected simple graph with a specified number of vertices. The first edge starts at index 1.
     * @param vertices number of vertices
     */
    public DirectedSimpleGraph(int vertices) {
        super(vertices);
    }

    /**
     * Add a directed edge to connect two vertices x and y but not y to x.
     * @param x vertices x
     * @param y vertices y
     */
    @Override
    public void addEdge(int x, int y) {
        this.getAdj().get(x).set(y, true);
    }
}
