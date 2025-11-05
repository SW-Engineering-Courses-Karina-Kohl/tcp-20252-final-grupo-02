package com;

import java.util.ArrayList;
import java.util.Date;

public class BookPoll extends Poll {
	
	private ArrayList<Book> bookOptions;
	
	public BookPoll(Date closingDate) {
		
		super(closingDate);
		
	}


	@Override
	public void vote (User user, int optionIndex) {
		super.vote(user, optionIndex);
		System.out.println("Voto registrado no livro: " + bookOptions.get(optionIndex).getTitle());
	}
}	
