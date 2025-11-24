package com;

import java.util.ArrayList;
import java.util.Date;

public class BookPoll extends Poll {

    private ArrayList<Book> bookOptions;

    public BookPoll(Date closingDate, ArrayList<Book> options) {
        super(closingDate);
        this.bookOptions = options;
    }

    @Override
    public void vote(User user, int optionIndex) {
        super.vote(user, optionIndex);
        System.out.println("Voto registrado no livro: " + bookOptions.get(optionIndex).getTitle());
    }

    public ArrayList<Book> getBookOptions() {
        return this.bookOptions;
    }
}
