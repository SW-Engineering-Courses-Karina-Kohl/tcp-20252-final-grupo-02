package com;

import java.util.ArrayList;
import java.util.Date;

public class DatePoll extends Poll {

    private ArrayList<Date> dateOptions;

     public DatePoll(Date closingDate) {
    	 
        super(closingDate);
        
        this.dateOptions = new ArrayList<>();
        
    }

    @Override
    public void vote(User user, int dateIndex) {
    	
        super.registerVote(user, dateIndex);
        
    }

    public ArrayList<Date> getOptions() {
    	
        return this.dateOptions;
        
    }
    
    public void addDateOption(Date newDate) {
    	
    	this.dateOptions.add(newDate);
    	
    }
    
}
