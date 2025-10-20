package com;

import java.util.ArrayList;

public class User {
	
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private ArrayList<BookClub> joinedBookClubs;
	private static final int MAX_BOOKCLUBS_PER_USER = 20;
	private static int numUsersCreated = 0;
	
	public User(String name, String surname, String email, String password) {
		
		this.id = ++numUsersCreated;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		
	}

}
