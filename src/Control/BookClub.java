package Control;

import java.util.ArrayList;

public class BookClub {
	
	private int id;
	private Creator creator;
	private String name;
	private ArrayList<User> participants;
	private ArrayList<Poll> polls;
	private ArrayList<Meeting> meetings;
	private static int numBookClubsCreated = 0;
	
	public BookClub(Creator creator, String name) {
		
		this.id = ++numBookClubsCreated;
		this.creator = creator;
		this.name = name;
		
	}

}
