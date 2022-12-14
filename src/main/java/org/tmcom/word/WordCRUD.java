package org.tmcom.word;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
스터디 : implements의 가장 큰 특징은 이렇게 부모의 메소드를 반드시 오버라이딩(재정의)해야 한다.
WordCRUD는 인터페이스 ICRUD를 구현하는 함수 구현부이다.
 */
public class WordCRUD implements ICRUD {
	// 멤버 변수
	ArrayList<Word> list; // ArrayList는 자바의 List 인터페이스를 상속받은 여러 클래스 중 하나이다.
	Scanner s; // Scanner는 사용자로부터 입력을 받기 위한 클래스이다.
	final String fname = "Dictionary.txt";

	// 생성자(Constructor) : 인스턴스를 생성해주는 역할, 객체를 초기화한다.
	WordCRUD(Scanner s) {
		list = new ArrayList<>();
		this.s = s;
	}

	// 멤버 메소드
	@Override
	public Object add() {
		System.out.print("\n=> 난이도(1,2,3) & 새 단어 입력 : ");
		int level = s.nextInt();
		String word = s.nextLine().trim();
		System.out.print("뜻 입력 : ");
		String meaning = s.nextLine();

		return new Word(list.size() + 1, level, word, meaning);
	}

	public void addItem() {
		Word one = (Word) add();
		list.add(one);
		System.out.println("\n새 단어가 단어장에 추가되었습니다. ");
	}

	@Override
	public int update(Object obj) {
		System.out.print("\n=> 난이도(1,2,3) & 새 단어 입력 : ");
		int level = s.nextInt();
		String word = s.nextLine();
		System.out.print("뜻 입력 : ");
		String meaning = s.nextLine();
		((Word) obj).setLevel(level);
		((Word) obj).setWord(word);
		((Word) obj).setMeaning(meaning);
		System.out.println("\n수정 완료.");
		return 0;
	}

	@Override
	public int delete(Object obj) {
		System.out.print("\n=> 삭제하시겠습니까? (예:1,아니오:2) : ");
		int del = s.nextInt();
		s.nextLine();
		if (del == 1) {
			list.remove(((Word) obj).getId() - 1);
			System.out.println("\n삭제 완료.");
			return 1;
		}
		return 0;
	}

	@Override
	public void selectOne(int id) {
		System.out.println("\n-------------------------");
		System.out.print(id + " ");
		System.out.println(list.get(id - 1).toString());
		System.out.println("-------------------------\n");

	}

	public void listAll() {
		System.out.println("\n-------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.print((i + 1) + " ");
			System.out.println(list.get(i).toString());
		}
		System.out.println("-------------------------\n");
	}

	public void searchLevel() {
		System.out.print("\n=> 원하는 레벨은? (1~3) ");
		int level = s.nextInt();
		listAll(level);
	}

	public void searchWord() {
		System.out.print("\n=> 원하는 단어는? ");
		String keyword = s.next();
		listAll(keyword);
	}

	public ArrayList<Integer> listAll(String keyword) {

		ArrayList<Integer> idlist = new ArrayList<>();
		int j = 0;
		System.out.println("\n-------------------------");
		for (int i = 0; i < list.size(); i++) {
			String word = list.get(i).getWord();
			if (!word.contains(keyword)) continue;
			System.out.print((j + 1) + " ");
			System.out.println(list.get(i).toString());
			idlist.add(i);
			j++;
		}
		System.out.println("-------------------------\n");
		return idlist;
	}

	public void listAll(int level) {
		int j = 0;
		System.out.println("\n-------------------------");
		for (int i = 0; i < list.size(); i++) {
			int ilevel = list.get(i).getLevel();
			if (ilevel != level) continue;
			System.out.print((j + 1) + " ");
			System.out.println(list.get(i).toString());
			j++;
		}
		System.out.println("-------------------------\n");
	}

	public void updateItem() {
		System.out.print("=> 수정할 단어 검색 : ");
		String keyword = s.next();
		ArrayList<Integer> idlist = this.listAll(keyword);
		System.out.print("=> 수정할 번호 선택 : ");
		int id = s.nextInt();
		s.nextLine();

		System.out.print("=> 뜻 입력 : ");
		String meaning = s.nextLine();
		Word word = list.get(idlist.get(id - 1));
		word.setMeaning(meaning);
		System.out.println("단어가 수정되었습니다. ");
	}

	public void deleteItem() {
		System.out.print("=> 삭제할 단어 검색 : ");
		String keyword = s.next();
		ArrayList<Integer> idlist = this.listAll(keyword);
		System.out.print("=> 삭제할 번호 선택 : ");
		int id = s.nextInt();
		s.nextLine();

		System.out.print("=> 정말로 삭제하실래요?(Y/n) ");
		String ans = s.next();
		if (ans.equalsIgnoreCase("y")) {
			list.remove((int) idlist.get(id - 1));
			System.out.println("단어가 삭제되었습니다. ");
		} else {
			System.out.println("취소되었습니다. ");
		}
	}

	public void loadFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fname));
			String line;
			int count = 0;

			while (true) {
				line = br.readLine();
				if (line == null) break;

				String data[] = line.split("\\|");
				int level = Integer.parseInt(data[0]);
				String word = data[1];
				String meaning = data[2];
				list.add(new Word(0, level, word, meaning));
				count++;
			}
			br.close();
			System.out.println("==> " + count + "개 로딩 완료!!!");

		} catch (FileNotFoundException e) {
			try {
				PrintWriter pr = new PrintWriter(new FileWriter(fname));
				return;
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void saveFile() {
		try {
			PrintWriter pr = new PrintWriter(new FileWriter(fname));
			for (Word one : list) {
				pr.write(one.toFileString() + "\n");
			}
			pr.close();
			System.out.println("==> 데이터 저장 완료 !!!");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}