package com.penglecode.common.support;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class KetamaNodeLocatorTest {

	private final List<Node> nodeList = new ArrayList<Node>();
	
	private final Map<Node,Integer> nodeHits = new LinkedHashMap<Node,Integer>();
	
	private final NodeLocator nodeLocator;
	
	public KetamaNodeLocatorTest() {
		super();
		nodeList.add(new ServerNode("192.168.137.101"));
		nodeList.add(new ServerNode("192.168.137.102"));
		nodeList.add(new ServerNode("192.168.137.103"));
		nodeList.add(new ServerNode("192.168.137.104"));
		for(Node node : nodeList){
			nodeHits.put(node, 0);
		}
		nodeLocator = new KetamaNodeLocator(nodeList);
	}

	public void testNodeDistribute(){
		int totalHits = 1000000;
		for(int i = 0; i < totalHits; i++){
			String randomKey = UUID.randomUUID().toString().replace("-", "");
			Node node = nodeLocator.getNodeByKey(randomKey);
			Integer hits = nodeHits.get(node);
			nodeHits.put(node, hits + 1);
		}
		
		int sumHits = 0;
		for(Map.Entry<Node,Integer> entry : nodeHits.entrySet()){
			System.out.println(String.format(">>> %s HITS = %d", entry.getKey(), entry.getValue()));
			sumHits += entry.getValue();
		}
		System.out.println(String.format(">>> %d == %d ? %b", totalHits, sumHits, totalHits == sumHits));
	}
	
	public static void main(String[] args) {
		KetamaNodeLocatorTest test = new KetamaNodeLocatorTest();
		test.testNodeDistribute();
	}
	
	public static class ServerNode implements Node {

		private String nodeId;
		
		public ServerNode(String nodeId) {
			super();
			this.nodeId = nodeId;
		}

		public String getNodeId() {
			return nodeId;
		}

		public void setNodeId(String nodeId) {
			this.nodeId = nodeId;
		}

		public String toString() {
			return "ServerNode [nodeId=" + nodeId + "]";
		}
		
	}
	
}
