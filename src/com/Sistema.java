package com;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Sistema {
    
    private ArrayList<User> users;

    public Sistema() {
        this.users = new ArrayList<>();
    }


    public boolean registerUser(String name, String surname, String email, String cpf, 
    String password, String passwordConfirmation) {
        
       
        // Verificacao de senha
        /*if(!(password.equals(passwordConfirmation))) {
            System.out.println("Password and confirmation do not match.");    
            return false;
        }*/

        if(procuraPorEmail(email)) {
            System.out.println("Email already registered.");
            return false;
        }

        // Criar verificacao de email e cpf unicos
        // ...
        
        User newUser = new User(name, surname, email, cpf, password);
        users.add(newUser);
        

        try (PrintWriter writer = new PrintWriter(new FileWriter("users.txt", true))) {
            writer.println(name + "," + surname + "," + email + "," + cpf + "," + password);
        }

         catch (IOException e) {
            System.out.println("Erro ao salvar usuário em CSV: " + e.getMessage());
        }

    System.out.println("User registered successfully.");

    return true;
    }



    public ArrayList<User> readUsers() {
        File f = new File("users.txt");
        if (!f.exists()) {
            System.out.println("Users file not found. Creating users file.");
            return users;
        }

        users.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                // Esse -1 preserva campos vazios
                String[] parts = line.split(",", -1);
                String name = parts[0];
                String surname = parts[1];
                String email = parts[2];
                String cpf = parts[3];
                String password = parts[4];

                User u = new User(name, surname, email, cpf, password);
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


    public boolean procuraPorEmail(String email) {
        ArrayList<User> array = readUsers();
        for (User u: array) {
            if (u.getEmail().equals(email)) {
                System.out.println("User found: " + u);
                return true;
            }
        }
        return false;
    }



}







