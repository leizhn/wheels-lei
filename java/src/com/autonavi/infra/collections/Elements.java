package com.autonavi.infra.collections;

import java.util.Collection;
import java.util.Set;

/**
 * 
 * 简化接口的不可变的Map
 * 
 * 
 * @author zhenhua.lei
 * @version 0.1.1,2011-4-20
 * 
 * @param <K>
 * @param <V>
 */
public interface Elements<K, V>{
	/**
	 * @param key
	 * @return
	 */
	V get(K key);
	Collection<V> values();
	Set<K> keySet();
}
