package com.bpham.collections.graph;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DirectedGraphTest {
    @Test
    public void vertex0ShouldHaveAdjacentVertex1() {
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(0, 1);

        boolean result = graph.adjacentVertices(0).contains(1);

        assertTrue(result);
    }

    @Test
    public void vertex1ShouldNotHaveAdjacentVertex0() {
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(0, 1);

        boolean result = graph.adjacentVertices(1).contains(0);

        assertFalse(result);
    }

    @Test
    public void dfsPathTo1() {
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(0, 1);
        DirectedGraph.DepthFirstSearch dfs = new DirectedGraph.DepthFirstSearch(graph, 0);

        List<Integer> result = dfs.pathTo(1);

        assertEquals((Integer) 0, result.get(0));
        assertEquals((Integer) 1, result.get(1));
    }

    @Test
    public void dfsPathTo4() {
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        DirectedGraph.DepthFirstSearch dfs = new DirectedGraph.DepthFirstSearch(graph, 0);

        List<Integer> result = dfs.pathTo(4);

        assertEquals((Integer) 0, result.get(0));
        assertEquals((Integer) 1, result.get(1));
        assertEquals((Integer) 2, result.get(2));
        assertEquals((Integer) 3, result.get(3));
        assertEquals((Integer) 4, result.get(4));
    }

    @Test
    public void test() {
        Long l = Long.parseLong("9342342342342342342342342342342342342342342342342342342342342");
    }
}
