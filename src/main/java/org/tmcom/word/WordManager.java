package org.tmcom.word;

import java.util.Scanner;

public class WordManager {
	// 멤버 변수
	Scanner s = new Scanner(System.in);
	WordCRUD wordCRUD;

	// 생성자(Constructor)
	WordManager(){
		wordCRUD = new WordCRUD(s);
	}

	// 멤버 메소드
	public void start() {
		System.out.println("*** 영단어 마스터 ***");
		while(true) {
			int menu = selectMenu();
			if (menu == 0) {
				System.out.println("프로그램 종료! 다음에 만나요~");
				break;
			}
			else if (menu == 1) {
				wordCRUD.listAll();
			}
			else if (menu == 2) {
				wordCRUD.levelAll();
			}
			else if (menu == 3) {
				System.out.print("검색할 단어의 번호 : ");
				int id = s.nextInt();
				s.nextLine();
				wordCRUD.selectOne(id);
			}
			else if (menu == 4) {
				wordCRUD.addWord();
			}
			else if (menu == 5) {
				wordCRUD.listAll();
				System.out.print("수정할 단어의 번호 : ");
				int id = s.nextInt();
				s.nextLine();
				wordCRUD.update(wordCRUD.list.get(id-1));
			}
			else if (menu == 6) {
				wordCRUD.listAll();
				System.out.print("삭제할 단어의 번호 : ");
				int id = s.nextInt();
				s.nextLine();
				wordCRUD.delete(wordCRUD.list.get(id-1));
			}
		}
	}
	
	public int selectMenu() {
		System.out.print("\n********************\n"
				+ "1. 모든 단어 보기\n"
				+ "2. 수준별 단어 보기\n"
				+ "3. 단어 검색\n"
				+ "4. 단어 추가\n"
				+ "5. 단어 수정\n"
				+ "6. 단어 삭제\n"
				+ "7. 파일 저장\n"
				+ "0. 나가기\n"
				+ "********************\n"
				+ "=> 원하는 메뉴는? ");
		
		return s.nextInt();
	}
	
	
}