package com;
import java.util.ArrayList;
import java.util.Date;

public class Meeting {
	
	private int id;
	private Creator creator;
	private ArrayList<User> participants;
	private String type;
	private Date date;
	private String location;
	
	private static int numMeetingsCreated = 0;
	
	public Meeting(Creator creator, String type, Date date, String location) {
		
		this.id = ++numMeetingsCreated;
		this.creator = creator;
		this.participants = new ArrayList<User>();
		this.type = type;
		this.date = date;
		this.location = location;
		
	}
	
	public int getId() {
		
		return this.id;
		
	}
	
	public Creator getCreator() {
		
		return this.creator;
		
	}
	
	public ArrayList<User> getParticipants() {
		
		return this.participants;
		
	}
	
	public String getType() {
		
		return this.type;
		
	}
	
	public Date getDate() {
		
		return this.date;
		
	}
	
	public String getLocation() {
		
		return this.location;
		
	}
	
	public static int getNumMeetingsCreated() {
		
		return numMeetingsCreated;
		
	}

}