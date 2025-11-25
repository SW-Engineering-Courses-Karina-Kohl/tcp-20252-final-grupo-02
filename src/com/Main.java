package com;
public class Main {
    public static void main(String[] args) {
        
		AppSystem appSystem = new AppSystem();
        appSystem.registerUser("Rafael", "Silva", "dd", "12345678900", "senha123", "senha123");
        appSystem.registerUser("Everton", "Oliveira", "dd2", "09876543211", "senha456", "senha456");
        appSystem.registerUser("Ana", "Souza", "dd3", "11223344556", "senha789", "senha789");

        appSystem.printUsers();

        appSystem.alterPassword("dd", "senha555", "senha555");

        appSystem.printUsers();

    }


            
}
				
        
                
			
			