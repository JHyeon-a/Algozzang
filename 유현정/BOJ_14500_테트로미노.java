package Boj_14500;

import java.util.Scanner;

/*
 * ����: 2��
 * -> 2��ȸ ����
 * 
 * �� �� ��ȸ = 25�� -> 2�� for�� �Ұ�
 * ��Ž -> 25�� * 4*6*8
 *  
 * 1. ���� ū �� ã��
 * 2. �湮 �迭 �����
 * 3. ��Ž ����(DFS)
 * 	- ���� �� �� ������ 4���� ��ȸ
 *  -> �ְ� ���ص� �ȵǸ� return
 *  
 *  
 */
public class Main {
	static int N;
	static int M;
	static int[][] paper;
	static boolean[][] visited;
	static int max = 0;
	static int maxi = 0;
	static int maxj = 0;
	static int nowValue = 0;
	static int result;
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		paper = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				paper[i][j] = sc.nextInt();
				if(max<paper[i][j]) {
					max = paper[i][j];
					maxi = i;
					maxj = j;
				}
			}
		}
		result = 0;
		DFS(maxi, maxj, maxi, maxj);
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
//				count = 0;
//				nowValue = 0;		
//				System.out.println("st "+i+" "+j);
				DFS(i, j, i, j);
			}
		}
		
		System.out.println(result);
		
	}
	
	static int[] di = new int[] {-1, 0, 1, 0};
	static int[] dj = new int[] {0, -1, 0, 1};
	
	static void DFS(int starti, int startj, int formali, int formalj) {
		//�湮 �� �߰ų�, 4�� �� ���Ұų�, ���� ���� �� return
		if(visited[starti][startj] || count>=4) {
			return;
		}
//		System.out.println("c: "+count+" "+starti+" "+startj);
		if(result>(4-count)*max+nowValue) {
			return;
		}
		count++;
		nowValue += paper[starti][startj];
		visited[starti][startj] = true;
		if(result<nowValue) {
			result = nowValue;
//			System.out.println("result: "+result+ " i j :"+starti+" "+startj);
		}
		for(int direction = 0; direction<4; direction++) {
			int newi = starti+di[direction];
			int newj = startj+dj[direction];
			if(newi>=0 && newi<N && newj>=0 && newj<M) {
				DFS(newi, newj, starti, startj);
			}
			newi = formali+di[direction];
			newj = formalj+dj[direction];
			if(newi>=0 && newi<N && newj>=0 && newj<M) {
				DFS(newi, newj, starti, startj);
			}
		}
		count--;
		nowValue -= paper[starti][startj];
		visited[starti][startj] = false;
		
		
		
		
		if(nowValue>result) {
			result = nowValue;
		}
		
		
	}

}
