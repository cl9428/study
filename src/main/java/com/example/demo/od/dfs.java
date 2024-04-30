package com.example.demo.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dfs{

     List<String> vertexList ;
     int[][] edges ;
     int numOfEdges;

    public static void main(String[] args) {

        int n = 5;
        String[] vertexList = {"A","B","C","D","E"};
/*        int [][] arr = new int[n][n];
        arr[0][1] = 1;
        arr[0][2] = 1;
        arr[1][2] = 1;
        arr[1][3] = 1;
        arr[2][3] = 1;
        arr[1][4] = 1;
        arr[2][4] = 1;
        arr[3][4] = 1;
        arr[4][0] = 1;
        arr[4][1] = 1;

        dfs dfs = new dfs(Arrays.asList(vertexList),arr,5);
        dfs.showGraph();*/

        dfs dfs = new dfs(5);
        dfs.insertVertex("A");
        dfs.insertVertex("B");
        dfs.insertVertex("C");
        dfs.insertVertex("D");
        dfs.insertVertex("E");
        dfs.insertEdge(0,1,1);
        dfs.insertEdge(0,2,1);
        dfs.insertEdge(1,2,1);
        dfs.insertEdge(1,3,1);
        dfs.insertEdge(1,4,1);

        dfs.showGraph();
    }

    public dfs(List<String> vertexList, int[][] edges, int numOfEdges) {
        this.vertexList = vertexList;
        this.edges = edges;
        this.numOfEdges = numOfEdges;
    }

    public dfs( int numOfEdges) {
        this.numOfEdges = numOfEdges;
        vertexList = new ArrayList<>(numOfEdges);
        edges = new int[numOfEdges][numOfEdges];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges ++;
    }

    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

}
