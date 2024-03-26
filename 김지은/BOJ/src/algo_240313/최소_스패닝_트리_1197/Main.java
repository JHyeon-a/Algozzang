package src.algo_240313.최소_스패닝_트리_1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int e;
        int w;
        public Node(int e, int w){
            this.e =e;
            this.w=w;
        }

        @Override
        public int compareTo(Node n){
            return this.w-n.w;
        }
    }

    static PriorityQueue<Node> pq=new PriorityQueue<>();
    static LinkedList<Node>[] list;
    static boolean[] visited;
    static int sum;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        visited = new boolean[V + 1];
        list=new LinkedList[V+1];
        for (int i=0; i<list.length; i++){
            list[i]=new LinkedList<Node>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e,w));
            list[e].add(new Node(s,w));

        }
        sum=0;
        prim(1);

        System.out.println(sum);

    }

    private static void prim(int start) {
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()){
            Node node=pq.poll();
            if(!visited[node.e]){
                visited[node.e]=true;
                sum+=node.w;
                for(Node n : list[node.e]){
                   if(!visited[n.e]) pq.add(n);
                }

            }
        }
    }
}
