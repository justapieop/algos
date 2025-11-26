package net.justapie.algos.algorithm.sort;

import net.justapie.algos.structure.graph.DirectedSimpleGraph;
import net.justapie.algos.structure.stack.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopologicalSort {
    private static void dfs(DirectedSimpleGraph graph, int x, Stack<Integer> st, List<Boolean> visited) {
        if (visited.get(x)) {
            return;
        }
        List<Integer> adj = graph.getAdjacent(x);
        for (Integer integer : adj) {
            dfs(graph, integer, st, visited);
        }

        visited.set(x, true);
        st.add(x);
    }

    /**
     * Perform a topological sort on a directed simple graph.
     * @param graph a directed simple graph
     * @return a list of integer sorted in a topological order
     */
    public static List<Integer> sort(DirectedSimpleGraph graph) {
        Stack<Integer> st = new Stack<>();
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(graph.getVertices() + 1, false));

        dfs(graph, 1, st, visited);

        List<Integer> l = new ArrayList<>();
        while (st.getSize() > 0) {
            l.add(st.pop());
        }
        return l;
    }
}
