package com.model;

import java.util.ArrayList;

public class DatePoll extends Poll {

    public DatePoll(BookClub club, String question, ArrayList<String> options) {
        super(club, question, options);
    }

    public DatePoll(int id, BookClub club, String question, ArrayList<String> options, int[] votes) {
        super(id, club, question, options, votes);
    }

    @Override
    public String getType() {
        return "DATE";
    }
}
