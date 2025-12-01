package com;

import com.model.User;
import com.model.BookClub;
import com.service.BookClubService;
import design.view.GroupCreationScreen;

import javax.swing.*;
import java.util.ArrayList;

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

        JOptionPane.showMessageDialog(view, "Grupo criado com sucesso!");

        view.dispose();
        new design.view.GroupUserScreen(loggedUser, clubService).setVisible(true);
    }

    private void voltar() {
        view.dispose();
        new design.view.GroupUserScreen(loggedUser, clubService).setVisible(true);
    }
}
