package com;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

// import org.tinylog.Logger;

import design.view.LoginScreen;
import design.view.RegistrationScreen;
import com.services.BookService;
import com.services.MeetingService;
import com.services.PollService;

public class AppSystem {
    
    private RegistrationScreen regScreen;
    private ArrayList<User> users;
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
        initController();
        // Carrega os arrays com os arquivos toda vez que o programa é iniciado
         readUsers();
    }

    public AppSystem() {
        this.users = new ArrayList<User>();
        //this.bookClubs = new ArrayList<BookClub>();
        this.bookService = new BookService();
        this.pollService = new PollService();
        this.meetingService = new MeetingService();

    }


	
// 	public ArrayList<BookClub> getBookClubs() {
		
// 		Logger.info("Lista de clubes do livro retornada com sucesso");
		
// 		return bookClubs;
		
// 	}
	
// 	public void createBookClub(BookClub newBookClub) {
		
// 		bookClubs.add(newBookClub);
		
// 		Logger.info("Clube do livro criado com sucesso");
		
// 	}
	
// 	public void deleteBookClub(BookClub bookClub) {
		
// 		bookClubs.remove(bookClub);
		
// 		Logger.info("Clube do livro excluído com sucesso");
		
// 	}

// 	public ArrayList<User> getUsers() {
		
// 		Logger.info("Lista de usuários retornada com sucesso");
		
// 		return users;
		
// 	}
	
// 	public void createUser(User newUser) {
		
// 		users.add(newUser);
		
// 		Logger.info("Usuário criado com sucesso");
		
// 	}
	
// 	public void deleteUser(User user) {
		
// 		users.remove(user);
		
// 		Logger.info("Usuário excluído com sucesso");
		
// 	}
    



// Funções para usuário 

    private void initController() {
        regScreen.btnBackButton.addActionListener(e -> {
            regScreen.dispose();
            LoginScreen loginScreen = new LoginScreen();
            LoginController loginController = new LoginController(loginScreen);
            loginScreen.setVisible(true);
        });
        regScreen.btnCadastrar.addActionListener(e -> registerUser(regScreen));
    }



    public ArrayList<User> readUsers() {
        File f = new File("src\\data\\files\\Users.csv");
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








