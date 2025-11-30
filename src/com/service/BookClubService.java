package com.service;

import java.util.ArrayList;

import org.tinylog.Logger;

import com.model.User;
import com.model.BookClub;
import com.repository.BookClubRepository;

public class BookClubService {

    private final BookClubRepository repo;
    private final ArrayList<BookClub> clubs;
    private final UserService userService;

    public BookClubService(UserService userService) {
        this.repo = new BookClubRepository();
        this.userService = userService;
        this.clubs = repo.loadAll(userService);
        rebuildCreators(userService);
    }

    private void rebuildCreators(UserService userService) {
        for (BookClub bc : clubs) {
            User u = userService.findById(bc.getCreator().getId());
                if (!u.getCreatedBookClubs().contains(bc)) {
                    u.getCreatedBookClubs().add(bc);
                }
        }
    }


    boolean clubNameExists(String name) {
        for (BookClub bc : clubs) {
            if (bc.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    
    public BookClub createClub(User u, String name) {
        if (clubNameExists(name)) {
            Logger.info("Já existe um clube com o nome: " + name);
            return null; 
        }

        BookClub newClub = new BookClub(u, name);

        u.getCreatedBookClubs().add(newClub);

        clubs.add(newClub);
        repo.saveAll(clubs);

        return newClub;
    }


    public ArrayList<BookClub> getAllClubs() {
        return clubs;
    }

    public ArrayList<BookClub> getClubsForUser(User u) {
    ArrayList<BookClub> userClubs = new ArrayList<>();

    for (BookClub bc : clubs) {
        if (bc.getParticipants().contains(u) || bc.getCreator().getId() == u.getId()) {
            userClubs.add(bc);
        }
    }

    return userClubs;
}


    
}

    