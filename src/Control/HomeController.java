package Control;

import javax.swing.JFrame;

import design.view.FeedScreen;
import design.view.GroupUserScreen;
import design.view.HomeScreen;

public class HomeController extends JFrame {

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
        System.out.println("Opening My Groups...");
        homeScreen.dispose();
        GroupUserScreen groupUserScreen = new GroupUserScreen();
        groupUserScreen.setVisible(true);
    }

    private void showMyGroups() {
        System.out.println("Showing My Groups...");
    }

    private void enterGroup() {
        homeScreen.dispose();
        FeedScreen feedScreen = new FeedScreen();
        feedScreen.setVisible(true);
    }
}
