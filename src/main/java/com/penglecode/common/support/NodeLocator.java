package com.penglecode.common.support;

import java.util.List;

public interface NodeLocator {

	public Node getNodeByKey(final String key);
	
	public void refreshLocator(final List<Node> nodeList);
	
}
