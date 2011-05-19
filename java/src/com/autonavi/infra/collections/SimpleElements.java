package com.autonavi.infra.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final public class SimpleElements<K, V> implements Elements<K, V> {

	private SimpleElements(Map<K,V> kvs) {
		this.kvs = Collections.unmodifiableMap(kvs);
		vs = Collections.unmodifiableCollection(kvs.values());
		ks = Collections.unmodifiableSet(kvs.keySet());
	}

	@Override
	final public V get(K key) {
		return kvs.get(key);
	}

	@Override
	final public Set<K> keySet() {
		return ks;
	}
	@Override
	final public Collection<V> values() {
		return vs;
	}
	final private Set<K> ks;
	final private Map<K, V> kvs;
	final private Collection<V> vs;
	
	final static public class Builder<K,V> implements ElementsBuildee<K,V>{
		@Override
		final public Elements<K,V> build(){
			Map<K,V> m = this.m;
			this.m = Collections.emptyMap();
			return new SimpleElements<K, V>(m);
		}
		@Override
		final public V put(K key,V value){
			return m.put(key, value);
		};
		@Override
		final public V remove(K key) {
			return m.remove(key);
		}
		private Map<K,V> m = new HashMap<K,V>();
	}
}
