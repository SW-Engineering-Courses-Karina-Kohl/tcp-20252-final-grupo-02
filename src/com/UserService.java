package com;

import java.io.*;
import java.util.ArrayList;
import design.view.RegistrationScreen;

public class UserService {

    private static final String PATH = "users.txt";

    private final ArrayList<User> users = new ArrayList<>();

    public UserService() {
        loadAll();         
        syncIdCounter();   
    }



    public boolean registerUser(String nome, String sobrenome, String email, String cpf,
                            String senha, String confirmacao) {

    if (fieldsAreEmpty(nome, sobrenome, email, cpf, senha, confirmacao)) {
        System.out.println("Há campos vazios.");
        return false;
    }

    if (!senha.equals(confirmacao)) {
        System.out.println("A senha e a confirmação não coincidem.");
        return false;
    }

    if (findUserByEmail(email) != null) {
        System.out.println("Email já cadastrado.");
        return false;
    }

    User novo = new User(nome, sobrenome, email, cpf, senha);
    users.add(novo);

    saveAll();
    return true;
}

    /* public boolean registerUserUI(String nome, String sobrenome, String email, String cpf,
                            String senha, String confirmacao) {

    if (nome.isBlank() || sobrenome.isBlank() || email.isBlank() || cpf.isBlank()
            || senha.isBlank() || confirmacao.isBlank()) {
        System.out.println("Há campos vazios.");
        return false;
    }

    if (!senha.equals(confirmacao)) {
        System.out.println("Password and confirmation do not match.");
        return false;
    }

    if (findUserByEmail(email) != null) {
        System.out.println("Email já cadastrado.");
        return false;
    }

    User novo = new User(nome, sobrenome, email, cpf, senha);
    users.add(novo);

    saveAll();

    return true;
}   */

    public User findUserByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) return u;
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    private boolean fieldsAreEmpty(String... fields) {
    for (String f : fields) {
        if (f == null || f.isBlank()) {
            return true;
        }
    }
    return false;
}


    private void loadAll() {
        users.clear();
        File f = new File(PATH);
        if (!f.exists()) {
            System.out.println("Users file not found. Creating users file.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length < 6) continue;

                int id         = Integer.parseInt(parts[0].trim());
                String name    = parts[1];
                String surname = parts[2];
                String email   = parts[3];
                String cpf     = parts[4];
                String pass    = parts[5];

                users.add(new User(id, name, surname, email, cpf, pass));
            }
        } catch (IOException e) {
            System.out.println("Error at reading users: " + e.getMessage());
        }

        System.out.println("Total users: " + users.size());
    }

    private void syncIdCounter() {
        int max = 0;
        for (User u : users) if (u.getId() > max) max = u.getId();
        User.setNumUsersCreated(max);
    }

    private void saveAll() {
        try (PrintWriter w = new PrintWriter(new FileWriter(PATH))) {
            for (User u : users) {
                w.println(u.toCsvLine());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar users.txt: " + e.getMessage());
        }
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

    public void printUsers() {
        for (User u : users) {
            System.out.println(u);
        }
    }



}