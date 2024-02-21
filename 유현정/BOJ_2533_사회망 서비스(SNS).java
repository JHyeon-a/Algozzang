package boj_2533;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
 * 1. �Է�(�� �ڽ� ��� ǥ��)
 * 2.	-1. ������ ��� -> dp[son]���� �ּڰ� ���ϰ� +1
 * 		-2. ���� �� �� ��� -> dp[son][1]�� ���ϱ�
 * 
 * dp -> �����κ��ذ� ������?
 * 	-> ����Ʈ�� ���� ���ؾ� �ϸ� �ؿ�������?, ���� ��ȸ �̿�
 * 
 * https://www.youtube.com/watch?v=a-cjNNPaJCo ��õ
 */
public class Main4 {
	static int n;
	static ArrayList<Integer>[] friend;
	static boolean[] visited;
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		friend = new ArrayList[n+1];
		visited = new boolean[n+1];
		dp = new int[n+1][2];
		
		for(int i = 0; i<n+1; i++) {
			friend[i] = new ArrayList<Integer>();
		}
		
		//��[�ε���]�� ��ü ���� ��� ��ȣ �ֱ�
		for(int i = 1; i<n; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			friend[second].add(first);
			friend[first].add(second);
		}
		
		dynamicProgramming(1);
		
		int result = Math.min(dp[1][0], dp[1][1]);
		System.out.println(result);

	}
	
	static void dynamicProgramming(int start) {	
		if(visited[start]) {
			return;
		}
		visited[start] = true;
		//���� ��ȸ
		for(int i = 0; i<friend[start].size(); i++) {
			int son = friend[start].get(i);
			if(!visited[son]) {
				dynamicProgramming(son);
				
				dp[start][0] += dp[son][1];
				dp[start][1] += Math.min(dp[son][0], dp[son][1]);
			}
		}
		dp[start][1] += 1; 
	}//dp

}
