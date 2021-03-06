package com.bpham.collections.graph;

import com.bpham.collections.queue.LinkedListQueue;
import com.bpham.collections.queue.Queue;

import java.util.*;

public class UndirectedGraph extends Graph {

    public UndirectedGraph(int numOfVertices) {
        super(numOfVertices);
    }

    @Override
    public void addEdge(int vertex1, int vertex2) {
        validateVertex(vertex1);
        validateVertex(vertex2);
        vertices[vertex1].add(vertex2);
        vertices[vertex2].add(vertex1);
        numOfEdges++;
    }

    public static class DepthFirstSearch {
        private UndirectedGraph graph;
        private int sourceVertex;
        private boolean[] visitedVertices;
        private int[] previousEdgeTo;

        public DepthFirstSearch(UndirectedGraph graph, int sourceVertex) {
            this.graph = graph;
            this.sourceVertex = sourceVertex;
            visitedVertices = new boolean[graph.numOfVertices()];
            previousEdgeTo = new int[graph.numOfVertices()];
            previousEdgeTo[sourceVertex] = sourceVertex;
            depthFirstSearch(sourceVertex);
        }

        private void depthFirstSearch(int vertex) {
            boolean hasVertexBeenVisited = visitedVertices[vertex];
            if (!hasVertexBeenVisited) {
                visitedVertices[vertex] = true;
                for (Integer adjVertex : graph.adjacentVertices(vertex)) {
                    if (!visitedVertices[adjVertex]) {
                        previousEdgeTo[adjVertex] = vertex;
                        depthFirstSearch(adjVertex);
                    }
                }
            }

        }

        public boolean hasPathTo(int vertex) {
            return visitedVertices[vertex];
        }

        public List<Integer> pathTo(int vertexToFind) {
            List<Integer> path = new ArrayList<>();
            pathTo(vertexToFind, path);
            Collections.reverse(path);
            return path;
        }

        public void pathTo(int vertex, List<Integer> path) {
            path.add(vertex);
            if (vertex == sourceVertex) {
                return;
            }
            pathTo(previousEdgeTo[vertex], path);
        }
    }

    public static class BreadthFirstSearch {
        private UndirectedGraph graph;
        private boolean[] visitedVertices;
        private int[] distTo;
        private int[] previousEdgeTo;
        private Queue<Integer> queue = new LinkedListQueue<>();

        public BreadthFirstSearch(UndirectedGraph graph, int sourceVertex) {
            this.graph = graph;
            visitedVertices = new boolean[graph.numOfVertices()];
            distTo = new int[graph.numOfVertices()];
            previousEdgeTo = new int[graph.numOfVertices()];
            breadthFirstSearch(sourceVertex);
        }

        private void breadthFirstSearch(int sourceVertex) {
            queue.enqueue(sourceVertex);
            distTo[sourceVertex] = 0;
            while (!queue.isEmpty()) {
                int vertex = queue.dequeue();
                visitedVertices[vertex] = true;
                for (Integer adjacentVertex : graph.adjacentVertices(vertex)) {
                    if (!visitedVertices[adjacentVertex]) {
                        previousEdgeTo[adjacentVertex] = vertex;
                        distTo[adjacentVertex] = distTo[vertex] + 1;
                        queue.enqueue(adjacentVertex);
                    }
                }
            }
        }

        public boolean hasPathTo(int vertex) {
            return visitedVertices[vertex];
        }

        public int distTo(int vertex) {
            return distTo[vertex];
        }

        public List<Integer> pathTo(int vertex) {
            List<Integer> path = new ArrayList<>();
            pathTo(vertex, path);
            Collections.reverse(path);
            return path;
        }

        public void pathTo(int vertex, List<Integer> path) {
            path.add(vertex);
            if (vertex == 0) {
                return;
            }
            pathTo(previousEdgeTo[vertex], path);
        }
    }
}
