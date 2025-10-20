package com;

import java.util.ArrayList;
import java.util.Date;

public class Poll {
	
	private Date openingDate;
	private Date closingDate;
	private boolean status;
	private ArrayList<Integer> votes;
	private ArrayList<User> voters;
	
	public Poll(Date closingDate) {
		
		this.openingDate = new Date();
		this.closingDate = closingDate;
		this.status = true;
		
	}

}
