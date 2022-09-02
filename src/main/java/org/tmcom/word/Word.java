package com.mycom.word;

public class Word {
	private int id;
	private int level;
	private String word;
	private String meaning;
	
	Word(){}
	Word(int id, int level, String word, String meaning) {
		this.id = id;
		this.level = level;
		this.word = word;
		this.meaning = meaning;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}
	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}
	/**
	 * @return the meaning
	 */
	public String getMeaning() {
		return meaning;
	}
	/**
	 * @param meaning the meaning to set
	 */
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String slevel = "";
		for (int i = 0; i < level; i++) slevel += "*";
		String str = String.format("%-3s", slevel)
				+ String.format("%15s", word) + "  " + meaning;
		return str;
	}
	
	
}
