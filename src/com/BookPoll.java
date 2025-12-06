package com;

import java.util.ArrayList;
import java.util.Date;

public class BookPoll extends Poll {

    private ArrayList<Book> bookOptions;

    public BookPoll(Date closingDate) {
    	
        super(closingDate);
        
        this.bookOptions = new ArrayList<>();
        
    }

    @Override
    public void vote(User user, int bookIndex) {
    	
    	super.registerVote(user, bookIndex); 
        
    }

    public ArrayList<Book> getOptions() {
    	
        return this.bookOptions;
        
    }
    
    public void addBookOption(Book newBook) {
    	
    	this.bookOptions.add(newBook);
    	
    }
    
}
