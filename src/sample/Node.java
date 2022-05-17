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
        int hash = 0;
        hash = (id << 8) + (name == null ? 0 : name.length());
        hash = (hash << 8) + (suburb == null ? 0 : suburb.length());
        return hash;
    }

    @Override
    public boolean equals(Object n) {
        if (n == null)
        {
            throw new NullPointerException("Object is empty.");
        }
        else if (n.getClass() != this.getClass())
        {
            throw new IllegalArgumentException("Object entered is not a node.");
        }

        Node node = (Node) n;

        return this.hashCode() == node.hashCode();
    }
}
