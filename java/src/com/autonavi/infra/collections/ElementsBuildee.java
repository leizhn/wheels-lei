package com.autonavi.infra.collections;

/**
 * 
 * 划分Elements实体构建期和访问期的接口，在执行build之前，buildee接口是激活的，可以添加和删除
 * 
 * @author zhenhua.lei
 *
 * @param <K>
 * @param <V>
 */
public interface ElementsBuildee<K,V> {
	/**
	 * 当第一次执行此方法时，返回的是保存有之前所有没有被remove的put的所有执行的结果，否则返回一个空的Elements实体
	 * @return 第一次执行：所有没有被remove的put的所有执行的结果，非第一次执行，没有任何元素的Elements实体
	 */
	Elements<K,V> build();
	/**
	 * @param key
	 * @param value
	 * @return
	 * @throws UnsupportedOperationException 当build方法被执行之后，调用此方法时，抛出此异常
	 */
	V put(K key,V value) throws UnsupportedOperationException;
	/**
	 * @param key
	 * @return
	 * @throws UnsupportedOperationException 当build方法被执行之后，再次调用此方法时，抛出此异常
	 */
	V remove(K key) throws UnsupportedOperationException;
}
