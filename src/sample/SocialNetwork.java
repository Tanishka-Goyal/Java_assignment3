package sample;

import java.util.List;

/**
 * represents accounts and their relationship as a graph; 
 *
 * @author Saber Elsayed
 * @version 2, April 2022
 */
public class SocialNetwork implements SocialNetworkInterface {

    protected Graph sn;

    /**
     * constructs a social network analyser object by reading data files
     */
    public SocialNetwork() {
        sn = new Graph();

    }

    /**
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        SocialNetwork driver = new SocialNetwork();
        System.out.println(driver.sn);
    }

    @Override
    public void processFile() {

    }

    @Override
    public List<Node> suggestFriends(Node currentPerson) {
        return null;
    }

    @Override
    public String remindBDEvents(Node currentPerson) {
        return null;
    }

    @Override
    public List<String> getMutualFriends(Node x, Node y) {
        return null;
    }
}
