package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.AppSystem;
import com.model.User;

public class UserTest {

	@Test
	public void testConstructor() {
		
		String name = "Matheus";
		String surname = "Candiotto";
		String cpf = "012345678-90";
		String email = "matheus.candiotto@ufrgs.br";
		String password = "SenhaMuitoSegura";
		
		User newUser = new User(name, surname, email, cpf, password);
		
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
		
		AppSystem appSystem = new AppSystem();		
		appSystem.createUser(newUser);
		
		assertEquals(1, appSystem.getUsers().size());
	
	}
	
	@Test
	public void testDeleteUser() {
		
		String name = "Matheus";
		String surname = "Candiotto";
		String cpf = "012345678-90";
		String email = "matheus.candiotto@ufrgs.br";
		String password = "SenhaMuitoSegura";
		
		User newUser = new User(name, surname, cpf, email, password);
		
		AppSystem appSystem = new AppSystem();
		
		appSystem.createUser(newUser);
		appSystem.deleteUser(newUser);
		
		assertEquals(0, appSystem.getUsers().size());
		
	}

}
