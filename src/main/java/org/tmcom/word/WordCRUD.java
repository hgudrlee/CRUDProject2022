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
		System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
		//1 driveway
		int level = s.nextInt();
		String word = s.nextLine();
		//차고 진입로
		System.out.print("뜻 입력 : ");
		String meaning = s.nextLine();

		return new Word(list.size() + 1, level, word, meaning);
	}
	
	public void addWord() {
		Word one = (Word)add();
		list.add(one);
		System.out.println("새 단어가 단어장에 추가되었습니다. ");
	}

	@Override
	public int update(Object obj) {
		System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
		//1 driveway
		int level = s.nextInt();
		String word = s.nextLine();
		//차고 진입로
		System.out.print("뜻 입력 : ");
		String meaning = s.nextLine();
		((Word) obj).setLevel(level);
		((Word) obj).setWord(word);
		((Word) obj).setMeaning(meaning);
		System.out.println("수정 완료.");
		return 0;
	}

	@Override
	public int delete(Object obj) {
		System.out.print("=> 삭제하시겠습니까? (예:1,아니오:2) : ");
		int del = s.nextInt();
		s.nextLine();
		if (del == 1) {
			list.remove(((Word) obj).getId()-1);
			System.out.println("삭제 완료.");
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
		System.out.print("=> 난이도 (1,2,3) : ");
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
