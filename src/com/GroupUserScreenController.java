package com;

import design.view.GroupUserScreen;
import design.view.HomeScreen;

public class GroupUserScreenController {
	
	private GroupUserScreen groupUserScreen;
	
	public GroupUserScreenController(GroupUserScreen groupUserScreen) {
		
		this.groupUserScreen = groupUserScreen;
		initController();
		
	}
	
	private void initController() {

		groupUserScreen.btnBackButton.addActionListener(e -> {
			
			groupUserScreen.dispose();
            HomeScreen homeScreen = new HomeScreen();
            HomeController homeController = new HomeController(homeScreen);
            homeScreen.setVisible(true);
			
		});
		}


}
