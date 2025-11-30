package com.repository;

import com.model.Creator;
import com.model.User;
import java.io.*;
import java.util.ArrayList;
import org.tinylog.Logger;
public class UserRepository {

     private static final String PATH = "users.txt";

        public ArrayList<User> loadAll() {
            ArrayList<User> list = new ArrayList<>();
            File f = new File(PATH);

            if (!f.exists()) {
                Logger.info("Users file not found. Creating users file.");
                return list;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",", -1);
                    if (parts.length < 7) continue;

                    int id         = Integer.parseInt(parts[0].trim());
                    String name    = parts[1];
                    String surname = parts[2];
                    String email   = parts[3];
                    String cpf     = parts[4];
                    String pass    = parts[5];
                    String type    = parts[6].trim();
                    if (type.equalsIgnoreCase("CREATOR")) {
                        Creator c = new Creator(name, surname, cpf, email, pass);
                        c.setId(id);
                        list.add(c);
                    } 
                    
                    else {
                        list.add(new User(id, name, surname, email, cpf, pass));
                    }

                }
            } catch (IOException e) {
                Logger.info("Error at reading users: " + e.getMessage());
            }

            Logger.info("Total users: " + list.size());
            return list;
        }



    public void saveAll(ArrayList<User> list) {
        try (PrintWriter w = new PrintWriter(new FileWriter(PATH))) {
            for (User u : list) {
                w.println(u.toCsvLine());
            }
        } catch (IOException e) {
            Logger.info("Erro ao salvar users.txt: " + e.getMessage());
        }
    }


}