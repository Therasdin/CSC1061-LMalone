import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

class GraphHelper {
	private Map<Vertex, List<Vertex>> adjVertices;

	public GraphHelper() {
		adjVertices = new HashMap<>();
	}

	void addVertex(String label) {
		adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
	}

	void removeVertex(String label) {
		Vertex v = new Vertex(label);
		adjVertices.values().stream().map(e -> e.remove(v)).collect(Collectors.toList());
		adjVertices.remove(new Vertex(label));
	}

	void addEdge(String label1, String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		List<Vertex> v = adjVertices.get(v1);
		v.add(v2);
		adjVertices.get(v2).add(v1);
	}

	void removeEdge(String label1, String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		List<Vertex> eV1 = adjVertices.get(v1);
		List<Vertex> eV2 = adjVertices.get(v2);
		if (eV1 != null)
			eV1.remove(v2);
		if (eV2 != null)
			eV2.remove(v1);
	}

	List<String> getAdjVertices(String label) {
        List<String> v = new LinkedList<String>();
        
		for (Vertex e : adjVertices.get(new Vertex(label)))
                v.add(e.label);
        
        return v;
	}
       
    GraphIterator iterator(){
        return new GraphIterator();
    }

public class GraphIterator implements Iterator<List<String>>{
    Vector<String> vertices = new Vector<>();
    
    GraphIterator(){
        for (Vertex v : adjVertices.keySet())
            vertices.add(v.label);
    }
    public boolean hasNext(){
        if (vertices.size() > 0 )
            return true;
        else
            return false;
    }
    
    public List<String> next(){
        String f = vertices.remove(0); 
        List<String> l = getAdjVertices(f);
        l.add(0, "Vertex[" + f + "]");
        return l;
    }
}

class Vertex {
	String label;

	Vertex(String label) {
		this.label = label;
	}
    
	@Override
	public boolean equals(Object o) {
		if (o instanceof Vertex) {
			Vertex v = (Vertex) o;
			return this.label.equals(v.label);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return label.hashCode();
	}

}
}