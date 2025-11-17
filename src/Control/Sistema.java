package Control;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import design.view.LoginScreen;
import design.view.RegistrationScreen;

public class Sistema {
    
    private RegistrationScreen regScreen;
    private ArrayList<User> users;

    public Sistema(RegistrationScreen regScreen) {
        this.users = new ArrayList<>();
        this.regScreen = regScreen;
        initController();
    }

    private void initController() {
        regScreen.btnCadastrar.addActionListener(e -> registerUser(regScreen));
    }

    public void registerUser(RegistrationScreen regScreen) {

        String nome = regScreen.txtNome.getText();
        String sobrenome = regScreen.txtSobrenome.getText();
        String cpf = regScreen.txtCpf.getText();
        String password = new String(regScreen.txtSenha.getPassword());
        String passwordConfirmation = new String(regScreen.txtConfirmarSenha.getPassword());
        String email = regScreen.txtEmail.getText();
        
        // Se quiserem acho que é uma boa adicionar essa funcionalidades:
        // Verificacao de senha
        if(!(password.equals(passwordConfirmation))) {
            System.out.println("Password and confirmation do not match.");    
        }

        // Criar verificacao de email e cpf unicos
        // ...
        
        User newUser = new User(nome, sobrenome, email, cpf, password);
        users.add(newUser);

        // Escrita de usuario em CSV

        try (PrintWriter writer = new PrintWriter(new FileWriter("users.txt", true))) {
            writer.println(nome + "," + sobrenome + "," + email + "," + cpf + "," + password);
        }

         catch (IOException e) {
            System.out.println("Erro ao salvar usuário em CSV: " + e.getMessage());
        }

    System.out.println("User registered successfully.");
    regScreen.dispose();
    LoginScreen loginScreen = new LoginScreen();
    LoginController loginController = new LoginController(loginScreen);
    loginScreen.setVisible(true);
}






    public ArrayList<User> readUsers() {
        File f = new File("users.csv");
        if (!f.exists()) {
            System.out.println("Users file not found.");
            return users;
        }

        users.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                // Esse -1 preserva campos vazios
                String[] parts = line.split(",", -1);
                String name = parts[0];
                String surname = parts[1];
                String email = parts[2];
                String cpf = parts[3];
                String password = parts[4];

                User u = new User(name, surname, email, cpf, password);
                users.add(u);
            }
        } catch (IOException e) {
            System.out.println("Error at reading users: " + e.getMessage());
        }

        System.out.println("Total users: " + users.size());
        return users;
    }


    public void printUsers() {
        for (User u : users) {
            System.out.println(u);
        }
    }


}







