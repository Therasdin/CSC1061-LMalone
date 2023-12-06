package demonstrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 *
 * @author bobgi
 */
public class WeightedGraphHelper<T> extends UnweightedGraphHelper<T>{
	// note: adjacency vertex list is managed by super class
    protected Map<Vertex<T>, List<WeightedEdge<T>>> neighbors; // adjaceny edge list
    
    WeightedGraphHelper(){
        super();
        neighbors = new LinkedHashMap<>();
    }
    
    void addVertex(T label) {
        Vertex<T> newVertex = new Vertex(label);
        super.addVertex(newVertex);
        neighbors.putIfAbsent(newVertex, new ArrayList<WeightedEdge<T>>());
    }
    
    public boolean addEdge(T l1, T l2, int weight){
        super.addEdge(l1, l2);
        Vertex<T> u = new Vertex<T>(l1);
        Vertex<T> v = new Vertex<T>(l2);
        return addEdge(new WeightedEdge(u,v,weight));
    }
    
    private boolean addEdge(WeightedEdge<T> e){
        if(neighbors.get(e.u).indexOf(e) == -1){
            neighbors.get(e.u).add(e);
            neighbors.get(e.v).add(e);
            return true;
        }else{
            return false;
        }
    }
    
    WeightedEdge<T> getEdge(Vertex<T> u, Vertex<T> v){
        for(WeightedEdge e : neighbors.get(u)){
            if((e.u.equals(u) && e.v.equals(v))||(e.u.equals(v) && e.v.equals(u)))
                return e;
        }
        return null;
    }
       
      /** Get a minimum spanning tree rooted at vertex 0 */
    public MST getMinimumSpanningTree(T label) {
        Vertex<T> e;
        e = getVertex(label);
        if (e != null)
                return getMinimumSpanningTree(e);
        else
            return null;
    }

    /** Get a minimum spanning tree rooted at a specified vertex 
     using Prim's Algorithm 
     */
    public MST getMinimumSpanningTree (Vertex<T> startingVertex) {
        // startingVertex is the root        
        Map<Vertex<T>, Vertex<T>> parent = new LinkedHashMap<>(); // Parent of a vertex
        double totalWeight = 0.0; // Total weight of the tree thus far

        List<Vertex<T>> T = new ArrayList<>(); // set of vertices already processed
        Vertex<T> smallestCost;
        Vertex<T> u = startingVertex; // Vertex to be determined 
        T.add(u);
        // Find smallest cost of u in V - T
        while (T.size() < getSize()){
   
            //
            // algorithm to be completed by student
            //
                        
            // add u to T if it is the smallest cost
        	
            if (u != null){
                T.add(v); //add a new vertex to T
                parent.put(v, u);
            }else
                break;
            totalWeight += getEdge(u,v).weight;                                  
        }
        return new MST(startingVertex, parent, T, totalWeight);
    }
    
    // class MST is an inner class in WeightedGraphHelper
    public class MST<T> extends UnweightedGraphHelper<T>.SearchTree{
        private double totalWeight;
        
        public MST(Vertex<T> root, Map<Vertex<T>, Vertex<T>> parent, List<Vertex<T>> searchOrder, double totalWeight) {
            super(root, parent, searchOrder);
            this.totalWeight = totalWeight;
        }
        
        public double getTotalWeight(){
        return totalWeight;
        }
    } //end class MST

    // Dijkstra's Single-Source Shortest-Path Algorithm
    public ShortestPathTree getShortestPath(T sourceVertex){
        // startingVertex is the root        
        Map<Vertex<T>, Vertex<T>> parent = new LinkedHashMap<>(); // Parent of a vertex
        Map<Vertex<T>,Double> cost = new LinkedHashMap<>();
        List<Vertex<T>> T = new ArrayList<>(); // set of vertices already processed
        Vertex<T> u;
        Vertex<T> s; // Vertex to be determined 
//        T.add(s);
        
        for(Vertex<T> e : adjVertices.keySet())
            cost.put(e,Double.POSITIVE_INFINITY);
        
        s = getVertex(sourceVertex);
        cost.put(s,0.0);
        parent.put(s, null);
        
        // Find smallest cost of u in V - T
        u = s;
        while (T.size() < getSize()){
            double weight = 0;
            double currentMinCost = Double.POSITIVE_INFINITY;

            // get vertex with smallest cost
            for (Vertex<T> v : cost.keySet()) {
                if(!T.contains(v) && cost.get(v) < currentMinCost){
                    weight = cost.get(v);
                    if ( weight < currentMinCost) {
                      currentMinCost = weight;
                      u = v;
                    }
                }
            }
            T.add(u); //add a new vertex to T
            
            // adjust costs
            for (Vertex<T> v : adjVertices.get(u)) {
                if(!T.contains(v) && (cost.get(v) > cost.get(u) + getEdge(u,v).weight)){
                    cost.put(v, cost.get(u) + getEdge(u,v).weight);
                    parent.put(v, u);
                }  
            }
        }
        return new ShortestPathTree(getVertex(sourceVertex), parent, T, cost);
    }
        
    // class ShortestPathTree is an inner class in WeightedGraphHelper
    public class ShortestPathTree extends UnweightedGraphHelper<T>.SearchTree{
        private Map<Vertex<T>,Double> cost;
        
        public ShortestPathTree(Vertex<T> source, Map<Vertex<T>, Vertex<T>> parent, List<Vertex<T>> searchOrder, Map<Vertex<T>,Double> cost){
            super(source, parent, searchOrder);
            this.cost = cost;
        }
        
        public double getCost(T v){
            return cost.get(v);
        }
        
    /** Print paths from all vertices to the source */
    public void printAllPaths() {
      System.out.println("All shortest paths from " + getRoot() + " are:");
      for (Vertex<T> e : adjVertices.keySet()) {
        printPath(e.label); // Print a path from i to the source
        System.out.println("(cost: " + cost.get(e) + ")"); // Path cost
      }
    }
  } //end class ShortestPathTree
      
    class WeightedEdge<V> implements Comparable<WeightedEdge<V>>{
        Vertex<V> u;
        Vertex<V> v;
        public int weight;
        
        public WeightedEdge(Vertex<V> u, Vertex<V> v, int weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
        
        public boolean equals(WeightedEdge<V> rhs){
            return (this.u.equals(rhs.u) && this.v.equals(rhs.v));
        }
        
        @Override
        public int compareTo(WeightedEdge<V> rhs){
            if(weight > rhs.weight)
                return 1;
            else if (weight == rhs.weight)
                return 0;
            else
                return -1;
        }
    } // end class WeightedEdge
    
} // end class WeightedGraphHelper
