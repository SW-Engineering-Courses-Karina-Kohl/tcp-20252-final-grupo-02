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
        // Carrega os arrays com os arquivos toda vez que o programa é iniciado
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
    



// Funções para usuário 

    private void initController() {
        regScreen.btnCadastrar.addActionListener(e -> registerUser(regScreen));
    }



    public ArrayList<User> readUsers() {
        File f = new File("users.txt");
        //Garante que a lista de usuários está vazia antes de ler
        users.clear();
        if (!f.exists()) {
            System.out.println("Users file not found. Creating users file.");
            return users;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line = "";
            while ((line = reader.readLine()) != null) {                
                // Esse -1 preserva campos vazios
                String[] parts = line.split(",", -1);
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1];
                String surname = parts[2];
                String email = parts[3];
                String cpf = parts[4];
                String password = parts[5];

                User u = new User(id, name, surname, email, cpf, password);
                users.add(u);
            }
        } catch (IOException e) {
            System.out.println("Error at reading users: " + e.getMessage());
        }

        System.out.println("Total users: " + users.size());
        return users;
    }



    public User findUserByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;    
    }



    public void registerUser(RegistrationScreen regScreen) {

        String nome = regScreen.txtNome.getText();
        String sobrenome = regScreen.txtSobrenome.getText();
        String cpf = regScreen.txtCpf.getText();
        String password = new String(regScreen.txtSenha.getPassword());
        String passwordConfirmation = new String(regScreen.txtConfirmarSenha.getPassword());
        String email = regScreen.txtEmail.getText();
        

        if(!(password.equals(passwordConfirmation))) {
            System.out.println("Password and confirmation do not match.");    
        }

        if(findUserByEmail(email) != null) {
            System.out.println("Email already registered.");
            return;
        }
        
        User newUser = new User(nome, sobrenome, email, cpf, password);
        users.add(newUser);

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/files/Users.csv", true))) {
            writer.println(newUser.getId() + "," + nome + "," + sobrenome + "," + email + "," + cpf + "," + password);
        }

         catch (IOException e) {
            System.out.println("Erro ao salvar usuário em CSV: " + e.getMessage());
        }

    System.out.println("User registered successfully.");
    regScreen.dispose();
    LoginScreen loginScreen = new LoginScreen();
    LoginController loginController = new LoginController(loginScreen);
    loginScreen.setVisible(true);
}



    public void printUsers() {
        for (User u : users) {
            System.out.println(u);
        }
    }



    public boolean alterPassword(String email, String newPassword, String passwordConfirmation) {
        if (!newPassword.equals(passwordConfirmation)) {
            System.out.println("A nova senha e a confirmação não coincidem.");
            return false;
        }

        boolean userFound = false;

        for (User u : users) {
            if (u.getEmail().equals(email)) {
                u.setPassword(newPassword);
                userFound = true;
                break;
            }
        }

        if (!userFound) {
            System.out.println("Usuário com o email fornecido não encontrado.");
            return false;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("users.txt"))) {
            for (User u : users) {
                writer.println(u.toCsvLine());
            }
        } catch (IOException e) {
            System.out.println("Erro ao atualizar a senha no arquivo CSV: " + e.getMessage());
            return false;
        }

        System.out.println("Senha atualizada com sucesso.");
        return true;
    }

    // Funções para livros 
    public Book findBookByIsbn(String isbn) {
        for (Book b : books) {
            if (b.getTitle().equals(isbn)) {
                return b;
            }
        }
        return null;
    }



        public ArrayList<Book> readBooks() {
        File f = new File("books.txt");
        
        // Garante que a lista de usuários está vazia antes de ler
        books.clear();

        if (!f.exists()) {
            System.out.println("Books file not found. Creating books file.");
            return books;
        }



        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                
                // Esse -1 preserva campos vazios
                String[] parts = line.split(",", -1);
                String id = parts[0];
                String title = parts[1];
                String author = parts[2];
                String isbn = parts[3];               
                String releaseYear = parts[4];
                String numPages = parts[5];   
                String genre = parts[6];

                Book b = new Book(
                    Integer.parseInt(id.trim()),
                    title, 
                    author, 
                    isbn, 
                    Integer.parseInt(releaseYear.trim()), 
                    Integer.parseInt(numPages.trim()), 
                    genre
                );
                
                books.add(b);
            }
        } catch (IOException e) {
            System.out.println("Error at reading books: " + e.getMessage());
        }

        System.out.println("Total books: " + books.size());
        return books;
    }



    public boolean registerBook(String title, String author, String isbn, int releaseYear, 
        int numPages, String genre) {
        

        if(findBookByIsbn(isbn) != null) {
            System.out.println("Book with this ISBN already registered.");
            return false;
        }
        
        Book newBook = new Book(title, author, isbn, releaseYear, numPages, genre);
        books.add(newBook);
        

        try (PrintWriter writer = new PrintWriter(new FileWriter("books.txt", true))) {
            writer.println(newBook.getId() + "," + title +  "," + author + "," + isbn + "," + releaseYear + "," + numPages + "," + genre);
        }

         catch (IOException e) {
            System.out.println("Erro ao salvar livro em CSV" + e.getMessage());
        }

    System.out.println("Livro registrado com sucesso.");

    return true;
    }
    public void printBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }


    
    
}







