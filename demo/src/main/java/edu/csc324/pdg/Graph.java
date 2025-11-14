package edu.csc324.pdg;
import java.util.ArrayList;
import java.util.HashMap;

/*
* Graph class implemented with hashmap
*/
public class Graph {
    private HashMap<Agent, ArrayList<Agent>> adjacency_list;

    public Graph() {
        this.adjacency_list = new HashMap<>();
    }

    public void addNode(Agent agent, ArrayList<Agent> connections) {
        this.adjacency_list.put(agent, connections);

        for (Agent neighbor : connections) {
            this.adjacency_list.get(neighbor).add(agent);
        }
    }

    public void removeNode(Agent agent) throws Exception {
        if (!this.adjacency_list.containsKey(agent)) {
            throw new Exception("Can't remove node. Node not found in adjacency_list.");
        }

        for (Agent neighbor : getNeighbors(agent)) {
            this.adjacency_list.get(neighbor).remove(agent);
        }

        this.adjacency_list.remove(agent);
    }

    public ArrayList getNeighbors(Agent agent) throws Exception {
        if (!this.adjacency_list.containsKey(agent)) {
            throw new Exception("Can't remove node. Node not found in adjacency_list.");
        }

        return this.adjacency_list.get(agent);
    }
}