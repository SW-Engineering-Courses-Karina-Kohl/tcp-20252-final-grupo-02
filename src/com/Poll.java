package com;

import java.util.ArrayList;
import java.util.Date;

public class Poll {
	
	private int id;
	private Date openingDate;
	private Date closingDate;
	private boolean status;
	private ArrayList<Integer> votes;
	private ArrayList<User> voters;
	
	private static int numPollsCreated = 0;
	
	public Poll(Date closingDate) {
		
		this.id = ++numPollsCreated;
		this.openingDate = new Date();
		this.closingDate = closingDate;
		this.status = true;
		this.votes = new ArrayList<Integer>();
		this.voters = new ArrayList<User>();
		
	}
	
	public int getId() {
		
		return this.id;
		
	}
	
	public Date getOpeningDate() {
		
		return this.openingDate;
		
	}
	
	public Date getClosingDate() {
		
		return this.closingDate;
		
	}
	
	public boolean getStatus() {
		
		return this.status;
		
	}
	
	public ArrayList<Integer> getVotes() {
		
		return this.votes;
		
	}
	
	public ArrayList<User> getVoters() {
		
		return this.voters;
		
	}
	
	public static int getNumPollsCreated() {
		
		return numPollsCreated;
		
	}

}
