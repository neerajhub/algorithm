package com.myproject.test.graph;

public class UnionFind {

    public int root [];

    public UnionFind(int size){
        root = new int [size];
    }

    //quick find and union
    public int quickFind(int x){
        return root[x];
    }

    public void union(int x, int y){
        int rootX = root[x];
        int rootY = root[y];

        if(rootX != rootY){
            for(int i = 0; i < root.length; i++){
                if(root[i] == rootY) root[i]  = rootX;
            }
        }
    }

    public boolean connected(int x, int y){
        return quickFind(x) == quickFind(y);
    }


    ///below method for quickUnion

    public void quickUnion(int x, int y){
       int rootX= root[x];
       int rootY = root[y];
       if(rootX  != rootY){
           root[y] = rootX;
       }
    }


    public int find(int x){
         int out = root[x];
         while( out != root[out]){
               out = root[out];
         }
         return out;
    }

}
