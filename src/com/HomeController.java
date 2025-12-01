package com;

import design.view.FeedScreen;
import design.view.GroupUserScreen;
import design.view.HomeScreen;
import design.view.ParticipateScreen;

public class HomeController {

    private HomeScreen homeScreen;
    private FeedScreen feedScreen;

    public HomeController(HomeScreen homeScreen) {

        this.homeScreen = homeScreen;
        initController();
    }

    private void initController() {

        homeScreen.btnMyGroups.addActionListener(e -> openMyGroups());
        homeScreen.btnShowMyGroups.addActionListener(e -> showMyGroups());
        homeScreen.btnEnterGroup.addActionListener(e -> enterGroup());
    }

    private void openMyGroups() {
        homeScreen.dispose();
        GroupUserScreen groupUserScreen = new GroupUserScreen();
        GroupUserScreenController groupUserScreenController = new GroupUserScreenController(groupUserScreen);
        groupUserScreen.setVisible(true);
    }

    private void showMyGroups() {
        homeScreen.dispose();
        ParticipateScreen participateScreen = new ParticipateScreen();
        participateScreen.setVisible(true);
    }

    private void enterGroup() {
        homeScreen.dispose();
        FeedScreen feedScreen = new FeedScreen();
        feedScreen.setVisible(true);
    }
}
