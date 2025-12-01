package com.repository;


import com.model.User;

import data.Constants;

import java.io.*;
import java.util.ArrayList;
import org.tinylog.Logger;
public class UserRepository {

     private static final String PATH = "src/data/files/Users.csv";

        public ArrayList<User> loadAll() {
            ArrayList<User> list = new ArrayList<>();
            File f = new File(PATH);

            if (!f.exists()) {
                Logger.info("Users file not found. Creating users file.");
                return list;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(Constants.CSV_PATHS[5]))) {
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
                    list.add(new User(id, name, surname, email, cpf, pass));
                    

                }
            } catch (IOException e) {
                Logger.info("Error at reading users: " + e.getMessage());
            }

            Logger.info("Total users: " + list.size());
            return list;
        }



    public void saveAll(ArrayList<User> list) {
        try (PrintWriter w = new PrintWriter(new FileWriter(Constants.CSV_PATHS[5]))) {
            for (User u : list) {
                w.println(u.toCsvLine());
            }
        } catch (IOException e) {
            Logger.info("Erro ao salvar users.csv: " + e.getMessage());
        }
    }


}