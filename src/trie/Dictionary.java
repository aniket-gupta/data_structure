package trie;

import java.util.List;

public class Dictionary {
	
	private TrieNode root;
	private int size;
	
	public Dictionary() {
		root = new TrieNode();
	}
	
	public boolean addWord(String word) {
		char[] chars = word.toLowerCase().toCharArray();
		TrieNode curr = root;
		boolean added = false;
		for(int i = 0; i < chars.length; i++) {
			TrieNode child = curr.getChild(chars[i]);
			if(child != null) {
				curr = child;
			} else {
				curr = curr.insert(chars[i]);
				if(i == chars.length - 1) {
					size++;
					curr.setEndsWord(true);
					added = true;
				}
			}
		}
		return added;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isWord(String s) {
		char[] chars = s.toLowerCase().toCharArray();
		TrieNode curr = root;
		for(char c : chars) {
			curr = curr.getChild(c);
			if(curr == null) {
				return false;
			}
		}
		if(curr.isWord())
			return true;
		return false;
	}
	
	public List<String> predictions(String prefix, int maxNumPrediction) {
		return null;
	}
}
