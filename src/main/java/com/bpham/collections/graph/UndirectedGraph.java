package com.bpham.collections.graph;

import com.bpham.collections.queue.LinkedListQueue;
import com.bpham.collections.queue.Queue;
import com.bpham.collections.stack.LinkedListStack;
import com.bpham.collections.stack.Stack;

import java.util.*;

public class UndirectedGraph {
    /**
     * Array of sets containing adjacent vertices.
     *
     * Indexes represent the vertex i.e. index 0 = vertex 0
     * */
    private Set<Integer>[] vertices;
    private int numOfVertices;
    private int numOfEdges;

    public UndirectedGraph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        vertices = new HashSet[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            vertices[i] = new HashSet<>();
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        validateVertex(vertex1);
        validateVertex(vertex2);
        vertices[vertex1].add(vertex2);
        vertices[vertex2].add(vertex1);
        numOfEdges++;
    }

    public int numOfEdges() {
        return numOfEdges;
    }

    public int numOfVertices() {
        return numOfVertices;
    }

    public boolean areAdjacent(int vertex1, int vertex2) {
        return vertices[vertex1].contains(vertex2);
    }

    public Iterable<Integer> adjacentVertices(int vertex) {
        validateVertex(vertex);
        return vertices[vertex];
    }

    private void validateVertex(int vertex) {
        if (vertex < 0 || vertex > numOfVertices) {
            throw new IllegalArgumentException("Invalid vertex");
        }
    }

    public static class DepthFirstSearch {
        private UndirectedGraph graph;
        private int sourceVertex;
        private boolean[] visitedVertices;

        public DepthFirstSearch(UndirectedGraph graph, int sourceVertex) {
            this.graph = graph;
            this.sourceVertex = sourceVertex;
            visitedVertices = new boolean[graph.numOfVertices()];
            depthFirstSearch(sourceVertex);
        }

        private void depthFirstSearch(int vertex) {
            boolean hasVertexBeenVisited = visitedVertices[vertex];
            if (!hasVertexBeenVisited) {
                visitedVertices[vertex] = true;
                for (Integer adjVertex : graph.adjacentVertices(vertex)) {
                    depthFirstSearch(adjVertex);
                }
            }
        }

        public boolean hasPathTo(int vertex) {
            return visitedVertices[vertex];
        }

        public List<Integer> pathTo(int vertexToFind) {
            Stack<Integer> pathStack = new LinkedListStack<>();
            boolean[] visitedVertices = new boolean[graph.numOfVertices()];
            pathTo(sourceVertex, vertexToFind, pathStack, visitedVertices);
            List<Integer> pathArray = new ArrayList<>();
            while (!pathStack.isEmpty()) {
                pathArray.add(pathStack.pop());
            }
            return pathArray;
        }

        public boolean pathTo(int source, int vertexToFind, Stack<Integer> pathStack, boolean[] visitedVertices) {
            visitedVertices[source] = true;
            if (source == vertexToFind) {
                pathStack.push(vertexToFind);
                return true;
            }
            for (Integer adjacentVertex : graph.adjacentVertices(source)) {
                if (!visitedVertices[adjacentVertex]) {
                    boolean hasPath = pathTo(adjacentVertex, vertexToFind, pathStack, visitedVertices);
                    if (hasPath) {
                        pathStack.push(source);
                        return true;
                    }
                }
            }
            return false;
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
