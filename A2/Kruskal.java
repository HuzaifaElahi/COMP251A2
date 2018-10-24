package A2;
import java.util.*;

public class Kruskal{

	//TODO 
    public static WGraph kruskal(WGraph g){
    	WGraph mst = new WGraph();
        ArrayList<Edge> edges = g.listOfEdgesSorted();
        DisjointSets p = new DisjointSets(g.getNbNodes());
   
        for(Edge e : edges) {
        	int nodeA = e.nodes[0];
        	int nodeB = e.nodes[1];
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
