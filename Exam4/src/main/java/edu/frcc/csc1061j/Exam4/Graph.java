package edu.frcc.csc1061j.Exam4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Graph<E> {
	public List<Vertex> vertices = new ArrayList<>();
	public List<Vertex> discovered = new ArrayList<>();
	public List<Vertex> bfsDiscovered = new ArrayList<>();
	
			
	public class Vertex {
		private E elem;
		private List<Edge> neighbors = new ArrayList<>();
		
		public Vertex (E elem) {
			this.elem = elem;
		}

		public E getKey() {
			return elem;
		}
		
		@Override
		public boolean equals(Object other) {
			if (!(other instanceof Graph.Vertex))
				return false;
			
			if (elem.equals(((Vertex)other).elem)) {
				return true;
			}
			return false;		
		}
		
		@Override 
		public String toString() {
			return elem.toString();
		}
	}

	
	private class Edge implements Comparable<Edge> {
		private Vertex s;
		private Vertex d;
		private int weight;

		public Edge(Vertex s, Vertex d, int weight) {
			this.s = s;
			this.d = d;
			this.weight = weight;
		}

		public boolean equals(Object edge) {
			return s.equals(((Edge) edge).s) && d.equals(((Edge) edge).d);
		}

		@Override
		public int compareTo(Graph<E>.Edge o) {
			return (int) (weight - o.weight);
		}
	}

	public Graph(List<Vertex> vertices) {
		for (Vertex vertex : vertices) {
			addVertex(new Vertex(vertex.getKey()));
		}
	}
	
	public Graph(List<E> vertices, E[][] edges) {
		for (E ver : vertices) {
			addVertex(new Vertex(ver));
		}
		createAdjacencyLists(edges);
	}

	public boolean addVertex(Vertex vertex) {
		if (!vertices.contains(vertex)) {
			vertices.add(vertex);
			return true;
		} else {
			return false;
		}

	}

	public boolean addEdge(Edge edge) {
		
		List<Edge> neighbors = edge.s.neighbors;
		if (!neighbors.contains(edge)) {
			neighbors.add(edge);
			return true;
		} else {
			return false;
		}
	}

	private Vertex findVertex(E key) {
		for(Vertex v : vertices) {
			if (v.elem.equals(key)) {
				return v;
			}
		}
		return null;
	}
	private void createAdjacencyLists(E[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			addEdge(new Edge(findVertex(edges[i][0]), findVertex(edges[i][1]), (int)edges[i][2]));
		}
	}

	public void printEdges() {
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print("Vertex: " + vertices.get(i).toString() + ":");
			List<Edge> neighbors = vertices.get(i).neighbors;
			for (Edge edge : neighbors) {
				System.out.print("(" + edge.s + ", " + edge.d + ", " + edge.weight + ")");
			}
			System.out.println();
		}
	}

	public List<Vertex> getChildNodes(Vertex vertex) {
		List<Vertex> childNodes = new ArrayList<>();
		List<Edge> neighbors = vertex.neighbors;
		for (Edge edge : neighbors) {
			childNodes.add(edge.d);
		}
		return childNodes;
	}
	
	/* TODO: Implement the DFS algorithm for a graph either recursively
	** or iteratively using a stack. It should return a list of all the 
	** vertices in the pre-order depth-first traversal.
	*/
	public List<Vertex> dfs(Vertex root) {
		discovered.add(root); //
		for (Edge E: root.neighbors){
			if (!discovered.contains(E.d)) {
				dfs (E.d);
			}
		}
		return discovered;
	}

	/* TODO: Implement the BFS algorithm for a graph. It should return a list 
	** of all the vertices in the breadth-first traversal.
	*/
	@SuppressWarnings("unchecked")
	public List<E> bfs(Vertex root) {
	    bfsDiscovered.add(root);
	    Queue<Vertex> queue = new LinkedList<Vertex>();
	    queue.add(root);
	    
	    while (!queue.isEmpty()) {
	        Vertex curr = queue.remove();
	        List<Vertex> neighbors = getChildNodes(curr);
	        
	        for (Vertex neighbor : neighbors) {
	            if (!bfsDiscovered.contains(neighbor)) {
	                bfsDiscovered.add(neighbor);
	                queue.add(neighbor);
	            }
	        }
	    }
	    
	    return (List<E>) bfsDiscovered;
	}
	

	/* TODO: Create a spanning tree using Kruskal's Algorithm and return it. 
	** The spanning tree will be a new graph
	*/
	public Graph<E> findMinimumSpanningTree() {
	    // Create a new graph for the minimum spanning tree
	    Graph<E> mst = new Graph<E>(new ArrayList<Vertex>());
	    // Create a priority queue to hold the edges
	    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

	    // Add all edges to the priority queue
	    for (Vertex v : vertices) {
	        for (Edge e : v.neighbors) {
	            pq.offer(e);
	        }
	    }

	    // Create a list to keep track of visited vertices
	    List<Vertex> visited = new ArrayList<Vertex>();

	    // Perform BFS traversal starting from the first vertex
	    bfs(vertices.get(0));

	    // Iterate through the discovered vertices in BFS order
	    for (Vertex v : bfsDiscovered) {
	        // Mark the vertex as visited
	        visited.add(v);

	        // Get the edges for the current vertex
	        List<Edge> edges = v.neighbors;
	        for (Edge e : edges) {
	            Vertex u = e.d;
	            // If the destination vertex has not been visited, add the edge to the minimum spanning tree
	            if (!visited.contains(u)) {
	                // Add the vertices to the minimum spanning tree
	                mst.addVertex(u);
	                mst.addVertex(e.s);
	                // Add the edge to the minimum spanning tree
	                mst.addEdge(new Edge(mst.findVertex(e.s.elem), mst.findVertex(u.elem), e.weight));
	            }
	        }
	    }

	    return mst;
	}

}
