package com.mycom.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
	ArrayList<Word> list;
	Scanner s;
	
	WordCRUD(Scanner s){
		list = new ArrayList<>();
		this.s = s;
	}
	
	@Override
	public Object add() {
		System.out.print("=> ���̵�(1,2,3) & �� �ܾ� �Է� : ");
		//1 driveway
		int level = s.nextInt();
		String word = s.nextLine();
		//���� ���Է�
		System.out.print("�� �Է� : ");
		String meaning = s.nextLine();

		return new Word(list.size() + 1, level, word, meaning);
	}
	
	public void addWord() {
		Word one = (Word)add();
		list.add(one);
		System.out.println("�� �ܾ �ܾ��忡 �߰��Ǿ����ϴ�. ");
	}

	@Override
	public int update(Object obj) {
		System.out.print("=> ���̵�(1,2,3) & �� �ܾ� �Է� : ");
		//1 driveway
		int level = s.nextInt();
		String word = s.nextLine();
		//���� ���Է�
		System.out.print("�� �Է� : ");
		String meaning = s.nextLine();
		((Word) obj).setLevel(level);
		((Word) obj).setWord(word);
		((Word) obj).setMeaning(meaning);
		System.out.println("���� �Ϸ�.");
		return 0;
	}

	@Override
	public int delete(Object obj) {
		System.out.print("=> �����Ͻðڽ��ϱ�? (��:1,�ƴϿ�:2) : ");
		int del = s.nextInt();
		s.nextLine();
		if (del == 1) {
			list.remove(((Word) obj).getId()-1);
			System.out.println("���� �Ϸ�.");
			return 1;
		}
		return 0;
	}

	@Override
	public void selectOne(int id) {
		System.out.println("-------------------------");
		System.out.print(id + " ");
		System.out.println(list.get(id-1).toString());
		System.out.println("-------------------------");
		
	}
	
	public void listAll() {
		System.out.println("-------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.print((i+1) + " ");
			System.out.println(list.get(i).toString());
		}
		System.out.println("-------------------------");
	}

	public void levelAll() {
		System.out.print("=> ���̵� (1,2,3) : ");
		int level = s.nextInt();
		s.nextLine();
		
		System.out.println("-------------------------");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getLevel() == level) {
				System.out.print((i+1) + " ");
				System.out.println(list.get(i).toString());
			}
		}
		System.out.println("-------------------------");
	}
	
}
