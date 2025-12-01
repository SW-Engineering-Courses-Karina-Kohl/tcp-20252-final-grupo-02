package com.service;

import java.io.*;
import java.util.ArrayList;

import com.model.BookClub;
import com.model.Poll;
import com.model.BookPoll;
import com.model.DatePoll;

public class PollService {

    private static final String FILE_NAME = "polls.xls";
    private ArrayList<Poll> polls = new ArrayList<>();

    public ArrayList<Poll> getPolls() {
        return polls;
    }

    public Poll createPollForBookClub(
            BookClub club,
            String type,
            String question,
            ArrayList<String> options
    ) {
        int newId;
        if(polls.isEmpty()) newId = 1;
        
        else newId = polls.get(polls.size() - 1).getId() + 1;

        int[] votes = new int[options.size()];

        Poll p;
        if (type.equalsIgnoreCase("BOOK")) {
            p = new BookPoll(newId, club, question, options, votes);
        } else {
            p = new DatePoll(newId, club, question, options, votes);
        }

        polls.add(p);         // adiciona no PollService
        club.addPoll(p);      // adiciona no BookClub
        savePolls();          

        return p;
    }


    public void loadPolls(ArrayList<BookClub> clubs) {
        polls.clear();

        File f = new File(FILE_NAME);
        if (!f.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {

            reader.readLine(); // descarta header

            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(";");
                if (parts.length < 6) continue;

                int id = Integer.parseInt(parts[0]);
                int clubId = Integer.parseInt(parts[1]);
                String type = parts[2];
                String question = parts[3];

                // opções no formato:   id|nome,id|nome,id|nome
                String[] optionParts = parts[4].split(",");
                ArrayList<String> options = new ArrayList<>();
                for (String op : optionParts) options.add(op);

                // votos
                String[] votesStr = parts[5].split(",");
                int[] votes = new int[votesStr.length];
                for (int i = 0; i < votesStr.length; i++)
                    votes[i] = Integer.parseInt(votesStr[i]);

                BookClub club = clubs.stream()
                        .filter(c -> c.getId() == clubId)
                        .findFirst().orElse(null);

                if (club == null) continue;

                Poll p;
                if (type.equals("BOOK")) {
                    p = new BookPoll(id, club, question, options, votes);
                } else {
                    p = new DatePoll(id, club, question, options, votes);
                }

                // Verifica se já existe antes de adicionar
                polls.add(p);
                boolean exists = false;
                for (Poll existing : club.getPolls()) {
                    if (existing.getId() == p.getId()) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    club.addPoll(p);
}
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void vote(Poll poll, int optionIndex) {
        poll.vote(optionIndex);
        savePolls();  
}


    public void savePolls() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            writer.println("id;clubId;type;question;options;votes");

            for (Poll p : polls) {

                String optionsCSV = String.join(",", p.getOptions());
                String votesCSV = p.getVotesAsCSV();

                writer.printf(
                        "%d;%d;%s;%s;%s;%s%n",
                        p.getId(),
                        p.getBookClub().getId(),
                        p.getType(),
                        p.getQuestion(),
                        optionsCSV,
                        votesCSV
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
