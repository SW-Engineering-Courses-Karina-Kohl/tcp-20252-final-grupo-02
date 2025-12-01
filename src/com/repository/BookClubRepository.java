package com.repository;

import com.model.BookClub;


import com.model.User;
import com.service.UserService;

import data.Constants;

import java.io.*;
import java.util.ArrayList;

import org.tinylog.Logger;


public class BookClubRepository {


    public ArrayList<BookClub> loadAll(UserService userService) {
        ArrayList<BookClub> list = new ArrayList<>();
        File f = new File(Constants.CSV_PATHS[3]);

        if (!f.exists()) {
            Logger.info("Book clubs file not found. Creating bookClubs.csv.");
            return list;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",", -1);
                if (parts.length < 3) continue; // precisa ter id, name e creatorId

                // Campos basicos
                int id = Integer.parseInt(parts[0].trim());
                int creatorId = Integer.parseInt(parts[1].trim());
                String name = parts[2];
            

                // Recuperar o criador
                User creator =  userService.findById(creatorId);

                // Cria BookClub base
                BookClub bc = new BookClub(id, creator, name);

                // Atributos opcionais 
                if (parts.length >= 4 && !parts[3].isEmpty()) {
                    String[] participantIds = parts[3].split(";");

                    for (String pId : participantIds) {
                        if (!pId.isEmpty()) {
                            User u = userService.findById(Integer.parseInt(pId));
                            if (u != null) {
                                bc.getParticipants().add(u);
                            }
                        }
                    }
                }

                // Pools e meetings ainda nao foram implementados 

                
                // Conecta criador ao bookclub 
                if (creator != null) {
                    creator.getCreatedBookClubs().add(bc);
                }

                
                list.add(bc);
            }

        } catch (IOException e) {
            Logger.info("Error reading bookClubs.csv: " + e.getMessage());
        }

        Logger.info("Loaded book clubs: " + list.size());
        return list;
    }

  

    public void saveAll(ArrayList<BookClub> list) {
        try (PrintWriter w = new PrintWriter(new FileWriter(Constants.CSV_PATHS[3]))) {
            for (BookClub b : list) {
                w.println(b.toCsvLine());
            }
        } catch (IOException e) {
            Logger.info("Erro ao salvar bookClubs.csv: " + e.getMessage());
        }
    }


}
