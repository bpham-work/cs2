package com.bpham.collections.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirectedGraph extends Graph {

    public DirectedGraph(int numOfVertices) {
        super(numOfVertices);
    }

    @Override
    public void addEdge(int vertex1, int vertex2) {
        validateVertex(vertex1);
        validateVertex(vertex2);
        vertices[vertex1].add(vertex2);
        numOfEdges++;
    }

    public static class DepthFirstSearch {
        private Graph graph;
        private boolean[] visited;
        private int[] previousVertices;
        private int sourceVertex;

        public DepthFirstSearch(Graph graph, int source) {
            this.graph = graph;
            this.visited = new boolean[graph.numOfVertices()];
            this.previousVertices = new int[graph.numOfVertices()];
            this.sourceVertex = source;
            depthFirstSearch(source);
        }

        private void depthFirstSearch(int vertex) {
            if (!visited[vertex]) {
                visited[vertex] = true;
                for (Integer adjVertex : graph.adjacentVertices(vertex)) {
                    if (!visited[adjVertex]) {
                        previousVertices[adjVertex] = vertex;
                        depthFirstSearch(adjVertex);
                    }
                }
            }
        }

        public List<Integer> pathTo(int vertex) {
            List<Integer> path = new ArrayList<>();
            pathTo(vertex, path);
            Collections.reverse(path);
            return path;
        }

        private void pathTo(int vertex, List<Integer> path) {
            path.add(vertex);
            if (vertex == sourceVertex) return;
            pathTo(previousVertices[vertex], path);
        }
    }
}
