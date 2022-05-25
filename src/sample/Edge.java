package sample;

public class Edge {
    protected Node friend;

    public Edge(Node friend)
    {
        this.friend = friend;
    }

    public String toString() {
        String node = "{" +
                this.friend.getID()+ ", " +
                this.friend.getName() + ", " +
                this.friend.getDateOB() + ", " +
                this.friend.getSuburb()+
                "}";
        return node;
    }
}
