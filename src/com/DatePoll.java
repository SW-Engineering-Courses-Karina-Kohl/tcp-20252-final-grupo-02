package com;

import java.util.ArrayList;
import java.util.Date;

public class DatePoll extends Poll {

	private ArrayList<Date> dateOptions;
	
	public DatePoll(Date closingDate) {
		
		super(closingDate);
		
	}

	@Override
	public void vote(User user, int optionIndex) {
    	super.vote(user, optionIndex);
    	System.out.println("Usuário votou na data: " + dateOptions.get(optionIndex));
}

}
