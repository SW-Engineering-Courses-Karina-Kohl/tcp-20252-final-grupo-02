package com;

import java.util.ArrayList;

import javax.swing.JOptionPane;



import com.model.Book;
import com.model.BookClub;
import com.service.*;

import design.view.LoginScreen;
import design.view.RegistrationScreen;

public class AppSystem {
    
    private RegistrationScreen regScreen;
    private UserService userService;
	private BookService bookService;
    private PollService pollService;
    private MeetingService meetingService;



    public AppSystem(RegistrationScreen regScreen) {
    
        this.bookService = new BookService();
        this.meetingService = new MeetingService();
        this.pollService = new PollService();
        this.regScreen = regScreen;
        this.userService = new UserService();


    }

    public AppSystem() {
        this.userService = new UserService();

        this.bookService = new BookService();
        this.pollService = new PollService();
        this.meetingService = new MeetingService();

    }


	public void initRegistrationController() {

    // Botão cadastrar
    regScreen.btnCadastrar.addActionListener(e -> {
        String nome = regScreen.txtNome.getText();
        String sobrenome = regScreen.txtSobrenome.getText();
        String email = regScreen.txtEmail.getText();
        String cpf = regScreen.txtCpf.getText();
        String senha = new String(regScreen.txtSenha.getPassword());
        String confirmar = new String(regScreen.txtConfirmarSenha.getPassword());

        boolean ok = userService.registerUser(nome, sobrenome, email, cpf, senha, confirmar);

        if (ok) {
            JOptionPane.showMessageDialog(regScreen, "Usuário cadastrado com sucesso!");
            regScreen.dispose();
            new LoginScreen().setVisible(true);LoginScreen loginScreen = new LoginScreen();
            new LoginController(loginScreen);
            loginScreen.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(regScreen, "Erro ao cadastrar usuário!");
                }
    });

    // Botão voltar
    regScreen.btnBackButton.addActionListener(e -> {
        regScreen.dispose();
        
        LoginScreen loginScreen = new LoginScreen();
        new LoginController(loginScreen);
        loginScreen.setVisible(true);
        
    });
}




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
        pollService.createPollForBookClub(club, "BOOK", question, options);
    }

    public void createDatePoll(BookClub club, String question, ArrayList<String> options) {
        pollService.createPollForBookClub(club, "DATE", question, options);
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








