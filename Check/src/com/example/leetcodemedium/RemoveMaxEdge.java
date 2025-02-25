package com.example.leetcodemedium;


import java.util.*;

public class RemoveMaxEdge {
    class ConnectNode {
        int value ;
        Set<ConnectNode> connectedNodes;
        public  ConnectNode (int value, Set<ConnectNode> connectedNodes ){
            this.value = value;
            this.connectedNodes = connectedNodes;
        }
    }

    public static void main(String[] s){
        System.out.println("Sample test passing is maxNumEdgesToRemove removed: " +
                (maxNumEdgesToRemove(4, new int[][]
                                {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}}) == 2)  + "\r\n");

        System.out.println("Sample test passing is maxNumEdgesToRemove removed: " +
                (maxNumEdgesToRemove(4, new int[][]
                                {{3,1,2},{3,2,3},{1,1,4},{2,1,4}}) == 0)  + "\r\n");

        System.out.println("Sample test passing is maxNumEdgesToRemove removed: " +
                (maxNumEdgesToRemove(4, new int[][]
                                {{3,2,3},{1,1,2},{2,3,4}})==-1) + "\r\n");
        System.out.println("Sample test passing is maxNumEdgesToRemove removed: " +
                (maxNumEdgesToRemove(4, new int[][]
                        {{3,1,2}, {3,3,4}, {1,1,3},{2,2,4}})==0) + "\r\n");
    }

    public static  int maxNumEdgesToRemove(int n, int[][] edges) {
        List<ConnectNode> connectNodes = new ArrayList<ConnectNode>();

        int[][] bothConnectArray = new int[n+1][n+1];
        int[][] bobConnect = new int[n+1][n+1];
        int[][] aliceConnect = new int[n+1][n+1];
        for(int i=0;i<edges.length;i++) {
            if (edges[i][0] == 3) {
                bobConnect[edges[i][1]][edges[i][2]] = 1;
                bobConnect[edges[i][2]] [edges[i][1]]= 1;
                aliceConnect[edges[i][1]][edges[i][2]] = 1;
                aliceConnect[edges[i][2]] [edges[i][1]]= 1;

            }
        }


        for(int i=0;i<edges.length;i++) {
            if (edges[i][0] == 1) {
                aliceConnect[edges[i][1]][edges[i][2]] = 1;
                aliceConnect[edges[i][2]] [edges[i][1]]= 1;
            }
            if (edges[i][0] == 2) {
                bobConnect[edges[i][1]][edges[i][2]] = 1;
                bobConnect[edges[i][2]] [edges[i][1]]= 1;
            }
        }



        return  -1;
    }


   /* int removableEdge = 0;
    List<ConnectNode> connectNodes = new ArrayList<ConnectNode>();
    Map<Integer, Integer> bobConnect = new HashMap<Integer, Integer>();
    Map<Integer, Integer> aliceConnect = new HashMap<Integer, Integer>();
    Map<Integer, Integer> bothConnect = new HashMap<Integer, Integer>();
    List<Integer> connected = new ArrayList<Integer>();

        for(int i=0;i<edges.length;i++) {
        if (edges[i][0] == 3) {
            if(bothConnect.containsKey(edges[i][1])){
                bothConnect.put(edges[i][2],edges[i][1]);
                aliceConnect.put(edges[i][2],edges[i][1]);
                bobConnect.put(edges[i][2],edges[i][1]);
            }
            else if(bothConnect.containsKey(edges[i][2])){
                bothConnect.put(edges[i][1],edges[i][2]);
                aliceConnect.put(edges[i][1],edges[i][2]);
                bobConnect.put(edges[i][1],edges[i][2]);
            }
            else{
                bothConnect.put(edges[i][1],edges[i][2]);
                aliceConnect.put(edges[i][1],edges[i][2]);
                bobConnect.put(edges[i][1],edges[i][2]);
            }
        }
    }

        for(int i=0;i<edges.length;i++) {
        if (edges[i][0] == 1) {
            if(aliceConnect.containsKey(edges[i][1]) &&
                    aliceConnect.get(edges[i][1]) == edges[i][2]){
                removableEdge++;
            }
            else if(aliceConnect.containsKey(edges[i][2]) &&
                    aliceConnect.get(edges[i][2]) == edges[i][1]){
                removableEdge++;
            }
            else{
                if(aliceConnect.containsKey(edges[i][1])){
                    aliceConnect.put(edges[i][2],edges[i][1]);
                }
                else{
                    aliceConnect.put(edges[i][2],edges[i][1]);
                }

            }

        } else if (edges[i][0] == 2) {
            if(bobConnect.containsKey(edges[i][1]) &&
                    bobConnect.get(edges[i][1]) == edges[i][2]){
                removableEdge++;
            }
            else if(bobConnect.containsKey(edges[i][2]) &&
                    bobConnect.get(edges[i][2]) == edges[i][1]){
                removableEdge++;
            }
            else{
                if(bobConnect.containsKey(edges[i][1])){
                    bobConnect.put(edges[i][2],edges[i][1]);
                }
                else{
                    bobConnect.put(edges[i][2],edges[i][1]);
                }
            }
        }
    }*/
}
