package com.autonavi.infra.collections;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import com.autonavi.infra.ResourceException;

public abstract class ResElements<K,V> implements Elements<K,V>{
	
	final public V get(K key) {
		return elements.get(key);
	}

	final public Collection<V> values() {
		return elements.values();
	}

	final public Set<K> keySet() {
		return elements.keySet();
	}

	final public void init(){
		
		try {
			
			this.elements = parse(resource);
			logger.info("elements amount : {}",this.elements.values().size());
		} catch (IOException e) {
			throw new ResourceException(e);
		}
	}
	abstract protected Elements<K,V> parse(Resource resource) throws IOException;
	private Elements<K,V> elements;
	private Resource resource;
	final static Logger logger = LoggerFactory.getLogger(ResElements.class);
	final public void setResource(Resource resource) {
		this.resource = resource;
	}
}
