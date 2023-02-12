package com.bii.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 图
 *
 * @author bihaiyang
 * @desc
 * @since 2022/11/29
 */
public class Graph {
    
    /**
     * 存储顶点集合
     */
    private List<String> vertexList;
    
    /**
     * 存储图对应的临阶矩阵
     */
    private int[][] edges;
    
    /**
     * 表示边的数目
     */
    private int edgeNum;
    
    private boolean[] isVisited;
    
    //构造器
    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        isVisited = new boolean[5];
        edgeNum = 0;
    }
    
    /**
     * 插入顶点
     *
     * @param vertexes 顶点
     */
    public void addVertexes(List<String> vertexes) {
        vertexList.addAll(vertexes);
    }
    
    
    /**
     * 插入顶点
     *
     * @param vertex 顶点
     */
    public void addVertex(String vertex) {
        vertexList.add(vertex);
    }
    
    /**
     * 添加边
     *
     * @param v1     表示第一个顶点对应的下标
     * @param v2     表示第二个顶点对应的下标
     * @param weight
     */
    public void addEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgeNum++;
    }
    
    /**
     * 获取顶点数
     *
     * @return 返回顶点数量
     */
    public int getVertexSize() {
        return vertexList.size();
    }
    
    /**
     * 获取边的数目
     *
     * @return
     */
    public int getEdgeNum() {
        return edgeNum;
    }
    
    /**
     * 获取相应下标索引
     *
     * @param i 顶点序号
     * @return
     */
    public String getVertexByIndex(int i) {
        return vertexList.get(i);
    }
    
    /**
     * 获取v1 -》 v2的权重
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }
    
    
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }
    
    /**
     * 图的深度优先搜索 1、访问初始节点v，并标记v已访问 2、查找节点v时第一个邻接节点w
     */
    public void dfs() {
    
    }
    
    
    public static void main(String[] args) {
        int n = 5;
        String vertexes[] = {"a", "b", "c", "d", "e"};
        Graph graph = new Graph(n);
        graph.addVertexes(Arrays.asList(vertexes));
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.showGraph();
    }
}
