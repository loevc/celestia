package com.loevc.celestia.common.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/18 11:31
 * @Description TODO
 * @Version 1.0
 */


class WeightedDirectedEdge {
    int from;
    int to;
    int weight;

    public WeightedDirectedEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}


class WeightedDirectedGraphNode {
    int id;
    List<WeightedDirectedEdge> edges;

    public WeightedDirectedGraphNode(int id) {
        this.id = id;
        this.edges = new ArrayList<>();
    }

    public void addEdge(WeightedDirectedEdge edge) {
        edges.add(edge);
    }
}




public class WeightedDirectedGraph {

    private Map<Integer, WeightedDirectedGraphNode> nodes;

    public WeightedDirectedGraph() {
        this.nodes = new HashMap<>();
    }

    public void addNode(int nodeId) {
        if (!nodes.containsKey(nodeId)) {
            nodes.put(nodeId, new WeightedDirectedGraphNode(nodeId));
        }
    }

    public void addEdge(int fromNodeId, int toNodeId, int weight) {
        WeightedDirectedGraphNode fromNode = nodes.get(fromNodeId);
        WeightedDirectedGraphNode toNode = nodes.get(toNodeId);

        if (fromNode != null && toNode != null) {
            WeightedDirectedEdge edge = new WeightedDirectedEdge(fromNodeId, toNodeId, weight);
            fromNode.addEdge(edge);
        }
    }

    public List<WeightedDirectedEdge> getEdges(int nodeId) {
        WeightedDirectedGraphNode node = nodes.get(nodeId);
        return (node != null) ? node.edges : new ArrayList<>();
    }



    public static void main(String[] args) {
        WeightedDirectedGraph graph = new WeightedDirectedGraph();

        // 添加顶点
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);

        // 添加边
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(3, 1, 3);

        // 获取顶点1的边
        List<WeightedDirectedEdge> edges = graph.getEdges(1);
        for (WeightedDirectedEdge edge : edges) {
            System.out.println("Edge from " + edge.from + " to " + edge.to + " with weight " + edge.weight);
        }
    }
}
