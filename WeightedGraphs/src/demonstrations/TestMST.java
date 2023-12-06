package demonstrations;

/**
 *
 * @author bobgi
 */
public class TestMST {

  public static void main(String[] args)throws Exception {
//     
//    WeightedGraphHelper<String> graph = createGraph();
//    
//    WeightedGraphHelper<String>.MST<String> tree = graph.getMinimumSpanningTree("Chicago");
//    tree.printPath("Atlanta");
    
    System.out.printf("\nTotal weight is %f\n\n", tree.getTotalWeight());
    tree.printTree();

    WeightedGraphHelper<String>.ShortestPathTree tree2 = graph.getShortestPath("Chicago");
    tree2.printPath("Atlanta");
    }
  
	static WeightedGraphHelper createGraph() throws Exception {
    
		WeightedGraphHelper<String> graph = new WeightedGraphHelper();
		graph.addVertex("New York");
		graph.addVertex("Boston");
		graph.addVertex("Chicago");
		graph.addVertex("Kansas City");
        graph.addVertex("Denver");
		graph.addVertex("Atlanta");
        graph.addVertex("San Francisco");
        graph.addVertex("Los Angeles");
        graph.addVertex("Seattle");
        graph.addVertex("Dallas");
        graph.addVertex("Houston");
        graph.addVertex("Miami");
		graph.addEdge("New York", "Boston", 214);
		graph.addEdge("New York", "Chicago", 787);
        graph.addEdge("New York", "Kansas City", 1260);
        graph.addEdge("New York", "Atlanta", 888);
        graph.addEdge("Boston", "Chicago", 983);
        graph.addEdge("Chicago", "Kansas City", 533);
        graph.addEdge("Chicago", "Denver", 1003);
        graph.addEdge("Chicago", "Seattle", 2097);
        graph.addEdge("Seattle", "San Francisco", 807);
        graph.addEdge("Seattle", "Denver", 1331);
        graph.addEdge("San Francisco", "Denver", 1267);
        graph.addEdge("San Francisco", "Los Angeles", 381);
        graph.addEdge("Los Angeles", "Denver", 1015);
        graph.addEdge("Los Angeles", "Dallas", 1435);
        graph.addEdge("Dallas", "Atlanta", 781);
        graph.addEdge("Dallas", "Houston", 239);
        graph.addEdge("Dallas", "Kansas City", 496);
        graph.addEdge("Kansas City", "Atlanta", 864);
        graph.addEdge("Kansas City", "Dallas", 496);
        graph.addEdge("Miami", "Houston", 1187);
        graph.addEdge("Miami", "Atlanta", 661);
		return graph;
	}}