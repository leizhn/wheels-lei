package com.autonavi.infra.collections;

/**
 * 
 * ����Elementsʵ�幹���ںͷ����ڵĽӿڣ���ִ��build֮ǰ��buildee�ӿ��Ǽ���ģ�������Ӻ�ɾ��
 * 
 * @author zhenhua.lei
 *
 * @param <K>
 * @param <V>
 */
public interface ElementsBuildee<K,V> {
	/**
	 * ����һ��ִ�д˷���ʱ�����ص��Ǳ�����֮ǰ����û�б�remove��put������ִ�еĽ�������򷵻�һ���յ�Elementsʵ��
	 * @return ��һ��ִ�У�����û�б�remove��put������ִ�еĽ�����ǵ�һ��ִ�У�û���κ�Ԫ�ص�Elementsʵ��
	 */
	Elements<K,V> build();
	/**
	 * @param key
	 * @param value
	 * @return
	 * @throws UnsupportedOperationException ��build������ִ��֮�󣬵��ô˷���ʱ���׳����쳣
	 */
	V put(K key,V value) throws UnsupportedOperationException;
	/**
	 * @param key
	 * @return
	 * @throws UnsupportedOperationException ��build������ִ��֮���ٴε��ô˷���ʱ���׳����쳣
	 */
	V remove(K key) throws UnsupportedOperationException;
}
