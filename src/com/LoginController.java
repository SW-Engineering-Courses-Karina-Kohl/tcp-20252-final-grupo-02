package com;

import design.view.HomeScreen;
import design.view.LoginScreen;
import design.view.RegistrationScreen;
import design.view.VerifyUserInfo;
import design.view.ResetPasswordScreen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.tinylog.Logger;

import data.Constants;

public class LoginController {
	
    private LoginScreen loginScreen;

    public LoginController(LoginScreen loginScreen) {
    	
        this.loginScreen = loginScreen;
        
        initController();
        
    }

    private void initController() {
    	
        loginScreen.btnLogin.addActionListener(e -> handleLogin());
        loginScreen.btnSignin.addActionListener(e -> handleRegister());
        loginScreen.btnForgotPassword.addActionListener(e -> handleReset());
        
    }

    private void handleLogin() {
    	
        String userInfo = loginScreen.txtUserInfo.getText();
        String password = new String(loginScreen.txtPassword.getPassword());

        if (authenticateUser(userInfo, password)) Logger.info("Login realizado com sucesso!");
        else Logger.error("Credenciais de login inválidas!");

    }

    private void handleRegister() {
    	
        RegistrationScreen regScreen = new RegistrationScreen();
        
        loginScreen.dispose();
        
        regScreen.setVisible(true);
        
        AppSystem registerUser = new AppSystem(regScreen);
        
    }

    private void handleReset() {
    	
        VerifyUserInfo resetScreen = new VerifyUserInfo();
        ResetPasswordScreen resetScreen1 = new ResetPasswordScreen();
        
        loginScreen.dispose();
        
        resetScreen.setVisible(true);
        
        ResetPasswordController resetController = new ResetPasswordController(resetScreen, resetScreen1);
        
    }

    private boolean authenticateUser(String userInfo, String password) {

    	try (BufferedReader buffer = new BufferedReader(new FileReader("src/data/files/Users.csv"))) {

    		String line;
        
    		while ((line = buffer.readLine()) != null) {

    			String[] data = line.split(",");

    			if (data.length < Constants.USERS_ENTRIES_PER_LINE) continue;

    			String email = data[2].trim();
    			String cpf = data[3].trim();
    			String senha = data[4].trim();

    			if ((userInfo.equals(email) || userInfo.equals(cpf)) && password.equals(senha)) {

    				loginScreen.dispose();
                
                	HomeScreen homeScreen = new HomeScreen();
                	homeScreen.setVisible(true);
                
                	return true;
                
    			}
    			
    		}

    	} catch (IOException e) {
    	
    		Logger.error("Erro ao ler o arquivo de usuários!");
    	
    	}

    	JOptionPane.showMessageDialog(loginScreen, "Credenciais inválidas!");
    	
    	return false;
    
    }

}
