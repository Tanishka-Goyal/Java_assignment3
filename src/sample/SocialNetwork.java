package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

/**
 * represents accounts and their relationship as a graph; 
 *
 * @author Saber Elsayed
 * @version 2, April 2022
 */
public class SocialNetwork implements SocialNetworkInterface {

    protected Graph sn;
    protected HashMap<Integer, List<Integer>> connectNode = new HashMap<>();

    /**
     * constructs a social network analyser object by reading data files
     */
    public SocialNetwork() {
        sn = new Graph();
        processFile();

    }

    /**
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        SocialNetwork driver = new SocialNetwork();
//        System.out.println(driver.sn);
    }

    @Override
    public void processFile()
    {
        try
        {
            Scanner scanner = new Scanner(new File("src/sample/data.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] temp = line.split(", ");
                String[] data = temp[0].split("\\s+");
                Node node = new Node(Integer.parseInt(data[0]), data[1]+data[2],
                        LocalDate.parse(data[3]), temp[1]);
                sn.addNode(Integer.parseInt(data[0]), data[1]+" "+data[2],
                        LocalDate.parse(data[3]), temp[1]);
                List<Integer> nodes = new ArrayList<>();//initialising array for storing connections
                for (int i = 2; i < temp.length; i++)
                {
                    nodes.add(Integer.parseInt(temp[i]));// adding connections to the nodes variable
                }
                connectNode.put(node.hashCode(),nodes);// adding node and connection to the hashmap

            }
        }catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        createEdges();
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

    public void createEdges()
    {
        for(Integer k: connectNode.keySet())
        {
            Node n1 = null;
            List<Integer> nodes = connectNode.get(k);
            for(int i = 0; i<nodes.size(); i++)
            {
                Iterator<Map.Entry<Integer, Node>> listIterator = sn.nodeList.entrySet().iterator();
                while (listIterator.hasNext())
                {
                    Node n = listIterator.next().getValue();
                    if(k == n.getID())
                    {
                        n1 = n;
                    }
                    if(nodes.get(i) == n.getID() && n1!=null)
                    {
                        Node n2 = n;
                        sn.addEdge(n1,n2);
                    }
                }
            }
        }

    }


}
