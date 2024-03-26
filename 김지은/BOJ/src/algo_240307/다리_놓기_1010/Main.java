package src.algo_240307.다리_놓기_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[] dp = new int[31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            dp[1]=1;
            dp[2]=2;

            DP(M);
            DP(N);
            DP(M - N);
            for (int i : dp) {
                System.out.print(i+" ");
            }
            System.out.println(dp[M]/dp[N]/dp[M-N]);

        }

    }

    static int DP(int num){

        if (num<=2||dp[num]!=0) return dp[num];
        else {
            dp[num]=DP(num-1)*num;
            return dp[num];
        }
    }
}
