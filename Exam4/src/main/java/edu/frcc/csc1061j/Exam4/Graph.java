package edu.frcc.csc1061j.Exam4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;

public class Graph<E> {
	public List<Vertex> vertices = new ArrayList<>();
	public List<Vertex> discovered = new ArrayList<>();
	public List<Vertex> bfsDiscovered = new ArrayList<>();

	public class Vertex {
		private E elem;
		private List<Edge> neighbors = new ArrayList<>();

		public Vertex(E elem) {
			this.elem = elem;
		}

		public E getKey() {
			return elem;
		}

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof Graph.Vertex))
				return false;

			if (elem.equals(((Vertex) other).elem)) {
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
		for (Vertex v : vertices) {
			if (v.elem.equals(key)) {
				return v;
			}
		}
		return null;
	}

	private void createAdjacencyLists(E[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			addEdge(new Edge(findVertex(edges[i][0]), findVertex(edges[i][1]), (int) edges[i][2]));
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

	/*
	 * TODO: Implement the DFS algorithm for a graph either recursively or
	 * iteratively using a stack. It should return a list of all the vertices in the
	 * pre-order depth-first traversal.
	 */
	public List<Vertex> dfs(Vertex root) {
		discovered.add(root); //
		for (Edge E : root.neighbors) {
			if (!discovered.contains(E.d)) {
				dfs(E.d);
			}
		}
		return discovered;
	}

	/*
	 * TODO: Implement the BFS algorithm for a graph. It should return a list of all
	 * the vertices in the breadth-first traversal.
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

	/*
	 * TODO: Create a spanning tree using Kruskal's Algorithm and return it. The
	 * spanning tree will be a new graph
	 */
	public Graph<E> findMinimumSpanningTree() {
		// Sort all the edges in non-decreasing order of their weight
		//int[][] edges = {};
		int totalWeight = 0;
		List<Edge> sortedEdges = new ArrayList<>();
		List<Vertex> connections = new ArrayList<Vertex>();
		for(Vertex v: vertices) {
			for (Edge e: v.neighbors) {
				sortedEdges.add(e);
			}
		}
		Collections.sort(sortedEdges);
		//spanningTree.printEdges();
		//System.out.println(spanningTree.vertices.get(0).neighbors);
		for (Vertex v: vertices) {
			v.neighbors.clear();
		}
		
		Graph<E> spanningTree = new Graph<E>(vertices);
		for (Edge e: sortedEdges) {
			discovered.clear();
			connections.clear();
			connections = spanningTree.dfs(e.s);
//			System.out.print("Source " + e.s + ": ");
//			for (Vertex v: connections) {
//			System.out.print(v + " ");
//		}
//			System.out.println(" ");
//			System.out.println(connections.size());
			if (!connections.contains(e.d)) {
				spanningTree.addEdge(e);
				Edge newEdge = new Edge(spanningTree.findVertex(e.s.elem), 
						spanningTree.findVertex(e.d.elem), e.weight);
				spanningTree.addEdge(newEdge);
				//System.out.println(e.s.elem + " " + e.d.elem + " " + e.weight );
				 totalWeight = totalWeight + e.weight;
			}
		}
		//System.out.println(connections.get(5));
		totalWeight = totalWeight/2;
		//System.out.println(totalWeight);
		/*
		 * for (Vertex vertex : vertices) { edges.addAll(vertex.neighbors); }
		 * edges.sort(new Comparator<Edge>() {
		 * 
		 * @Override public int compare(Edge o1, Edge o2) { return o1.weight -
		 * o2.weight; } });
		 */
		return spanningTree;
	}
}
