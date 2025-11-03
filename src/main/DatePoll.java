package main;

import java.util.ArrayList;
import java.util.Date;

public class DatePoll extends Poll {

	private ArrayList<Date> options;
	
	public DatePoll(Date closingDate) {
		
		super(closingDate);
		
		this.options = new ArrayList<Date>();
		
	}
	
	public ArrayList<Date> getOptions() {
		
		return this.options;
		
	}

}
