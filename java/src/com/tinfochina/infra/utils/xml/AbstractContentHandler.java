package com.tinfochina.infra.utils.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * SAXP处理xml时的占位模板，因为通常未必需要处理所有事件
 * 
 * @author zhenhua.lei
 * @version 0.1.0.20100705
 */
abstract public class AbstractContentHandler implements ContentHandler {

	@Override
	public void endDocument() throws SAXException {
		logger.trace("place holder of method : endDocument ");
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		logger.trace("place holder of method : endPrefixMapping {}", prefix);
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		logger.trace("place holder of method : ignorableWhitespace {},{},{}",
				new Object[] { new String(ch), start, length });
	}

	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
		logger.trace("place holder of method : processingInstruction {},{} ",
				target, data);
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		logger.trace("place holder of method : setDocumentLocator ");
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		logger.trace("place holder of method : skippedEntity {}", name);

	}

	@Override
	public void startDocument() throws SAXException {
		logger.trace("place holder of method : startDocument ");
	}

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		logger.trace("place holder of method : startPrefixMapping {},{}",
				prefix, uri);
	}

	final private Logger logger = LoggerFactory
			.getLogger(AbstractContentHandler.class);
}