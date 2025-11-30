package com.service;

import java.util.ArrayList;

import org.tinylog.Logger;

import com.model.Creator;
import com.model.BookClub;
import com.repository.BookClubRepository;

public class CreatorService {

    private final BookClubRepository bookRepo;
    private final ArrayList<BookClub> clubs;

    public CreatorService(BookClubService bookClubService) {
        this.bookRepo = new BookClubRepository();
        this.clubs = bookClubService.getAllClubs();
    }

    public boolean deleteClub(Creator c, int clubId) {

        BookClub target = null;

        for (BookClub bc : c.getCreatedBookClubs()) {
            if (bc.getId() == clubId) {
                target = bc;
                break;
            }
        }

        if (target == null) {
            Logger.info("Esse usuário não tem permissão para deletar o clube.");
            return false;
        }

        c.getCreatedBookClubs().remove(target);
        clubs.remove(target);

        bookRepo.saveAll(clubs);

        return true;
    }

    public ArrayList<BookClub> getClubsByCreator(Creator c) {
        return c.getCreatedBookClubs();
    }
}