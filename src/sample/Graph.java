package sample;

import javax.management.InstanceAlreadyExistsException;
import java.time.LocalDate;
import java.util.*;


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
    protected HashMap<Integer, List<Integer>> graphEdges= new HashMap<>();

   

    /**
     * Test main that creates a graph,
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Graph g = new Graph();
        Node n1 = g.addNode(1, "A", LocalDate.parse("1997-10-11"), "Bruce");
        Node n2 = g.addNode(2, "B", LocalDate.parse("1997-10-11"), "Bruce");
        Node n3 = g.addNode(3, "C", LocalDate.parse("1997-10-11"), "Bruce");
        Node n4 = g.addNode(4, "D", LocalDate.parse("1997-10-11"), "Bruce");
        System.out.println("Original nodeList:");
        System.out.println(g.nodeList.keySet());

        g.addEdge(n1, n2);
        g.addEdge(n1,n3);
        g.addEdge(n1,n4);
        g.addEdge(n2,n3);
        g.addEdge(n2,n4);
        g.addEdge(n3,n4);

        System.out.println("Original Graph:");
        System.out.println(g.graphEdges);

        g.addEdge(n3,n2);
        System.out.println("After adding duplicate");
        System.out.println(g.graphEdges);

        g.removeEdge(n2,n1);
        System.out.println("Graph after removing 1 edge:");
        System.out.println(g.graphEdges);
        g.removeNode(n3);
        System.out.println("Graph after removing 1 node:");
        System.out.println(g.graphEdges);
        System.out.println("NodeList after removing 1 node:");
        System.out.println(g.nodeList.keySet());
        g.getNeighbors(n4);
        g.toString();
        
    }

    @Override
    public Node addNode(Integer id, String name, LocalDate dob, String suburb)
    {
        Node node = null;
        try {
            node = new Node(id, name, dob, suburb);
            Node success = nodeList.putIfAbsent(node.hashCode(), node);
            if (success != null) {
                throw new InstanceAlreadyExistsException("The node exists.");
            } else {
                graphEdges.put(node.hashCode(), new LinkedList<Integer>());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return node;
    }

    public boolean checkEdge(Node source, Node dest)
    {
        boolean edgeExists = false;
        edgeExists = graphEdges.get(source.hashCode()).contains(dest.hashCode());
        return edgeExists;
    }

    @Override
    public void addEdge(Node from, Node to)
    {
        if (!nodeList.containsKey(from.hashCode()))
        {
            throw new NoSuchElementException("The source node doesnot exist");
        } else if (!nodeList.containsKey(to.hashCode()))
        {
            throw new NoSuchElementException("The destination node doesnot exist");
        } else if (from.equals(to))
        {
            throw new IndexOutOfBoundsException("Both nodes are equal");
        } else {
            if (!checkEdge(from,to))
            {
                graphEdges.get(from.hashCode()).add(to.hashCode());
            }
            if(!checkEdge(to,from))
            {
                graphEdges.get(to.hashCode()).add(from.hashCode());
            }
        }

    }

    @Override
    public void removeEdge(Node from, Node to)
    {
        if (!graphEdges.containsKey(from.hashCode()) || !graphEdges.containsKey(to.hashCode()))
        {
            throw new NoSuchElementException("The edge does not exist");
        } else
        {
            graphEdges.get(from.hashCode()).remove((Integer) to.hashCode());
            graphEdges.get(to.hashCode()).remove((Integer) from.hashCode());
        }
    }

    @Override
    public void removeNode(Node node) {
        Iterator <Map.Entry<Integer, List<Integer>>> graphIterator = graphEdges.entrySet().iterator();
        if(!nodeList.containsKey(node.hashCode()))
        {
            throw new NoSuchElementException("The node does not exist");
        } else
        {
            while (graphIterator.hasNext())
            {
                int key = graphIterator.next().getKey();
                graphEdges.get(key).remove((Integer) node.hashCode());
            }
            graphEdges.remove(node.hashCode());
            nodeList.remove(node.hashCode(), node);
        }
    }

    @Override
    public Set<Edge> getNeighbors(Node node) {
        Set<Edge> neighbors = new HashSet<Edge>();
        if(!nodeList.containsKey(node.hashCode()) || !graphEdges.containsKey(node.hashCode()))
        {
            throw new NoSuchElementException("The node is not present in the graph");
        }
        List<Integer> x = graphEdges.get(node.hashCode());
        for(int i = 0; i < x.size(); i++)
        {
            Edge temp = new Edge(nodeList.get(x.get(i)));
            neighbors.add(temp);
        }
        return neighbors;
    }

    public String toString()
    {
        String friends = "";
        for(Integer k: nodeList.keySet())
        {
            Node node = nodeList.get(k);
            Set<Edge> connections = getNeighbors(node);
            friends += node.getName() + ":--->";
            for(Edge temp: connections)
            {
                friends += temp.friend.getName() + "\t";
            }
            friends+="\n";

        }
        return friends;
    }
}