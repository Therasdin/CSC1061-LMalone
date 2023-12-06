package demonstrations;

import java.util.ArrayList;
import java.util.function.BiConsumer;                                                                                                                                                                                                                                                                                                                                                                                                         
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class UnweightedGraphHelper<T> {
	protected Map<Vertex<T>, List<Vertex<T>>> adjVertices; // Adjacency vertex list

	public UnweightedGraphHelper() {
		adjVertices = new HashMap<>();
	}

	void addVertex(T label) {
		adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
	}
    
    void addVertex(Vertex<T> v) {
		adjVertices.putIfAbsent(v, new ArrayList<>());
	}

	void removeVertex(T label) {
		Vertex v = new Vertex(label);
		adjVertices.values().stream().map(e -> e.remove(v)).collect(Collectors.toList());
		adjVertices.remove(new Vertex(label));
	}

	void addEdge(T label1, T label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		List<Vertex<T>> v = adjVertices.get(v1);
		v.add(v2);
		adjVertices.get(v2).add(v1);
	}

	void removeEdge(T label1, T label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		List<Vertex<T>> eV1 = adjVertices.get(v1);
		List<Vertex<T>> eV2 = adjVertices.get(v2);
		if (eV1 != null)
			eV1.remove(v2);
		if (eV2 != null)
			eV2.remove(v1);
	}

	List<Vertex<T>> getAdjVertices(T label) {
		return adjVertices.get(new Vertex<T>(label));
	}
    
	List<Vertex<T>> getAdjVertices(Vertex<T> v) {
		return adjVertices.get(v);
	}
	
    public SearchTree dfs(T vertexName) {
        List<Vertex<T>> searchOrder = new ArrayList<>();
        Map<Vertex<T>,Vertex<T>> parent = new HashMap<>();
        Vertex<T> root = null;
        
        root = getVertex(vertexName);

        if (root != null){
            // Mark visited vertices
            Set<Vertex<T>> isVisited = new HashSet<>();

            // Recursively search
            dfs(root, parent, searchOrder, isVisited);
            return new SearchTree(root, parent, searchOrder);
        }else{
            return null;
        }
    }
    
    protected Vertex<T>getVertex(T vertexName){
        for(Vertex<T> e : adjVertices.keySet())
            if(e.label.equals(vertexName)){
                return e;
             }
       return null;
    }
    
    protected Set<T> getVertices(){
        Set<T> vertices = new LinkedHashSet<>();
        for(Vertex<T>  v : adjVertices.keySet()){
            vertices.add(v.label);
        }
        return vertices;
    }
            

    private void dfs(Vertex<T> v,  Map<Vertex<T>,Vertex<T>> parent, List<Vertex<T>> searchOrder, Set<Vertex<T>> isVisited) {
        searchOrder.add(v);
        isVisited.add(v);
        for (Vertex<T> w : adjVertices.get(v)){
            if (!isVisited.contains(w)){
                parent.putIfAbsent(w,v);   
                dfs(w, parent, searchOrder, isVisited);
            }
        }
    }
    
    public int getSize(){
        return adjVertices.size();
    }

    /** Tree inner class inside the AbstractGraph class */
    /** To be discussed in Section 28.6 */
    public class SearchTree {
      private Vertex<T> root; // The root of the tree
      private Map<Vertex<T>, Vertex<T>> parent; // vertex and parent of each vertex <vertex,parent>
      private List<Vertex<T>> searchOrder; // Store the search order

      /** Construct a tree with root, parent, and searchOrder */
      public SearchTree( Vertex<T> root, Map<Vertex<T>, Vertex<T>> parent, List<Vertex<T>> searchOrder) {
        this.root = root;
        this.parent = parent;
        this.searchOrder = searchOrder;
      }

      /** Return the root of the tree */
      public T getRoot() {
        return root.label;
      }

      /** Return the parent of vertex v */
      public T getParent(Vertex<T> v) {
        return parent.get(v).label;
      }

      /** Return an array representing search order */
      public List<T> getSearchOrder() {
        List<T> order = new ArrayList();
        for (int i = 0; i < searchOrder.size(); i++)
            order.add(searchOrder.get(i).label);
          
        return order;
      }

      /** Return number of vertices found */
      public int getNumberOfVerticesFound() {
        return searchOrder.size();
      }

      /** Return the path of vertices from a vertex to the root */
      private List<Vertex<T>> getPath(Vertex<T> indx) {
        ArrayList<Vertex<T>> path = new ArrayList<>();
  
        do{
            path.add(indx);
            indx = parent.get(indx);
        }while (indx != null);
        return path;
      }

      /** Print a path from the root to vertex v */
      public void printPath(T vertexName) {
        Vertex<T> vtx = null;
        
        vtx = getVertex(vertexName);
        
        if (vtx != null){
            List<Vertex<T>> path = getPath(vtx);
            System.out.print("A path from " + root.label + " to " +
              vtx.label + ": ");
            for (int i = path.size() - 1; i >= 0; i--)
              System.out.print(path.get(i).label + " ");
            System.out.println();
        }
      }

      /** Print the whole tree */
      public void printTree() {
        System.out.println("Root is: " + root.label);
        System.out.print("Edges: ");
        BiConsumer<Vertex<T>, Vertex<T>> biConsumer = (x,y)-> {
            System.out.print("(" + y.label + ", " + x.label + ") ");
        };
        
        parent.forEach(biConsumer); //System.out.print("(parent of " + x.label + ", is " + y.label + ") ");

        System.out.println();
      }
    }// end class SearchTree
}//end class UnweightedGraphHelper

class Vertex<V> {
    V label;

    Vertex(V label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex) {
            Vertex<V> v = (Vertex<V>) o;
            return this.label.equals(v.label);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }
}