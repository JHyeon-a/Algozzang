package Boj_2529;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	//�ε�ȣ ����
	// �ִ� - ū �� ���� �ֱ�
	// �ּ� - ���� �� ���� �ֱ�
	//visited[] �� �ߺ�üũ
	//�ð� 1�� && �޸� ���� 256MB
	//10! = �� 4�鸸, 8����Ʈ
	//�׳� �����ص� �� ��?
	static int k;
	static String[] inequalitySign;
	static boolean[] maxCheck = new boolean[10]; //�ε���-1 ���� ��뿩�� üũ
	static boolean[] minCheck;
	static int[] max;
	static int[] min;
	//����� ��� ���� Ȯ��
	static boolean last;
	
	public static void main(String[] args) {
		//ū �� ���ϱ�
		Scanner sc = new Scanner(System.in);
		k = Integer.parseInt(sc.next());
		
		inequalitySign = new String[k];
		minCheck = new boolean[k+1]; //�ε��� -1�� ���� ��뿩�� üũ
		max = new int[k+1];
		min = new int[k+1];
		
		for(int i = 0; i<k; i++) {
			inequalitySign[i] = sc.next();
		}
		
		//ū �� ���ϱ�
			findMax();
			idx = 0;
			findMin();
			for(int i = 0; i<k+1; i++) {
				System.out.print(max[i]);
			}
			System.out.println();
			for(int i = 0; i<k+1; i++) {
				System.out.print(min[i]);
			}
	}
	
	static int idx = 0;
	
	public static void findMax() {
		//�ε�ȣ �˻�
		if(idx > 1) {
			String sign = inequalitySign[idx-2];
			if(sign.equals("<")) {
				if(max[idx-2] > max[idx-1]) {
					last = true;
					return;
				}			
			}else {
				if(max[idx-2] < max[idx-1]) {
					last = true;
					return;
				}
			}			
		}
		//�ε��� �˻�
		if(idx > k) {
			return;
		}
		//DFS
		for(int i = 9; i>8-k; i--) {
			if(!maxCheck[i]) {
				//�ʱ�ȭ
				last = false;
				max[idx] = i;
				maxCheck[i] = true;
				idx++;
				findMax();
				if(idx >k && !last) {
					break;
				}
				idx--;
				maxCheck[i] = false;
			}
		}
	}
	
	//findMax���� for�� ���⸸ �ݴ��
	public static void findMin() {
		//�ε�ȣ �˻�
		if(idx > 1) {
			String sign = inequalitySign[idx-2];
			if(sign.equals("<")) {
				if(min[idx-2] > min[idx-1]) {
					last = true;
					return;
				}			
			}else {
				if(min[idx-2] < min[idx-1]) {
					last = true;
					return;
				}
			}			
		}
		//�ε��� �˻�
		if(idx > k) {
			return;
		}
		//DFS
		for(int i = 0; i<k+1; i++) {
			if(!minCheck[i]) {
				//�ʱ�ȭ
				last = false;
				min[idx] = i;
				minCheck[i] = true;
				idx++;
				findMin();
				if(idx >k && !last) {
					break;
				}
				idx--;
				minCheck[i] = false;
			}
		}
		
	}

}
