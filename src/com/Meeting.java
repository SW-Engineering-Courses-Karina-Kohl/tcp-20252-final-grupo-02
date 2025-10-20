package com;

import java.util.ArrayList;
import java.util.Date;

public class Meeting {
	
	private Creator creator;
	private ArrayList<User> participants;
	private String type;
	private Date date;
	private String local;
	
	public Meeting(Creator creator, String type, Date date, String local) {
		
		this.creator = creator;
		this.type = type;
		this.date = date;
		this.local = local;
		
	}

}
