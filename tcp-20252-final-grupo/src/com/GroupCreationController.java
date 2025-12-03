package com;

import com.model.User;
import com.model.BookClub;
import com.service.BookClubService;
import design.view.GroupCreationScreen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class GroupCreationController {

    private GroupCreationScreen view;
    private User loggedUser;
    private BookClubService clubService;

    public GroupCreationController(GroupCreationScreen view, User loggedUser, BookClubService clubService) {
        this.view = view;
        this.loggedUser = loggedUser;
        this.clubService = clubService;

        initController();
    }

    private void initController() {

        view.btnInitVote.addActionListener(e -> criarGrupo());
        view.btnBackButton.addActionListener(e -> voltar());
    }

    private void criarGrupo() {

        String name = view.txtGroupName.getText();
        String b1 = view.txtBook1.getText();
        String b2 = view.txtBook2.getText();

        if (name.isEmpty() || b1.isEmpty() || b2.isEmpty() 
            || view.txtDate1.getDate() == null 
            || view.txtDate2.getDate() == null 
            || (!view.rbtnOnline.isSelected() && !view.rbtnPresential.isSelected())) {

            JOptionPane.showMessageDialog(view,
                    "Por favor preencha todos os campos.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        BookClub newClub = clubService.createClub(loggedUser, name);

        if (newClub == null) {
            JOptionPane.showMessageDialog(view,
                    "Já existe um grupo com esse nome.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (b1.equals(b2)) {
    		
    		JOptionPane.showMessageDialog(view, "Os dois livros não podem ser os mesmos.", "Erro", JOptionPane.ERROR_MESSAGE);
    		
    		return;
    		
    	} else {
    		
           	try (BufferedReader br = new BufferedReader(new FileReader("tcp-20252-final-grupo/src/data/files/Books.csv"))) {
                
        		String linha;
        		boolean foundBook1 = false, foundBook2 = false;

                while ((linha = br.readLine()) != null) {
                	
                    String[] campos = linha.split(","); // separação por vírgula

                    if (campos[0].equals(b1)) {
                    	
                    	foundBook1 = true;
                    	
                    }
                    
                    if (campos[0].equals(b2)) {
                    	
                    	foundBook2 = true;
                    	
                    }
                    
                }
                
                if ((foundBook1 == false) || (foundBook2 == false)) {
               		
            		JOptionPane.showMessageDialog(view, "Um dos dois livros não foram encontrados no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            		
            		return;
               		
               	}

            } catch (IOException ex) {
                System.err.println("Erro ao ler o arquivo: " + ex.getMessage());
            }
           	
           	System.out.println("!!!");

        JOptionPane.showMessageDialog(view, "Grupo criado com sucesso!");

        view.dispose();
        new design.view.GroupUserScreen(loggedUser, clubService).setVisible(true);
    }
    }

    private void voltar() {
        view.dispose();
        new design.view.GroupUserScreen(loggedUser, clubService).setVisible(true);
    }
}
