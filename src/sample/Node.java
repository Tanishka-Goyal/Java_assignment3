package sample;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Represents a vertex in the graph with its adjacency list of edges.
 *
 * @version 2.0, April 2022
 * @author Saber Elsayed
 */
class Node implements NodeInterface {

    //id
    private Integer id;
    //person name
    private String name;

    //date of birth
    private LocalDate dateOB;
    //suburb a person lives at
    private String suburb;

    //contains a list of all firends of a person object
    protected HashMap<Integer, Edge> adj = new HashMap<Integer, Edge>();

    /**
     * Construct a new vertex in the graph with the supplied id, name, DOB and
     * suburb.
     *
     */
    public Node(Integer id, String name, LocalDate dob, String suburb) {

        this.id = id;
        this.name = name;
        this.dateOB = dob;
        this.suburb = suburb;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public LocalDate getDateOB() {
        return this.dateOB;
    }

    @Override
    public String getSuburb() {
        return this.suburb;
    }

    public Integer getID() {
        return this.id;
    }

    public String toString() {
        String node = "{id = " + this.id +
                ", name = " + this.name +
                ", DOB = " + this.dateOB +
                ", suburb = " + this.suburb +
                "}";
        return node;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) id;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (suburb == null ? 0 : suburb.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object n) {
        if (this == n) return true;
        if (n == null) return false;
        if (this.getClass() != n.getClass()) return false;
        Node node = (Node) n;
        return id == node.id && (name.equals(node.name));
    }
}
