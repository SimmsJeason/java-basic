package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private List<String> vertexList;
    private int [][] edges;//存储图的邻接矩阵
    private int numOfEdges;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>();
        numOfEdges = 0;
    }

    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }


    /***
     *  添加边
     * @param v1 边的顶点对应的下标
     * @param v2 边的顶点对应的下标
     * @param weight 边的权值
     */
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;//因为是无向边
        numOfEdges ++;
    }

    //返回结点个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //返回边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回结点i对应的数据： 0 -> A, 1 -> B ...
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1-v2 的权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    //显示图
    public void show(){
        for(int [] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }
}
