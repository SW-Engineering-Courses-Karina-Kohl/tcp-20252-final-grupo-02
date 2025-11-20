package com;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AppSystem {
    
    private ArrayList<User> users;
    private ArrayList<Book> books;

    public AppSystem() {
        this.users = new ArrayList<>();
        // Carrega os usuários toda vez que o programa é iniciado
         readUsers();
    }





// Funções para usuário 

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


    
    public boolean registerUser(String name, String surname, String email, String cpf,
    String password, String passwordConfirmation) {
        
       

        if(!(password.equals(passwordConfirmation))) {
            System.out.println("Password and confirmation do not match.");    
            return false;
        }

        if(findUserByEmail(email) != null) {
            System.out.println("Email already registered.");
            return false;
        }
        
        User newUser = new User(name, surname, email, cpf, password);
        users.add(newUser);
        

        try (PrintWriter writer = new PrintWriter(new FileWriter("users.txt", true))) {
            writer.println(newUser.getId() + "," + name + "," + surname + "," + email + "," + cpf + "," + password);
        }

         catch (IOException e) {
            System.out.println("Erro ao salvar usuário em CSV: " + e.getMessage());
        }

    System.out.println("User registered successfully.");

    return true;
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




    
    
}







