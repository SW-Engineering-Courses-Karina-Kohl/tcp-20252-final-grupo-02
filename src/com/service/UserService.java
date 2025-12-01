package com.service;

import java.io.*;
import java.util.ArrayList;

import org.tinylog.Logger;

import com.model.User;

import com.repository.UserRepository;


public class UserService {

    private final UserRepository repo;
    private final ArrayList<User> users;

    public UserService() {
        this.repo = new UserRepository();
        this.users = repo.loadAll();
        syncIdCounter();
    }


    public boolean registerUser(String nome, String sobrenome, String email, String cpf,
                            String senha, String confirmacao) {

    if (fieldsAreEmpty(nome, sobrenome, email, cpf, senha, confirmacao)) {
        Logger.info("Há campos vazios.");
        return false;
    }

    if (!senha.equals(confirmacao)) {
        Logger.info("A senha e a confirmação não coincidem.");
        return false;
    }

    if (findUserByEmail(email) != null) {
        Logger.info("Email já cadastrado.");
        return false;
    }

    User novo = new User(nome, sobrenome, email, cpf, senha);
    users.add(novo);

    repo.saveAll(users);
    return true;
}

     public void reloadUsers() {
        users.clear();
        users.addAll(repo.loadAll());
        syncIdCounter();
    }
   
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


    

    private void syncIdCounter() {
        int max = 0;
        for (User u : users) if (u.getId() > max) max = u.getId();
        User.setNumUsersCreated(max);
    }





    public void printUsers() {
        for (User u : users) {
            Logger.info(u);
        }
    }

        public boolean alterPassword(String email, String newPassword, String passwordConfirmation) {
            if (!newPassword.equals(passwordConfirmation)) {
                Logger.info("A nova senha e a confirmação não coincidem.");
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
                Logger.info("Usuário com o email fornecido não encontrado.");
                return false;
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/files/Users.csv"))) {
                for (User u : users) {
                    writer.println(u.toCsvLine());
                }
            } catch (IOException e) {
                Logger.info("Erro ao atualizar a senha no arquivo CSV: " + e.getMessage());
                return false;
            }

            Logger.info("Senha atualizada com sucesso.");
            return true;
        }

    public User findById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
    return null; 
    }   

}