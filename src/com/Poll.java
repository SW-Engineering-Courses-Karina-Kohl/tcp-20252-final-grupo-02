package com;

import java.util.ArrayList;
import java.util.Date;

public abstract class Poll {
	
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

	public void vote(User user, int optionIndex) {
		if (status && !voters.contains(user)) {
			votes.add(optionIndex);
			voters.add(user);
		} else {
			System.out.println("Usuário já votou ou a votação já foi encerrada.");
		}
	}
}
