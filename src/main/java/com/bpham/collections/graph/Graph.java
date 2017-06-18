package com.bpham.collections.graph;

import java.util.HashSet;
import java.util.Set;

public abstract class Graph {
    /**
     * Array of sets containing adjacent vertices.
     *
     * Indexes represent the vertex i.e. index 0 = vertex 0
     * */
    protected Set<Integer>[] vertices;
    protected int numOfVertices;
    protected int numOfEdges;

    public Graph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        vertices = new HashSet[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            vertices[i] = new HashSet<>();
        }
    }

    public abstract void addEdge(int vertex1, int vertex2);

    public int numOfEdges() {
        return numOfEdges;
    }

    public int numOfVertices() {
        return numOfVertices;
    }

    public boolean areAdjacent(int vertex1, int vertex2) {
        return vertices[vertex1].contains(vertex2) ||
                vertices[vertex2].contains(vertex1);
    }

    public Set<Integer> adjacentVertices(int vertex) {
        validateVertex(vertex);
        return vertices[vertex];
    }

    protected void validateVertex(int vertex) {
        if (vertex < 0 || vertex > numOfVertices) {
            throw new IllegalArgumentException("Invalid vertex");
        }
    }
}
