package Boj_1759;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * �ּ� 1���� ���� + �ּ� 2���� ����
 * ���� �ٸ� ���ĺ� �ҹ��ڷ� ����
 * ��������
 * 
 *ó������ �迭 �ؼ� �����?
 *����� �迭��?
 *
 *�ִ� 15�� ���� �־��� -> �̱� 10000�� -> ���� O(nlogn~n^2) �ִ� 1��
 *�ð� ��Ʈ��ŷ �� �ص� ������ ��?
 *
 * 2�� 128MB
 * 1. ���� ���� �ֱ�(�������)
 * 2. ���� ���� �ֱ�(�������)
 * 3. ���� ����(�ּ� 1���� ����+�ּ� 2���� ����)-> ���� 1~L-2/ ���� L-1~2�� �̱�
 * 4. ����
 * 
 * or 
 * 
 * ������� �̰�, ���ǿ� �´��� üũ
 */
public class Main {
	static int L;
	static int C;
	static List<String> vowels;
	static List<String> consonants;
	static String[] word;
	static List<String> wordList;
	static int vowelsNumber;
	static int consonantsNumber;
	static int maxTry;
	static int i;
	static StringBuilder stringBuilder;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = Integer.parseInt(sc.next());
		C = Integer.parseInt(sc.next());
		
		vowels = new ArrayList<>();
		consonants = new ArrayList<>();
		
		for(int i = 0; i<C; i++) {
			String alphabet = sc.next();
			if(alphabet.equals("a") || alphabet.equals("e") || alphabet.equals("i") || alphabet.equals("o") || alphabet.equals("u")) {
				vowels.add(alphabet);
			}else {
				consonants.add(alphabet);
			}
		}
		word = new String[L];
		wordList = new ArrayList<>();
		vowelsNumber = vowels.size();
		consonantsNumber = consonants.size();
		maxTry = Math.min(vowelsNumber, Math.min(consonantsNumber-1, L-2));
//		System.out.println(maxTry);
		//������ L-1�� �̻� ���� ������ 1������ �Ұ�
		int init = Math.max(1, L-consonantsNumber);
		//�̱�
		for(i = init; i<init+maxTry; i++) {
			pick(i, 0, 0, 0, vowelsNumber, vowels);
		}
		//���� ���߱�
		Collections.sort(wordList);
		
		for(int i = 0; i<wordList.size(); i++) {
			String words = wordList.get(i);
			System.out.println(words);
			
		}
		
	}
	
	//�����̱�-> ���� �̱�
	public static void pick(int n, int count, int wordIdx, int idx, int number, List<String> alphabet) {//n: ���� ����, count: ���� ����
		//���� ����
		if(n-count>number - idx) {
			return;
		}
		//���� or �������� �� ��
		if(n == count) {
//			System.out.println(Arrays.toString(word));
			//���� ���� �� ����
			if(wordIdx >= L) {
				stringBuilder = new StringBuilder();
				String[] tmp = word.clone();
				Arrays.sort(tmp);
				for(int i = 0; i<L; i++) {
					stringBuilder.append(tmp[i]);
				}
				String tmpWord = stringBuilder.toString();
				wordList.add(tmpWord);
				return;
			}
			//���� �� �� ������ ����(��->��)
			pick(L-i, count-i, wordIdx, 0, consonantsNumber, consonants);
			return;
		}
		if(wordIdx>=L) {
			return;
		}
		//����
		word[wordIdx] = alphabet.get(idx);
		pick(n, count+1, wordIdx+1, idx+1, number, alphabet);
		//�� ����
		pick(n, count, wordIdx, idx+1, number, alphabet);
	}
}
