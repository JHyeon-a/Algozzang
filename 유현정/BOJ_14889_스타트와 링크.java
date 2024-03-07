package Boj_14889;

import java.util.Scanner;

/*
 * ����: 2��, 512MB
 * 
 * ���� �ּ�
 * 
 * ��Ž: ���� -> ���
 * 20C10 -> 6700��
 * 
 *�밢�� 0�� �������� ���ϸ� �� �ǳ�?
 *���ص� �� 
 *
 *�ִ�, �ּڰ� ���ϰ� �װ� �������� ��Ʈ��ŷ �ϱ�
 *
 *�� n/2�� ����
 *����-> �ּڰ� ����
 *
 *1. ���ջ���(n/2�� ����)
 *	- 0�� ������ ����, �� �Ŀ� (n/2)-1�� ����
 *	- �� ���� -> �������
 * 
 */
public class Main {

	static int n;
	static int[][] ability;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ability = new int[n][n];
		visited = new boolean[n];
//		OneCombination = new int[n / 2];
//		OneCombination[0] = 0;
		visited[0] = true;

		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				ability[i][j] = sc.nextInt();
			}
		}
		
		Combination(1 ,1);
		System.out.println(result);

	}

	// ���� �����(1~n), �ߺ����Ű� �� �� -> �׳� ¦�� �ε��� ����ϱ�
	static int idx = 1;
	
	static int result = 200;
	static int visitedBit = 1;

	public static void Combination(int index, int start) {
		if (index == n / 2) {
				int first = 0;
				int second = 0;
				//�� ����
				for (int j = 0; j < n; j++) {
					int firstCheck = 1<<j;
					for (int k = 0; k < n; k++) {
						int secondCheck = 1<<k;
//						if(visited[j] && visited[k]) {
//						System.out.println("visitedBit  "+ visitedBit);
						if( (visitedBit & firstCheck) >0 && (visitedBit & secondCheck) >0) {
//							System.out.println("j: "+j+" k: "+k);
							first += ability[j][k];
//						}else if(!visited[j] && !visited[k]) {
						}else if( (visitedBit & firstCheck) == 0 && (visitedBit & secondCheck) ==0 ){
							second += ability[j][k];
						}
					}
				}
//				System.out.println("Second: "+second);
				
				int difference = Math.abs(first-second);
				if(result>difference) {
					result = difference;
				}
				
				
//				System.out.println("f "+first);
			return;
		}
		if(result == 0) {
			return;
		}

		for (int i = start; i < n; i++) {
//			if (!visited[i]) {
				if( (visitedBit & (1<<i)) == 0) {
//					System.out.println(visitedBit);
					visitedBit = visitedBit | (1<<i);
//					System.out.println("c: "+visitedBit);
//				visited[i] = true;
				Combination(index+1, start+1);
//				visited[i] = false;
				visitedBit = visitedBit & ~(1<<i);
			}
		}

	}
}
