package com.model;

import java.util.ArrayList;

public class User {
	
	private int id;
	private String name;
	private String surname;
	private String email;
	private String cpf;
	private String password;
	private ArrayList<BookClub> joinedBookClubs;

	
	private static int numUsersCreated = 0;
		
	public static void setNumUsersCreated(int n) {
    numUsersCreated = n;
}

	// private static final int MAX_BOOKCLUBS_PER_USER = 20;


	public User(String name, String surname, String email, String cpf, String password) {
    	this.id = ++numUsersCreated;
    	this.name = name;
    	this.surname = surname;
    	this.email = email;
		this.cpf = cpf;
    	this.password = password;
		this.joinedBookClubs = new ArrayList<BookClub>();

}

	
	public User(int id, String name, String surname, String email, String cpf, String password) {
		
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.cpf = cpf;
		this.password = password;
		this.joinedBookClubs = new ArrayList<BookClub>();
	}

	public int getId() {
		
		return this.id;
		

	}

	
	public int setId(int newId) {
		
		return this.id = newId;
		
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
	
	public String getEmail() {
		
		return this.email;
		
	}
	
	public void setEmail(String newEmail) {
		
		this.email = newEmail;
		
	}
	

	public String getCpf() {
		
		return this.cpf;
		
	}
	
	public void setCpf(String newCpf) {
		
		this.cpf = newCpf;
		
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

	// Converte o objeto para uma String legivel	
@Override
	public String toString() {
		return String.format("User{id=%d, name='%s', surname='%s', email='%s', cpf='%s'}", id, name, surname, email, cpf);

	}
	

	public String toCsvLine() {
    	return id + "," + name + "," + surname + "," + email + "," + cpf + "," + password;
	}


}