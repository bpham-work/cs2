package com.bpham.collections.graph;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UndirectedGraphTest {
    @Test
    public void shouldAddEdge() {
        UndirectedGraph graph = new UndirectedGraph(5);

        graph.addEdge(0, 1);

        assertTrue(graph.areAdjacent(0, 1));
        assertTrue(graph.areAdjacent(1, 0));
    }

    @Test
    public void shouldReturnNumOfVertices() {
        UndirectedGraph graph = new UndirectedGraph(5);

        assertEquals(5, graph.numOfVertices());
    }

    @Test
    public void shouldReturnNumOfEdges() {
        UndirectedGraph graph = new UndirectedGraph(5);

        graph.addEdge(0, 1);

        assertEquals(1, graph.numOfEdges());
    }

    @Test
    public void shouldReturnSetOfAdjacentVertices() {
        UndirectedGraph graph = new UndirectedGraph(5);

        graph.addEdge(0, 1);

        Iterable<Integer> adjacentVertices = graph.adjacentVertices(0);

        for (Integer vertex : adjacentVertices) {
            assertEquals((Integer) 1, vertex);
        }
    }

    @Test
    public void dfsShouldHavePathTo1() {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);

        UndirectedGraph.DepthFirstSearch dfs = new UndirectedGraph.DepthFirstSearch(graph, 0);

        assertTrue(dfs.hasPathTo(1));
    }

    @Test
    public void dfsShouldHavePathTo4() {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        UndirectedGraph.DepthFirstSearch dfs = new UndirectedGraph.DepthFirstSearch(graph, 0);

        assertTrue(dfs.hasPathTo(4));
    }

    @Test
    public void dfsShouldNotHavePathTo2() {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);

        UndirectedGraph.DepthFirstSearch dfs = new UndirectedGraph.DepthFirstSearch(graph, 0);

        assertFalse(dfs.hasPathTo(2));
    }

    @Test
    public void dfsReturnPathTo1() {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        UndirectedGraph.DepthFirstSearch dfs = new UndirectedGraph.DepthFirstSearch(graph, 0);

        List<Integer> pathTo = dfs.pathTo(1);

        assertEquals((Integer) 0, pathTo.get(0));
        assertEquals((Integer) 1, pathTo.get(1));
    }

    @Test
    public void dfsReturnPathTo4() {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        UndirectedGraph.DepthFirstSearch dfs = new UndirectedGraph.DepthFirstSearch(graph, 0);

        List<Integer> pathTo = dfs.pathTo(4);

        assertEquals((Integer) 0, pathTo.get(0));
        assertEquals((Integer) 1, pathTo.get(1));
        assertEquals((Integer) 2, pathTo.get(2));
        assertEquals((Integer) 3, pathTo.get(3));
        assertEquals((Integer) 4, pathTo.get(4));
    }

    @Test
    public void dfsReturnPathTo2() {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        UndirectedGraph.DepthFirstSearch dfs = new UndirectedGraph.DepthFirstSearch(graph, 0);

        List<Integer> pathTo = dfs.pathTo(2);

        assertEquals((Integer) 0, pathTo.get(0));
        assertEquals((Integer) 2, pathTo.get(1));
    }

    @Test
    public void bfsHasPathTo1() {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        UndirectedGraph.BreadthFirstSearch bfs = new UndirectedGraph.BreadthFirstSearch(graph, 0);

        assertTrue(bfs.hasPathTo(1));
    }

    @Test
    public void bfsDistTo0() {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        UndirectedGraph.BreadthFirstSearch bfs = new UndirectedGraph.BreadthFirstSearch(graph, 0);

        assertEquals(0, bfs.distTo(0));
    }

    @Test
    public void bfsDistTo1() {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        UndirectedGraph.BreadthFirstSearch bfs = new UndirectedGraph.BreadthFirstSearch(graph, 0);

        assertEquals(1, bfs.distTo(1));
    }

    @Test
    public void bfsDistTo2() {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        UndirectedGraph.BreadthFirstSearch bfs = new UndirectedGraph.BreadthFirstSearch(graph, 0);

        assertEquals(2, bfs.distTo(2));
    }

    @Test
    public void bfsPathTo2() {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        UndirectedGraph.BreadthFirstSearch bfs = new UndirectedGraph.BreadthFirstSearch(graph, 0);

        List<Integer> path = bfs.pathTo(2);

        assertEquals((Integer) 0, path.get(0));
        assertEquals((Integer) 1, path.get(1));
        assertEquals((Integer) 2, path.get(2));
    }

    @Test
    public void bfsShortestPathTo1() {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        UndirectedGraph.BreadthFirstSearch bfs = new UndirectedGraph.BreadthFirstSearch(graph, 0);

        List<Integer> path = bfs.pathTo(1);

        assertEquals((Integer) 0, path.get(0));
        assertEquals((Integer) 1, path.get(1));
    }

    @Test
    public void bfsShortestPathTo1LongestPathFirst() {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(0, 1);
        UndirectedGraph.BreadthFirstSearch bfs = new UndirectedGraph.BreadthFirstSearch(graph, 0);

        List<Integer> path = bfs.pathTo(1);

        assertEquals((Integer) 0, path.get(0));
        assertEquals((Integer) 1, path.get(1));
    }
}
