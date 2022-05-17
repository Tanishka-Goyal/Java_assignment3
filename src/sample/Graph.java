package sample;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;


/**
 * constructs an undirected graph with some basic operations: addNode,
 * removeNode, addEdge, getNeighbors, etc.
 *
 * @author Saber Elsayed
 * @version 2.0, April 2022
 * @see Edge
 * @see Node
 */
public class Graph implements GraphInterface {

    /**
     * holds all nodes (people) in this graph
     */
    protected HashMap<Integer, Node> nodeList = new HashMap<>();

   

    /**
     * Test main that creates a graph,
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Graph g = new Graph();

        
    }

    @Override
    public Node addNode(Integer id, String name, LocalDate dob, String suburb) {
        return null;
    }

    @Override
    public void addEdge(Node from, Node to) {

    }

    @Override
    public void removeEdge(Node from, Node to) {

    }

    @Override
    public void removeNode(Node node) {

    }

    @Override
    public Set<Edge> getNeighbors(Node node) {
        return null;
    }
}