package com.model;

import java.util.ArrayList;
import java.util.Date;

public class BookPoll extends Poll {

    private ArrayList<Book> bookOptions;

  public BookPoll(Date closingDate) {
        super(closingDate);
        this.bookOptions = new ArrayList<>();
    }


    @Override
    public void vote(User user, int optionIndex) {
        super.registerVote(user, optionIndex);
        System.out.println("Voto registrado no livro: " + bookOptions.get(optionIndex).getTitle());
    }


    public ArrayList<Book> getOptions() {
        return this.bookOptions;
    }
}
