package com;

import com.model.User;
import com.model.BookClub;
import com.service.BookClubService;
import com.service.PollService;

import design.view.GroupCreationScreen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class GroupCreationController {

    private GroupCreationScreen view;
    private User loggedUser;
    private BookClubService clubService;
    private PollService pollService = new PollService();

    

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

    if (b1.equals(b2)) {
        JOptionPane.showMessageDialog(view, "Os dois livros não podem ser os mesmos.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean foundBook1 = false;
    boolean foundBook2 = false;

    try (BufferedReader br = new BufferedReader(new FileReader("src/data/files/Books.csv"))) {

        String linha;

        while ((linha = br.readLine()) != null) {
            String[] campos = linha.split(",");

            if (campos[0].equals(b1)) {
                foundBook1 = true;
            }

            if (campos[0].equals(b2)) {
                foundBook2 = true;
            }
        }

    } 
    catch (IOException ex) {
        JOptionPane.showMessageDialog(view,
        "Erro ao ler o banco de dados de livros:\n" + ex.getMessage(),
        "Erro",
        JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!foundBook1 || !foundBook2) {
        JOptionPane.showMessageDialog(view,
        "Um dos dois livros não está no banco de dados.",
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

    System.out.println("!!!");

    ArrayList<String> bookOptions = new ArrayList<>();
    bookOptions.add(view.txtBook1.getText());
    bookOptions.add(view.txtBook2.getText());
    pollService.createPollForBookClub(newClub, "BOOK", "Qual livro ler primeiro?", bookOptions);

    ArrayList<String> dateOptions = new ArrayList<>();
    dateOptions.add(view.txtDate1.getDate().toString());
    dateOptions.add(view.txtDate2.getDate().toString());
    pollService.createPollForBookClub(newClub, "DATE", "Qual data para o encontro?", dateOptions);

    JOptionPane.showMessageDialog(view, "Grupo criado com sucesso!");

    view.dispose();
    new design.view.GroupUserScreen(loggedUser, clubService).setVisible(true);
}


    private void voltar() {
        view.dispose();
        new design.view.GroupUserScreen(loggedUser, clubService).setVisible(true);
    }
}
