package com;

import design.view.GroupUserScreen;
import design.view.HomeScreen;

public class GroupUserScreenController {
	
	private GroupUserScreen groupUserScreen;
	private com.model.User loggedUser;
	private com.service.BookClubService clubService;
	
	public GroupUserScreenController(GroupUserScreen groupUserScreen, com.model.User loggedUser, com.service.BookClubService clubService) {
    	this.groupUserScreen = groupUserScreen;
    	this.loggedUser = loggedUser;
    	this.clubService = clubService;
    	initController();
	}
	
	private void initController() {

		groupUserScreen.btnBackButton.addActionListener(e -> {
			
			groupUserScreen.dispose();
            HomeScreen homeScreen = new HomeScreen();
            HomeController homeController = new HomeController(homeScreen, loggedUser, clubService);
            homeScreen.setVisible(true);
			
		});
		}


}
