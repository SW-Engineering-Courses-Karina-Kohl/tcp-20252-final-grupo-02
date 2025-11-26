package com;

import java.util.ArrayList;
import java.util.Date;

import org.tinylog.Logger;

public class BookPoll extends Poll {

    private ArrayList<Book> bookOptions;

    public BookPoll(Date closingDate) {
    	
        super(closingDate);
        
        this.bookOptions = new ArrayList<>();
        
    }

    @Override
    public void vote(User user, int bookIndex) {
    	
        super.registerVote(user, bookIndex);
        
        Logger.info("Voto registrado no livro " + bookOptions.get(bookIndex).getTitle() + "!");
        
    }

    public ArrayList<Book> getOptions() {
    	
        return this.bookOptions;
        
    }
    
}
