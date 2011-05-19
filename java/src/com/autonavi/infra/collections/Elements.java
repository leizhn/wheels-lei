package com.autonavi.infra.collections;

import java.util.Collection;
import java.util.Set;

/**
 * 
 * �򻯽ӿڵĲ��ɱ��Map
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
