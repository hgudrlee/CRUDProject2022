package com.mycom.word;

import java.util.Scanner;

public class WordManager {
	Scanner s = new Scanner(System.in);
	WordCRUD wordCRUD;
	
	WordManager(){
		wordCRUD = new WordCRUD(s);
	}
	
	public void start() {
		while(true) {
			int menu = selectMenu();
			if (menu == 0) {
				System.out.println("����.");
				break;
			}
			else if (menu == 1) {
				wordCRUD.listAll();
			}
			else if (menu == 2) {
				wordCRUD.levelAll();
			}
			else if (menu == 3) {
				System.out.print("�˻��� �ܾ��� ��ȣ : ");
				int id = s.nextInt();
				s.nextLine();
				wordCRUD.selectOne(id);
			}
			else if (menu == 4) {
				wordCRUD.addWord();
			}
			else if (menu == 5) {
				wordCRUD.listAll();
				System.out.print("������ �ܾ��� ��ȣ : ");
				int id = s.nextInt();
				s.nextLine();
				wordCRUD.update(wordCRUD.list.get(id-1));
			}
			else if (menu == 6) {
				wordCRUD.listAll();
				System.out.print("������ �ܾ��� ��ȣ : ");
				int id = s.nextInt();
				s.nextLine();
				wordCRUD.delete(wordCRUD.list.get(id-1));
			}
		}
	}
	
	public int selectMenu() {
		System.out.print("*** ���ܾ� ������ ***\n"
				+ "********************\n"
				+ "1. ��� �ܾ� ����\n"
				+ "2. ���غ� �ܾ� ����\n"
				+ "3. �ܾ� �˻�\n"
				+ "4. �ܾ� �߰�\n"
				+ "5. �ܾ� ����\n"
				+ "6. �ܾ� ����\n"
				+ "7. ���� ����\n"
				+ "0. ������\n"
				+ "********************\n"
				+ "=> ���ϴ� �޴���? ");
		
		return s.nextInt();
	}
	
	
}