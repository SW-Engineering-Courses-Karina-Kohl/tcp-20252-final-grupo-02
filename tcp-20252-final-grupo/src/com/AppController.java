package com;

import design.view.LoadingScreen;
import design.view.LoginScreen;
import javax.swing.SwingUtilities;

public class AppController {

    public void start() {
        SwingUtilities.invokeLater(() -> {
            showLoadingScreen();
        });
    }

    private void showLoadingScreen() {
        LoadingScreen loading = new LoadingScreen();
        loading.setVisible(true);

        javax.swing.Timer timer = new javax.swing.Timer(2000, e -> {
            loading.dispose();
            showLoginScreen();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void showLoginScreen() {
        LoginScreen loginScreen = new LoginScreen();
        new LoginController(loginScreen);
        loginScreen.setVisible(true);
    }
}
