package BOJ_2578;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * 1. �����ޱ� 2. ����� 3. ����ϱ�
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] board = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= 25; i++) {
			int number = sc.nextInt();
			// Ž��(�����)
			primary: for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (board[j][k] == number) {
						board[j][k] = 0;
						break primary;
					}
				}
			}
			// Ž��(����üũ)
			int bingo = 0;
			// ����
			for (int j = 0; j < 5; j++) {
				if (board[0][j] == 0) {
					for(int k = 1; k<5; k++) {
						if(board[k][j] != 0) {
							break;
						}
						if(k == 4) {
							bingo++;
						}
					}
				}
			}
			// ����
			for (int j = 0; j < 5; j++) {
				if (board[j][0] == 0) {
					for(int k = 1; k<5; k++) {
						if(board[j][k] != 0) {
							break;
						}
						if(k == 4) {
							bingo++;
						}
					}
				}
			}
			// �밢��
			if(board[0][0] == 0) {
				for(int k = 1; k<5; k++) {
					if(board[k][k] != 0) {
						break;
					}
					if(k == 4) {
						bingo++;
					}
				}
			}
			if(board[4][0] == 0) {
				for(int k = 1; k<5; k++) {
					if(board[4-k][k] != 0) {
						break;
					}
					if(k == 4) {
						bingo++;
					}
				}
			}
			//���� ���� üũ
			if(bingo>=3) {
				System.out.println(i);
				break;
			}
		}
	}

}
