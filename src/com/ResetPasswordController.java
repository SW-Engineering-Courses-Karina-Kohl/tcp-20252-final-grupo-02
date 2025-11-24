package com;

import design.view.LoginScreen;
import design.view.ResetPasswordScreen;
import design.view.ResetPasswordScreen1;

public class ResetPasswordController {
     private ResetPasswordScreen resetPasswordScreen;
     private ResetPasswordScreen1 resetPasswordScreen1;

    public ResetPasswordController(ResetPasswordScreen resetPasswordScreen, ResetPasswordScreen1 resetPasswordScreen1) {
        this.resetPasswordScreen = resetPasswordScreen;
        this.resetPasswordScreen1 = resetPasswordScreen1;
        initController();
    }

    private void initController() {
        resetPasswordScreen.btnVerify.addActionListener(e -> handleVerify());
        resetPasswordScreen.btnBackButton.addActionListener(e -> {
            resetPasswordScreen.dispose();
            LoginScreen loginScreen = new LoginScreen();
            LoginController loginController = new LoginController(loginScreen);
            loginScreen.setVisible(true);
        });
        resetPasswordScreen1.btnBackButton.addActionListener(e -> {
            resetPasswordScreen1.dispose();
            resetPasswordScreen.setVisible(true);
        });
        resetPasswordScreen1.btnCadastrar.addActionListener(e -> handleCadastrar());   
    }

    private void handleVerify() {
        // Lógica para verificar o e-mail ou CPF
        System.out.println("Verificando e-mail/CPF...");
        resetPasswordScreen.dispose();
        handleCadastrar();
    }

    private void handleCadastrar() {
        // Lógica para cadastrar a nova senha
        resetPasswordScreen.dispose();
        resetPasswordScreen1.setVisible(true);
    }

}
