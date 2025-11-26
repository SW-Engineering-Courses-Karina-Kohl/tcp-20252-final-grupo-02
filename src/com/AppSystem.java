package com;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.tinylog.Logger;

import design.view.LoginScreen;
import design.view.RegistrationScreen;

public class AppSystem {
    
    private RegistrationScreen regScreen;
    private ArrayList<User> users;
    private ArrayList<Book> books;
	private ArrayList<BookClub> bookClubs;
	private ArrayList<Meeting> meetings;
	private ArrayList<Poll> polls;

    public AppSystem(RegistrationScreen regScreen) {
    	
        this.users = new ArrayList<User>();
        this.books = new ArrayList<Book>();
        this.bookClubs = new ArrayList<BookClub>();
        this.meetings = new ArrayList<Meeting>();
        this.polls = new ArrayList<Poll>();
        
        this.regScreen = regScreen;
        
        initController();
        readUsers();
        readBooks();
        
    }

    public AppSystem() {
    	
        this.users = new ArrayList<User>();
        this.books = new ArrayList<Book>();
        this.bookClubs = new ArrayList<BookClub>();
        this.meetings = new ArrayList<Meeting>();
        this.polls = new ArrayList<Poll>();
        
    }

    public ArrayList<Book> getBooks() {
		
		Logger.info("Lista de livros retornada com sucesso");
		
		return books;
		
	}
	
	public void createBook(Book newBook) {
		
		books.add(newBook);
		
		Logger.info("Livro criado com sucesso");
		
	}
	
	public void deleteBook(Book book) {
		
		books.remove(book);
		
		Logger.info("Livro excluído com sucesso");
		
	}
	
	public ArrayList<BookClub> getBookClubs() {
		
		Logger.info("Lista de clubes do livro retornada com sucesso");
		
		return bookClubs;
		
	}
	
	public void createBookClub(BookClub newBookClub) {
		
		bookClubs.add(newBookClub);
		
		Logger.info("Clube do livro criado com sucesso");
		
	}
	
	public void deleteBookClub(BookClub bookClub) {
		
		bookClubs.remove(bookClub);
		
		Logger.info("Clube do livro excluído com sucesso");
		
	}
	
	public ArrayList<Meeting> getMeetings() {
		
		Logger.info("Lista de encontros retornada com sucesso");
		
		return meetings;
		
	}
	
	public void createMeeting(Meeting newMeeting) {
		
		meetings.add(newMeeting);
		
		Logger.info("Encontro criado com sucesso");
		
	}
	
	public void deleteMeeting(Meeting meeting) {
		
		meetings.remove(meeting);
		
		Logger.info("Encontro excluído com sucesso");
		
	}

	public ArrayList<Poll> getPolls() {
		
		Logger.info("Lista de votações retornada com sucesso");
		
		return polls;
		
	}
	
	public void createPoll(Poll newPoll) {
		
		polls.add(newPoll);
		
		Logger.info("Votação criada com sucesso");
		
	}
	
	public void deletePoll(Poll poll) {
		
		polls.remove(poll);
		
		Logger.info("Votação excluída com sucesso");
		
	}
	
	public ArrayList<User> getUsers() {
		
		Logger.info("Lista de usuários retornada com sucesso");
		
		return users;
		
	}
	
	public void createUser(User newUser) {
		
		users.add(newUser);
		
		Logger.info("Usuário criado com sucesso");
		
	}
	
	public void deleteUser(User user) {
		
		users.remove(user);
		
		Logger.info("Usuário excluído com sucesso");
		
	}

    private void initController() {
    	
        regScreen.btnSignin.addActionListener(e -> registerUser(regScreen));
        
    }

    public ArrayList<User> readUsers() {
    	
        File usersFile = new File("src/data/files/Users.csv");
        
        users.clear();
        
        if (!usersFile.exists()) {
        	
            Logger.info("Arquivo de usuários não encontrado. Criando um novo arquivo...");
            
            return users;
            
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
        	
            String line = "";
            
            while ((line = reader.readLine()) != null) {     
            	
                String[] parts = line.split(",", -1);
                
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1];
                String surname = parts[2];
                String email = parts[3];
                String cpf = parts[4];
                String password = parts[5];

                User newUser = new User(id, name, surname, email, cpf, password);
                
                users.add(newUser);
                
            }
            
        } catch (IOException exception) {
        	
            Logger.error("Erro ao ler o arquivo de usuários: " + exception.getMessage());
            
        }

        Logger.info("Usuários encontrados: " + users.size());
        
        return users;
        
    }

    public User findUserByEmail(String email) {
    	
        for (User user : users) if (user.getEmail().equals(email)) return user;

        return null;   
        
    }

    public void registerUser(RegistrationScreen regScreen) {

        String name = regScreen.txtName.getText();
        String surname = regScreen.txtSurname.getText();
        String cpf = regScreen.txtCpf.getText();
        String password = new String(regScreen.txtPassword.getPassword());
        String passwordConfirmation = new String(regScreen.txtConfirmPassword.getPassword());
        String email = regScreen.txtEmail.getText();
        
        if (!(password.equals(passwordConfirmation))) {
        	
        	Logger.error("As senhas não coincidem!");
        	
        	return;
        	
        }

        if (findUserByEmail(email) != null) {
        	
            Logger.error("Endereço de e-mail já registrado!");
            
            return;
            
        }
        
        User newUser = new User(name, surname, email, cpf, password);
        users.add(newUser);

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/files/Users.csv", true))) {
        	
            writer.println(newUser.getId() + "," + name + "," + surname + "," + email + "," + cpf + "," + password);
            
        } catch (IOException e) {
        	
            Logger.error("Erro ao salvar usuário em arquivo: " + e.getMessage());
            
        }

        Logger.info("Usuário registrado com sucesso!");
        
        regScreen.dispose();
    
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        
        LoginController loginController = new LoginController(loginScreen);
   
    }

    public void printAllUsers() {
       
    	for (User user : users) System.out.println(user);
            
    }
    
    public boolean changePassword(String email, String newPassword, String passwordConfirmation) {
    	
        if (!newPassword.equals(passwordConfirmation)) {
        	
            Logger.error("As senhas não coincidem!");
            
            return false;
            
        }

        boolean userFound = false;

        for (User user : users) {
        	
            if (user.getEmail().equals(email)) {
            	
                user.setPassword(newPassword);
                userFound = true;
                
                break;
                
            }
            
        }

        if (!userFound) {
        	
            Logger.error("Usuário não encontrado!");
            
            return false;
            
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/files/Users.csv"))) {
        	
        	for (User u : users) writer.println(u.toCsvLine());
               
        } catch (IOException e) {
        	
            Logger.error("Erro ao atualizar a senha no arquivo CSV: " + e.getMessage());
            
            return false;
            
        }
        
        return true;
        
    }

    public Book findBookByIsbn(String isbn) {
    	
        for (Book book : books) {
        	
            if (book.getIsbn().equals(isbn)) return book;

        }
        
        return null;
        
    }
    
    public ArrayList<Book> readBooks() {
        
    	File booksFile = new File("books.txt");
        
        books.clear();

        if (!booksFile.exists()) {
        	
            Logger.info("Arquivo de livros não encontrado. Criando um novo arquivo...");
            
            return books;
            
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(booksFile))) {
        	
            String line = "";
            
            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(",", -1);
                String id = parts[0];
                String title = parts[1];
                String author = parts[2];
                String isbn = parts[3];               
                String releaseYear = parts[4];
                String numPages = parts[5];   
                String genre = parts[6];

                Book newBook = new Book(
                    Integer.parseInt(id.trim()),
                    title, 
                    author, 
                    isbn, 
                    Integer.parseInt(releaseYear.trim()), 
                    Integer.parseInt(numPages.trim()), 
                    genre
                );
                
                books.add(newBook);
                
            }
            
        } catch (IOException e) {
        	
            Logger.error("Erro ao ler o arquivo de livros: " + e.getMessage());
            
        }
        
        return books;
        
    }
    
    public boolean registerBook(String title, String author, String isbn, int releaseYear, int numPages, String genre) {
        
        if (findBookByIsbn(isbn) != null) {
        	
            Logger.error("Livro com o mesmo ISBN informado já cadastrado!");
            
            return false;
            
        }
        
        Book newBook = new Book(title, author, isbn, releaseYear, numPages, genre);
        books.add(newBook);    

        try (PrintWriter writer = new PrintWriter(new FileWriter("books.txt", true))) {
        	
            writer.println(newBook.getId() + "," + title +  "," + author + "," + isbn + "," + releaseYear + "," + numPages + "," + genre);
            
        } catch (IOException e) {
        	 
            Logger.error("Erro ao salvar livro em arquivo: " + e.getMessage());
            
        }

        Logger.info("Livro registrado com sucesso!");

        return true;
    
    }
    
    public void printAllBooks() {
    	
        for (Book book : books) System.out.println(book);
        
    }
    
}
