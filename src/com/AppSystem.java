package com;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;



import design.view.LoginScreen;
import design.view.RegistrationScreen;

public class AppSystem {
    
    private RegistrationScreen regScreen;
    private ArrayList<User> users;
    private ArrayList<Book> books;

    public AppSystem(RegistrationScreen regScreen) {
        this.users = new ArrayList<>();
        this.regScreen = regScreen;
        initController();
        // Carrega os usuários toda vez que o programa é iniciado
         readUsers();
         readBooks();
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







