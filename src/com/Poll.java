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
		this.votes = new ArrayList<>();
		this.voters = new ArrayList<>();
	}

	public void open() {
		this.status = true;
		this.openingDate = new Date();
	}

	public void close() {
		this.status = false;
	}
	
	public boolean isOpen() {
		return this.status;
	}

	public void addVoter(User user) {
		if (!voters.contains(user)) {	
			voters.add(user);
		}
	}	

	public ArrayList<User> getVoters() {
		return voters;
	}

	public void vote(User user, int optionIndex) {
		if (status && !voters.contains(user)) {
			votes.add(optionIndex);
			voters.add(user);
		} else {
			System.out.println("Usuário já votou ou a votação já foi encerrada.");
		}
	}

	public Date getOpeningDate() {
		return openingDate;
	}
	public Date getClosingDate() {
		return closingDate;
	}
}
