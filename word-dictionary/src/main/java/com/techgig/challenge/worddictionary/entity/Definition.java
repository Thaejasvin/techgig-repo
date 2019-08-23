package com.techgig.challenge.worddictionary.entity;

import org.springframework.stereotype.Component;

@Component
public class Definition {
	
	String word;
	String definition;
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public Definition(String word, String definition) {
		super();
		this.word = word;
		this.definition = definition;
	}
	
	@Override
	public String toString() {
		return "Definition [word=" + word + ", definition=" + definition + "]";
	}
	
	public Definition() {
		
	}
}
