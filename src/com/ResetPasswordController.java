package com;

import design.view.VerifyUserInfo;
import design.view.ResetPasswordScreen;

public class ResetPasswordController {
	
     private VerifyUserInfo verifyUserInfo;
     private ResetPasswordScreen resetPasswordScreen;

     public ResetPasswordController(VerifyUserInfo verifyUserInfo, ResetPasswordScreen resetPasswordScreen) {
    	 
        this.verifyUserInfo = verifyUserInfo;
        this.resetPasswordScreen = resetPasswordScreen;
        
        initController();
        
    }

    private void initController() {
    	
        verifyUserInfo.btnVerifyUserInfo.addActionListener(e -> handleVerifyUserInfo());
        resetPasswordScreen.btnChangePassword.addActionListener(e -> handleChangePassword());  
        
    }

    private void handleVerifyUserInfo() {

        verifyUserInfo.dispose();
        
        handleChangePassword();
        
    }

    private void handleChangePassword() {
    	
        verifyUserInfo.dispose();
        
        resetPasswordScreen.setVisible(true);
        
    }

}
