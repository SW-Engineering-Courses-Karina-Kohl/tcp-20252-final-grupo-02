package com.model;

import java.util.ArrayList;

public class BookPoll extends Poll {

    public BookPoll(BookClub club, String question, ArrayList<String> options) {
        super(club, question, options);
    }

    public BookPoll(int id, BookClub club, String question, ArrayList<String> options, int[] votes) {
        super(id, club, question, options, votes);
    }

    @Override
    public String getType() {
        return "BOOK";
    }
}
