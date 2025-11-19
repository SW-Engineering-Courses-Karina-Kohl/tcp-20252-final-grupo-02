package com;

import java.util.ArrayList;

public class User {
	
	private int id;
	private String name;
	private String surname;
	private String cpf;
	private String email;
	private String password;
	private ArrayList<BookClub> joinedBookClubs;
	
	private static int numUsersCreated = 0;
	
	// private static final int MAX_BOOKCLUBS_PER_USER = 20;
	
	public User(String name, String surname, String cpf, String email, String password) {
		
		this.id = ++numUsersCreated;
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
		this.joinedBookClubs = new ArrayList<BookClub>();
		
	}
	
	public int getId() {
		
		return this.id;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public void setName(String newName) {
		
		this.name = newName;
		
	}
	
	public String getSurname() {
		
		return this.surname;
		
	}
	
	public void setSurname(String newSurname) {
		
		this.surname = newSurname;
		
	}
	
	public String getCpf() {
		
		return this.cpf;
		
	}
	
	public void setCpf(String newCpf) {
		
		this.cpf = newCpf;
		
	}
	
	public String getEmail() {
		
		return this.email;
		
	}
	
	public void setEmail(String newEmail) {
		
		this.email = newEmail;
		
	}
	
	public String getPassword() {
		
		return this.password;
		
	}
	
	public void setPassword(String newPassword) {
		
		this.password = newPassword;
		
	}
	
	public ArrayList<BookClub> getJoinedBookClubs() {
		
		return this.joinedBookClubs;
		
	}
	
	public static int getNumUsersCreated() {
		
		return numUsersCreated;
		
	}
	
	/*
	
	public User findUser(String email) {
		
	}
	
	*/

}
