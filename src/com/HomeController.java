package com;

import design.view.FeedScreen;
import design.view.GroupUserScreen;
import design.view.HomeScreen;
import design.view.ParticipateScreen;

public class HomeController {

    private HomeScreen homeScreen;
    private com.model.User loggedUser;
    private com.service.BookClubService clubService;

    public HomeController(HomeScreen homeScreen, com.model.User loggedUser, com.service.BookClubService clubService) {
        this.homeScreen = homeScreen;
        this.loggedUser = loggedUser;
        this.clubService = clubService;
        initController();
        loadUserGroups();
        loadGeneralFeed();
    }

    private void initController() {
        homeScreen.btnMyGroups.addActionListener(e -> openMyGroups());
        homeScreen.btnShowMyGroups.addActionListener(e -> showMyGroups());
        homeScreen.btnEnterGroup.addActionListener(e -> enterGroup());
    }

    private void loadGeneralFeed() {
        java.util.List<com.model.BookClub> allClubs = clubService.getAllClubs();
        homeScreen.populateGeneralFeed(allClubs, loggedUser);
    }   


    private void loadUserGroups() {
        java.util.ArrayList<com.model.BookClub> myClubs = clubService.getClubsForUser(loggedUser);
        homeScreen.populateMyGroups(myClubs);
    }

    private void openMyGroups() {
        homeScreen.dispose();
        GroupUserScreen groupUserScreen = new GroupUserScreen(loggedUser, clubService);
        GroupUserScreenController groupUserScreenController = new GroupUserScreenController(groupUserScreen);
        groupUserScreen.setVisible(true);
    }


    private void showMyGroups() {
        homeScreen.dispose();
        ParticipateScreen participateScreen = new ParticipateScreen(loggedUser, clubService); 
        participateScreen.setVisible(true);
    }


    private void enterGroup() {
        homeScreen.dispose();
        FeedScreen feedScreen = new FeedScreen(loggedUser, clubService); 
        feedScreen.setVisible(true);
    }
}
