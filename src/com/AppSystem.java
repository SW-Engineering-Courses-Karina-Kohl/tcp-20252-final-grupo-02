package com;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.tinylog.Logger;


import com.model.Book;
import com.model.BookClub;
import com.model.BookPoll;
import com.model.DatePoll;
import com.model.Meeting;
import com.model.Poll;
import com.model.User;
import com.service.*;

import design.view.LoginScreen;
import design.view.RegistrationScreen;

public class AppSystem {
    
    private RegistrationScreen regScreen;
    private ArrayList<User> users;
    private ArrayList<Book> books;
	private ArrayList<BookClub> bookClubs;
	private ArrayList<Meeting> meetings;
	private ArrayList<Poll> polls;
    private UserService userService;
	private BookService bookService;
    private PollService pollService;
    private MeetingService meetingService;



    public AppSystem(RegistrationScreen regScreen) {
        this.users = new ArrayList<User>();
        //this.bookClubs = new ArrayList<BookClub>();
        this.bookService = new BookService();
        this.meetingService = new MeetingService();
        this.pollService = new PollService();
        this.regScreen = regScreen;
        this.userService = new UserService();

        //initController();
        // Carrega os arrays com os arquivos toda vez que o programa é iniciado


    }

    public AppSystem() {
        this.users = new ArrayList<User>();
        this.books = new ArrayList<Book>();
        this.bookClubs = new ArrayList<BookClub>();
        this.meetings = new ArrayList<Meeting>();
        this.polls = new ArrayList<Poll>();
        this.userService = new UserService();

        //this.bookClubs = new ArrayList<BookClub>();
        this.bookService = new BookService();
        this.pollService = new PollService();
        this.meetingService = new MeetingService();

    }


	/*private void initController() {
        regScreen.btnBackButton.addActionListener(e -> {
            System.out.println("click");
            regScreen.dispose();
            LoginScreen loginScreen = new LoginScreen();
            LoginController loginController = new LoginController(loginScreen);
            loginScreen.setVisible(true);
        });
        regScreen.btnCadastrar.addActionListener(e -> UserService.registerUser(regScreen));
    } */



    public void printUsers() {
        userService.printUsers();
    }



    public boolean alterPassword(String email, String newPassword, String passwordConfirmation) {
        return userService.alterPassword(email, newPassword, passwordConfirmation);
    }

    public PollService getPollService() {
        return pollService;
    }

    public MeetingService getMeetingService() {
        return meetingService;
    }
    

    public void createBookPoll(BookClub club, String question, ArrayList<String> options) {
        BookPoll poll = new BookPoll(club, question, options);
        pollService.addPoll(poll);
        club.getPolls().add(poll);
    }

    public void createDatePoll(BookClub club, String question, ArrayList<String> options) {
        DatePoll poll = new DatePoll(club, question, options);
        pollService.addPoll(poll);
        club.getPolls().add(poll);
    }   

    // Chamada de BookService 
    public ArrayList<Book> getBooks() {
        return bookService.getBooks();
    }

    public Book findBookByIsbn(String isbn) {
        return bookService.findBookByIsbn(isbn);
    }

    public boolean registerBook(String title, String author, String isbn,
                                int releaseYear, int numPages, String genre) {
        return bookService.registerBook(title, author, isbn, releaseYear, numPages, genre);
    }

    public void printBooks() {
        bookService.printBooks();
    }

    public void deleteBook(Book b) {
        bookService.deleteBook(b);
    }

}








