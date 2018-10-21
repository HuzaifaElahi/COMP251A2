package A2;
import java.util.*;

public class Kruskal{

	//TODO 
    public static WGraph kruskal(WGraph g){
    	WGraph mst = new WGraph();
        ArrayList<Edge> edges = g.listOfEdgesSorted();
      //  ArrayList<ArrayList<Integer>> sets = null;
        DisjointSets p = new DisjointSets(g.getNbNodes());
      /*  for(int i = 0; i < g.getNbNodes() ; i++) {
            ArrayList<Integer> vertices = null;
            vertices.add(i);
        	sets.add(i, vertices);
        }*/
        for(Edge e : edges) {
        	int nodeA = e.nodes[0];
        	int nodeB = e.nodes[1];
        	int weight = e.weight;
        	if(IsSafe(p, e)) {
        		p.union(nodeA, nodeB);
        		mst.addEdge(e);
        	}
        }
        
        return mst;
    }

    //TODO Fill this method (The statement return 0 is here only to compile) 
    public static Boolean IsSafe(DisjointSets p, Edge e){
    	int nodeA = e.nodes[0];
    	int nodeB = e.nodes[1];
    	if(p.find(nodeA) == p.find(nodeB)) {
    		return false;
    	}
        return true;    
    }

    public static void main(String[] args){

        String file = args[0];
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);

   } 
}
