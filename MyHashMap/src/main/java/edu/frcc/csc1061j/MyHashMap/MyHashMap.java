package edu.frcc.csc1061j.MyHashMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {
	private static final int INITIAL_NUM_BUCKETS = 4;

	private int size = 0;
	private double loadFactorThreshhold = 0.5;
	private LinkedList<Entry<K, V>>[] buckets;

	private static class Entry<K, V> implements Map.Entry<K, V> {
		K key;
		V value;

		public Entry(K key, V value) {
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

			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

	}

	public MyHashMap() {
		buckets = new LinkedList[INITIAL_NUM_BUCKETS];
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
		if (get(key) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				LinkedList<Entry<K, V>> bucket = buckets[i];
				for (Entry<K, V> entry : bucket) {
					if (entry.getKey().equals(value)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
		if (bucket == null) {
			bucket = new LinkedList<Entry<K, V>>();
			buckets[bucketIndex] = bucket;
		}
		for (Entry<K, V> entry : bucket) {
			if (entry.getKey().equals(key)) {
				V oldVal = entry.getValue();
				entry.value = value;
				return oldVal;
			}
		}
		bucket.add(new Entry<K, V>(key, value));
		size++;
		// checks if load factor has extended threshold
		// take action if it has rehash()
		return value;
	}

	// homework part 1
	private void rehash() {

	}

	@Override
	public V remove(Object key) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];
		if (bucket != null) {
			for (Entry<K, V> entry : bucket) {
				if (entry.getKey().equals(key)) {
					V value = entry.getValue();
					bucket.remove(entry);
					size--;
					return value;
				}
			}
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		size = 0;
		for (LinkedList<Entry<K, V>> bucket : buckets) {
			bucket = null;
		}

	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				LinkedList<Entry<K, V>> bucket = buckets[i];
				for (Entry<K, V> entry : bucket) {
					set.add(entry.getKey());

				}
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

		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				LinkedList<Entry<K, V>> bucket = buckets[i];
				for (Entry<K, V> entry : bucket) {
					set.add(entry);

				}
			}

		}
		return set;
	}
}
