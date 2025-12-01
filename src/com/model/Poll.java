package com.model;

import java.util.ArrayList;

public abstract class Poll {

    protected int id;
    protected BookClub bookClub;
    protected String question;
    protected ArrayList<String> options;     
    protected int[] votes;                   
	private static int totalPollsCreated = 0;

    public Poll(int id, BookClub club, String question, ArrayList<String> options, int[] votes) {
        this.id = id;
        this.bookClub = club;
        this.question = question;
        this.options = options;
        this.votes = votes;
    }

    public Poll(BookClub club, String question, ArrayList<String> options) {
        this.id = ++totalPollsCreated;
        this.bookClub = club;
        this.question = question;
        this.options = options;
        this.votes = new int[options.size()];
    }

    public int getId() {
        return id;
    }

    public BookClub getBookClub() {
        return bookClub;
    }

    public void setBookClub(BookClub club) {
        this.bookClub = club;
    }


    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int[] getVotes() {
        return votes;
    }

    public int getWinner() {
        if (votes[0] > votes[1]) return 0;   
        if (votes[1] > votes[0]) return 1;   
        return -1; // empate
    }
    public void vote(int optionIndex) {
        if (optionIndex < 0 || optionIndex >= votes.length) {
            throw new IllegalArgumentException("Opção inválida");
        }
        votes[optionIndex]++;
    }

    public String getVotesAsCSV() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < votes.length; i++) {
            sb.append(votes[i]);
            if (i < votes.length - 1) sb.append(",");
        }
        return sb.toString();
    }

    public void registerVote(int optionIndex) {
        if (optionIndex < 0 || optionIndex >= votes.length)
            return;
        votes[optionIndex]++;
    }

    public abstract String getType();
}
