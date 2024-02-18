package boj_14277;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //���� ��
		int m = sc.nextInt(); //Ī�� ��
		ArrayList<Integer>[] subordinate = new ArrayList[n+1];
		int[] employer = new int[n+1]; //[]Ī��
		int junk = sc.nextInt(); //���� ���: -1 ����
		subordinate[1] = new ArrayList<Integer>();
		/*
		 *����ε����� �������� �Է� 
		 */
		for(int i = 2; i<=n; i++) {
			int boss = sc.nextInt();
			subordinate[i] = new ArrayList<Integer>();
			subordinate[boss].add(i);
		}
		/*
		 * Ī�� ���� ������ȣ �ε����� Ī�� ��ġw
		 */
		for(int i = 0; i<m; i++) {
			int employeeNumber = sc.nextInt();
			int w = sc.nextInt();
			employer[employeeNumber] = w;
		}
		/*
		 * ���� ���� �������� ���ϱ�
		 */
		for(int i = 2; i<n; i++) {
			int completion = employer[i];
			for(int j = 0; j<subordinate[i].size(); j++) {
				int employeeNumber = subordinate[i].get(j);
				employer[employeeNumber] += completion;
			}
		}
		for(int i = 1;i<=n;i++) {
			System.out.print(employer[i]+" ");
		}
		
	}

}
