package com.service;

import java.util.ArrayList;

import org.tinylog.Logger;

import com.model.User;
import com.model.Creator;
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
    }

    public BookClub createClub(User u, String name) {

        Creator c;

        if (u instanceof Creator) {
            c = (Creator) u;
        } else {
            c = userService.promoteUserToCreator(u);
            Logger.info("Usuário promovido a criador: " + c.getName());
        }

        BookClub newClub = new BookClub(c, name);

        c.getCreatedBookClubs().add(newClub);

        clubs.add(newClub);
        repo.saveAll(clubs);

        return newClub;
    }

    public ArrayList<BookClub> getAllClubs() {
        return clubs;
    }
}