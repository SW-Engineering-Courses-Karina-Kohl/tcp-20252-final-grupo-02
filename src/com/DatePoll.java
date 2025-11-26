package com;

import java.util.ArrayList;
import java.util.Date;

import org.tinylog.Logger;

public class DatePoll extends Poll {

    private ArrayList<Date> dateOptions;

     public DatePoll(Date closingDate) {
    	 
        super(closingDate);
        
        this.dateOptions = new ArrayList<>();
        
    }

    @Override
    public void vote(User user, int dateIndex) {
    	
        super.registerVote(user, dateIndex);
        
        Logger.info("Voto registrado na data: " + dateOptions.get(dateIndex) + "!");
        
    }

    public ArrayList<Date> getOptions() {
    	
        return this.dateOptions;
        
    }
    
}
