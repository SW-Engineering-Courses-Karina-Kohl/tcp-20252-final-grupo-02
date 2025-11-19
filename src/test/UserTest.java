package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.Main;
import com.User;

public class UserTest {

	@Test
	public void testConstructor() {
		
		String name = "Matheus";
		String surname = "Candiotto";
		String cpf = "012345678-90";
		String email = "matheus.candiotto@ufrgs.br";
		String password = "SenhaMuitoSegura";
		
		User newUser = new User(name, surname, cpf, email, password);
		
		assertEquals(User.getNumUsersCreated(), newUser.getId());
		assertEquals(name, newUser.getName());
		assertEquals(surname, newUser.getSurname());
		assertEquals(cpf, newUser.getCpf());
		assertEquals(email, newUser.getEmail());
		assertEquals(password, newUser.getPassword());
		assertEquals(0, newUser.getJoinedBookClubs().size());
		
	}
	
	@Test
	public void testCreateUser() {
		
		String name = "Matheus";
		String surname = "Candiotto";
		String cpf = "012345678-90";
		String email = "matheus.candiotto@ufrgs.br";
		String password = "SenhaMuitoSegura";
		
		User newUser = new User(name, surname, cpf, email, password);
		
		Main main = new Main();
		
		main.createUser(newUser);
		
		assertEquals(1, main.getUsers().size());
		
	}
	
	@Test
	public void testDeleteUser() {
		
		String name = "Matheus";
		String surname = "Candiotto";
		String cpf = "012345678-90";
		String email = "matheus.candiotto@ufrgs.br";
		String password = "SenhaMuitoSegura";
		
		User newUser = new User(name, surname, cpf, email, password);
		
		Main main = new Main();
		
		main.createUser(newUser);
		main.deleteUser(newUser);
		
		assertEquals(0, main.getUsers().size());
		
	}

}
