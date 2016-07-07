package trie;

import java.util.HashMap;
import java.util.Set;

public class TrieNode {
	
	private HashMap<Character, TrieNode> children;
	private String text;
	private boolean isWord;
	
	public TrieNode() {
		children = new HashMap<>();
		text = "";
		isWord = false;
	}
	
	public TrieNode(String text) {
		this();
		this.text = text;
	}
	
	/**
	 * 
	 * @param c The character that will link to the new node
	 * @return The newly created TrieNode, or null if the node is already in trie
	 */
	public TrieNode insert(Character c) {
		if(children.containsKey(c)) {
			return null;
		}
		
		TrieNode next = new TrieNode(text + c.toString());
		children.put(c, next);
		return next;
	}
	
	public TrieNode getChild(Character c) {
		return children.get(c);
	}

	public String getText() {
		return text;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setEndsWord(boolean isWord) {
		this.isWord = isWord;
	}

	public Set<Character> getValidNextCharacters() {
		return children.keySet();
	}
		
}
