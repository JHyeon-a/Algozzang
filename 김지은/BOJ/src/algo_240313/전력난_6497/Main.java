package src.algo_240313.전력난_6497;package

import java.io.*;
import java.util.*;

public class Main{
    static class node implements Comparable<node>{
        int x,y,z;
        private node(int x, int y, int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }

        @Override
        public int compareTo(node o){return this.z-o.z;}
    }

    static int[] house;
    static List<node> list;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st=new StringTokenizer(br.readLine());
            int m=Integer.parseInt(st.nextToken());
            int n=Integer.parseInt(st.nextToken());

            if(m==0 && n==0){
                break;
            }

            list=new ArrayList<>();
            int total=0;
            int minCost=0;

            house=new int[m+1];
            for(int i=1; i<=m; i++){
                house[i]=i;
            }

            for(int i=0; i<n; i++){
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                int z=Integer.parseInt(st.nextToken());
                total+=z;
                list.add(new node(x,y,z));
            }

            Collections.sort(list);


            for(node node:list){
                if(find(node.x)!=find(node.y)){
                    unite(node.x, node.y);
                    minCost+=node.z;
                }
            }
        System.out.println(total-minCost);
        }
        br.close();


    }

    private static int find(int num){
        if(house[num]==num) return house[num];
        return house[num]= find(house[num]);
    }

    private static void unite(int x, int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX!=rootY) house[rootY]=rootX;

    }
}