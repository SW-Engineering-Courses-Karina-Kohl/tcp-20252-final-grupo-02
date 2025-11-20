package com;

import java.util.ArrayList;
import java.util.Date;

public class BookPoll extends Poll {
	
	private ArrayList<Book> options;
	
	public BookPoll(Date closingDate) {
		
		super(closingDate);
		
		this.options = new ArrayList<Book>();
		
	}
	
	public ArrayList<Book> getOptions() {
		
		return this.options;
		
	}

}
