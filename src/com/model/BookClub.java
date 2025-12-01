package com.model;

import java.util.ArrayList;


public class BookClub {
	
	private int id;
	private String name;
	private ArrayList<User> participants;
	private ArrayList<Poll> polls;
	private ArrayList<Meeting> meetings;
	private User creator;
	
	
	private static int numBookClubsCreated = 0;
	
	public BookClub(User creator, String name) {
		
		this.id = ++numBookClubsCreated;
		this.creator = creator;
		this.name = name;
		this.participants = new ArrayList<User>();
		this.polls = new ArrayList<Poll>();
		this.meetings = new ArrayList<Meeting>();
		creator.getCreatedBookClubs().add(this); 

	}

		public BookClub(int id, User creator, String name) {
		
		this.id = id;
		this.creator = creator;
		this.name = name;
		this.participants = new ArrayList<User>();
		this.polls = new ArrayList<Poll>();
		this.meetings = new ArrayList<Meeting>();
		creator.getCreatedBookClubs().add(this); 

	}


	
	public int getId() {
		
		return this.id;
		
	}
	
	public User getCreator() {
		
		return this.creator;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public void setName(String newName) {
		
		this.name = newName;
		
	}
	
	public ArrayList<User> getParticipants() {
		
		return this.participants;
		
	}
	
	public ArrayList<Poll> getPolls() {
		
		return this.polls;
		
	}
	
	public ArrayList<Meeting> getMeetings() {
		
		return this.meetings;
		
	}
	
	public static int getNumBookClubsCreated() {
		
		return numBookClubsCreated;
		
	}
	
	public void addPoll(Poll p) {
        if (!polls.contains(p)) {
            polls.add(p);

            // Tambem adiciona o bookclub na pool
            if (p.getBookClub() != this) {
                p.setBookClub(this);
            }
        }
    }



		// Converte o objeto para uma String legivel	
@Override
	public String toString() {

    String participantsIds = "";
    for (User u : participants) {
        if (!participantsIds.isEmpty()) participantsIds += ";";
        participantsIds += u.getId();
    }

    String pollsIds = "";
    for (Poll p : polls) {
        if (!pollsIds.isEmpty()) pollsIds += ";";
        pollsIds += p.getId();
    }

    String meetingsIds = "";
    for (Meeting m : meetings) {
        if (!meetingsIds.isEmpty()) meetingsIds += ";";
        meetingsIds += m.getId();
    }

    return String.format(
        "BookClub{id=%d, creatorId=%d, name='%s', participants=[%s], polls=[%s], meetings=[%s]}",
        id, creator.getId(), name, participantsIds, pollsIds, meetingsIds
    );
}
	


	public String toCsvLine() {

		
		int creatorId = creator.getId();

		// guarda a lista de IDs dos participantes
		String participantsCsv = "";
		for (User u : participants) {
			if (!participantsCsv.isEmpty()) participantsCsv += ";";
			participantsCsv += u.getId();
		}

		// guarda a lista de IDs das votações
		String pollsCsv = "";
		for (Poll p : polls) {
			if (!pollsCsv.isEmpty()) pollsCsv += ";";
			pollsCsv += p.getId();
		}

		// o mesmo para as meetings
		String meetingsCsv = "";
		for (Meeting m : meetings) {
			if (!meetingsCsv.isEmpty()) meetingsCsv += ";";
			meetingsCsv += m.getId();
		}

		return id + "," +
			creatorId + "," +
			name + "," +
			participantsCsv + "," +
			pollsCsv + "," +
			meetingsCsv;
	}

}