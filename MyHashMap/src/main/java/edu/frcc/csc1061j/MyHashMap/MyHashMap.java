package edu.frcc.csc1061j.MyHashMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {
	
	private static final int INITIAL_NUM_BUCKETS = 4; 
	private List<Entry<K,V>> [] buckets;
	private int size = 0;
	private double loadFactorThreshold = 0.5;
	
	public class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;
		
		public Entry (K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			this.value = value;
			return value;
		}
		
	}
	
	public MyHashMap() {
		buckets = new LinkedList [INITIAL_NUM_BUCKETS];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<Entry<K, V>>();
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		if (findEntry(key) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				List<Entry<K,V>> bucket = buckets[i];
				for (Entry<K,V> entry: bucket) {
					if (entry.getValue().equals(value)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		Entry<K,V> entry = findEntry(key);
		if (entry != null) {
			return entry.getValue();
		}
		return null;
	}

	private Entry<K,V> findEntry(Object key) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		List<Entry<K, V>> bucket = buckets[bucketIndex];
		for (Entry<K, V> entry : bucket) {
			if (entry.getKey().equals(key)) {
				return entry;
			}
		}
		return null;
	}
	
	@Override
	public V put(K key, V value) {
		Entry<K,V> entry = findEntry(key);
		if (entry != null) {
			V oldValue = entry.getValue();
			entry.value = value;
			return oldValue;
		}
		
		// If key was not found, insert key
		// First check that List exists.
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		if (buckets[bucketIndex] == null) {
			buckets[bucketIndex] = new LinkedList<Entry<K,V>>();
		}
		buckets[bucketIndex].add(new Entry<K,V>(key, value));
		size++;
		
		// Compute the Load Factor and compare to Threshold. If exceeded
		// threshold, rehash (Homework)
		
		
		return value;
	}

	private void rehash() {
		
	}
	
	@Override
	public V remove(Object key) {
		Entry<K,V> entry = findEntry(key);
		if (entry != null) {
				V oldValue = entry.getValue();
				int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
				buckets[bucketIndex].remove(entry);
				size--;
				return oldValue;
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		Set<? extends Map.Entry<? extends K, ? extends V>> entries = m.entrySet();
		for (Map.Entry<?extends K, ? extends V> entry : entries) {
			put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void clear() {
		size = 0;
		for (List<Entry<K,V>> bucket : buckets) {
			bucket = null;
		}
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		for(List<Entry<K,V>> bucket : buckets) {
			for (Entry<K,V> entry : bucket) {
				set.add(entry.getKey());
			}
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K,V>> set = new HashSet<Map.Entry<K,V>>();
		for(List<Entry<K,V>> bucket : buckets) {
			for (Entry<K,V> entry : bucket) {
				set.add(entry);
			}
		}
		return set;
	}
	
	
}
