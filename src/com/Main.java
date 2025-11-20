package com;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.util.logging.Logger;

import data.Constants;
import design.view.LoadingScreen;
import design.view.LoginScreen;

public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<BookClub> bookClubs = new ArrayList<BookClub>();
	private ArrayList<Meeting> meetings = new ArrayList<Meeting>();
	private ArrayList<Poll> polls = new ArrayList<Poll>();
	public ArrayList<Book> getBooks() {
		
		LOGGER.info("Lista de livros retornada com sucesso");
		
		return books;
		
	}
		
	public void createBook(Book newBook) {
		
		books.add(newBook);
		
		LOGGER.info("Livro criado com sucesso");
		
	}
		
	public void deleteBook(Book book) {
		
		books.remove(book);
		
		LOGGER.info("Livro excluído com sucesso");
		
	}
		
	public ArrayList<BookClub> getBookClubs() {
		
		LOGGER.info("Lista de clubes do livro retornada com sucesso");
		
		return bookClubs;
		
	}
		
	public void createBookClub(BookClub newBookClub) {
		
		bookClubs.add(newBookClub);
		
		LOGGER.info("Clube do livro criado com sucesso");
		
	}
		
	public void deleteBookClub(BookClub bookClub) {
		
		bookClubs.remove(bookClub);
		
		LOGGER.info("Clube do livro excluído com sucesso");
		
	}
		
	public ArrayList<Meeting> getMeetings() {
		
		LOGGER.info("Lista de encontros retornada com sucesso");
		
		return meetings;
		
	}
		
	public void createMeeting(Meeting newMeeting) {
		
		meetings.add(newMeeting);
		
		LOGGER.info("Encontro criado com sucesso");
		
	}
		
	public void deleteMeeting(Meeting meeting) {
		
		meetings.remove(meeting);
		
		LOGGER.info("Encontro excluído com sucesso");
		
	}
		
	


	public ArrayList<Poll> getPolls() {
		
		LOGGER.info("Lista de votações retornada com sucesso");
		
		return polls;
		
	}
		
	public void createPoll(Poll newPoll) {
		
		polls.add(newPoll);
		
		LOGGER.info("Votação criada com sucesso");
		
	}
		
	public void deletePoll(Poll poll) {
		
		polls.remove(poll);
		
		LOGGER.info("Votação excluída com sucesso");
		
	}
		

		
	public void createUser(User newUser) {
		
		users.add(newUser);
		
		LOGGER.info("Usuário criado com sucesso");
		
	}
		
	public void deleteUser(User user) {
		
		users.remove(user);
		
		LOGGER.info("Usuário excluído com sucesso");
		
	}
		
	
	
    public static void main(String[] args) {

        applyCustomFont();

        SwingUtilities.invokeLater(() -> {
        	
            LoadingScreen loadingScreen = new LoadingScreen();
            loadingScreen.setVisible(true);

            javax.swing.Timer timer = new javax.swing.Timer (2000, e -> {
                // Depois de 2s, abra a próxima tela
				loadingScreen.dispose();
                LoginScreen loginScreen = new LoginScreen();

                LoginController loginController = new LoginController(loginScreen);
                loginScreen.setVisible(true);
            });
			
			timer.setRepeats(false); // evita abrir várias telas
    		timer.start();

        });
    }

    private static void applyCustomFont() {
        try {
            // Caminho da fonte relativa ao projeto
            File fontFile = new File(Constants.FONT_PATH);

            // Carrega a fonte
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(16f);

            // Registra no ambiente gráfico
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            // Aplica globalmente no Swing
            setUIFont(customFont);

        } catch (FontFormatException | IOException e) {
            System.err.println("Erro ao carregar fonte: " + e.getMessage());
        }
    }

    // Torna a fonte global
    public static void setUIFont(Font font) {
        java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);

            if (value instanceof Font) {
                UIManager.put(key, font);
            }
        }
    }

}

