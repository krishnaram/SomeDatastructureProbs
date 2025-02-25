package com.example.leetcodemedium;

import java.util.*;

public class MaxInheritance {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> ancestorMap = new HashMap<Integer,List<Integer>>();
        List<Integer> list ;
        for(int i=0;i<edges.length;i++){
            if(ancestorMap.containsKey(edges[i][1])){
                list = ancestorMap.get(edges[i][1]);
                list.add(edges[i][0]);
            }
            else{
                list = new ArrayList<Integer>();
                list.add(edges[i][0]);
                ancestorMap.put(edges[i][1], list);
            }
        }

        Set<Integer>  temp;
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            if(ancestorMap.containsKey(i)){
                temp = new HashSet<Integer>();
                temp.addAll(ancestorMap.get(i));
                for(int lastAncestor:ancestorMap.get(i)){
                    if(ancestorMap.containsKey(lastAncestor))
                    {
                        temp.addAll(ancestorMap.get(lastAncestor));
                    }
                }
                List<Integer> newList = new ArrayList<Integer>();
                newList.addAll(temp);
                Collections.sort(newList);
                returnList.add(newList);
            }
            else{
                returnList.add(new ArrayList());
            }
        }
        return returnList;
    }
}
