package com;

import java.util.ArrayList;
import java.util.Date;

public class DatePoll extends Poll {

    private ArrayList<Date> dateOptions;

    public DatePoll(Date closingDate, ArrayList<Date> options) {
        super(closingDate);
        this.dateOptions = options;
    }

    @Override
    public void vote(User user, int optionIndex) {
        super.vote(user, optionIndex);
        System.out.println("Voto registrado na data: " + dateOptions.get(optionIndex));
    }

    public ArrayList<Date> getDateOptions() {
        return this.dateOptions;
    }
}
