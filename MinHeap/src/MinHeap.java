import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinHeap<E extends Comparable<E>> {
	private List<E> heapArr;
	private Map<E, Integer> indexMap;
	
	public MinHeap() {
		heapArr = new ArrayList<E>();
		indexMap = new HashMap<E, Integer> ();
	}
	
		public boolean isEmpty() {
			return heapArr.size() == 0;
		}
		public int size(){
			return heapArr.size();
		}
		public List<E> getHeap(){
			return heapArr;
		}
		public boolean contains(E elem) {
			return indexMap.containsKey(elem);
		}
		public int leftChild(E Entry) {
			return(2 * indexMap.get(Entry)) + 1;
		}
		public int rightChild(E Entry) {
			return(2 * indexMap.get(Entry)) + 2;
		}
		public int leftChild(int pos) {
			int child = (2 * pos) + 1;
			return child >= heapArr.size() ? -1: child;
		}
		public int rightChild(int pos) {
			int child = (2 * pos) + 2;
			return child >= heapArr.size() ? -1: child;
		}
		public int parent(int pos) {
			return pos == 0 ? -1:(pos-1)/2; 
		}
		public boolean isLeafNode(int pos) {
			return (pos >= heapArr.size()/2) && (pos < heapArr.size());
		}
		public int add(E entry) {
			heapArr.add(entry);
			return swimUp(heapArr.size() - 1);
			
		}
		private int swimUp (int current) {
			int parent = parent(current);
			E parentEntry = heapArr.get(parent);
			while (current != 0 &&(heapArr.get(current).compareTo(parentEntry) < 0))
					{
				swap(current, parent);
				current = parent;
				parent = parent(current);
				parentEntry = heapArr.get(parent);
					
			}
			return current;
		}
			public void swap (int pos1, int pos2) {
				E temp = heapArr.get(pos1);
				heapArr.set(pos1, heapArr.get(pos2));
				heapArr.set(pos2, temp);
			}
			public E remove() {
				return remove(0);
			}
			public E remove (int pos) {
				swap(pos, heapArr.size()-1);
				E removedEntry = heapArr.remove(heapArr.size()-1);
				if (heapArr.size() > 0) {
					shiftDown(pos);
				}
				return removedEntry;
			}
			private int shiftDown (int current) {
				int lchild = leftChild(current); 
				int rchild = rightChild(current); 
				
				E
			}
		}


