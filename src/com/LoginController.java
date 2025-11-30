package com;

import design.view.HomeScreen;
import design.view.LoginScreen;
import design.view.RegistrationScreen;
import design.view.ResetPasswordScreen;
import design.view.ResetPasswordScreen1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LoginController {
    private LoginScreen loginScreen;

    public LoginController(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        initController();
    }

    private void initController() {
        loginScreen.btnEntrar.addActionListener(e -> handleLogin());
        loginScreen.btnCadastrar.addActionListener(e -> handleRegister());
        loginScreen.btnEsqueceuSenha.addActionListener(e -> handleReset());
    }

    private void handleLogin() {
        String emailCpf = loginScreen.txtEmailCpf.getText();
        String senha = new String(loginScreen.txtSenha.getPassword());

        if (authenticateUser(emailCpf, senha)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private void handleRegister() {
        RegistrationScreen registrationScreen = new RegistrationScreen();
        loginScreen.dispose();

        AppSystem app = new AppSystem(registrationScreen);
        app.initRegistrationController();
        registrationScreen.setVisible(true);
        
    }

    private void handleReset() {
        ResetPasswordScreen resetScreen = new ResetPasswordScreen();
        ResetPasswordScreen1 resetScreen1 = new ResetPasswordScreen1();
        loginScreen.dispose();
        ResetPasswordController resetController = new ResetPasswordController(resetScreen, resetScreen1);
        resetScreen.setVisible(true);
    }

    private boolean authenticateUser(String emailCpf, String senhaDigitada) {

    try (BufferedReader br = new BufferedReader(new FileReader("src/data/files/Users.csv"))) {

        String line;
        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            if (data.length < 5) continue; // linha inválida

            String email = data[3].trim();
            String cpf   = data[4].trim();
            String senha = data[5].trim();

            // Permite login por email OU CPF
            if ((emailCpf.equals(email) || emailCpf.equals(cpf)) &&
                senhaDigitada.equals(senha)) {

                //JOptionPane.showMessageDialog(loginScreen, "Login successful!");
                loginScreen.dispose();
                HomeScreen homeScreen = new HomeScreen();
                HomeController homeController = new HomeController(homeScreen);
                homeScreen.setVisible(true);
                return true;
            }
        }

    } catch (IOException e) {
            System.out.println("Error at reading users: " + e.getMessage());
    }

    JOptionPane.showMessageDialog(loginScreen, "Invalid credentials.");
    return false;
}

}
