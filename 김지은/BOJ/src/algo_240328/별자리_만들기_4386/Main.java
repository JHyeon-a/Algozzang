package src.algo_240328.별자리_만들기_4386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class node{
        double x;
        double y;

        public node(double x, double y) {
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());

        node[] stars=new node[N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i]=new node(x,y);
        }

        double[][] dist =new double[N+1][N+1];

        // 가중치 계산
        for(int i=1; i<N; i++){
            for(int j=i+1; j<=N ; j++){
                double xd=Math.pow((stars[i].x-stars[j].x), 2);
                double yd=Math.pow((stars[i].y-stars[j].y), 2);
                double tmp=Math.floor(Math.sqrt(xd+yd)*100)/100;
                dist[i][j]=tmp;
                dist[j][i]=tmp;
            }
        }//for



    }
}
