package homework.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphUsingAdjList {

    HashMap<Integer, ArrayList<Integer>> hashMap;
    int numberOfVertices;

    public GraphUsingAdjList(){
        hashMap = new HashMap<>();
        numberOfVertices = 0;
    }

    public void addVertex(int vertex){

        if (!hashMap.containsKey(vertex)) {
            hashMap.put(vertex, new ArrayList<>());
            numberOfVertices++;
        } else {
            System.out.println("Vertex: "+vertex+ " already added");
        }
    }

    public void addEdge(int vertex1, int vertex2){

        if (hashMap.containsKey(vertex1) && hashMap.containsKey(vertex2)){
            hashMap.get(vertex1).add(vertex2);
            hashMap.get(vertex2).add(vertex1);
        }
    }

    public void showConnections(){


        for (Map.Entry<Integer, ArrayList<Integer>> entry : hashMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        GraphUsingAdjList graph = new GraphUsingAdjList();
        graph.addVertex(5);
        graph.addVertex(54);
        graph.addVertex(44);
        graph.addEdge(5,54);
        graph.addEdge(5,44);
        graph.showConnections();
    }
}
