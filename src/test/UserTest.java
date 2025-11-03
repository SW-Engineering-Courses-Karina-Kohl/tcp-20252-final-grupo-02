package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.User;

public class UserTest {

	@Test
	public void testConstructor() {
		
		String name = "Matheus";
		String surname = "Candiotto";
		String email = "matheus.candiotto@ufrgs.br";
		String password = "SenhaMuitoSegura";
		
		User newUser = new User(name, surname, email, password);
		
		assertEquals(1, newUser.getId());
		assertEquals(name, newUser.getName());
		assertEquals(surname, newUser.getSurname());
		assertEquals(email, newUser.getEmail());
		assertEquals(password, newUser.getPassword());
		assertEquals(0, newUser.getJoinedBookClubs().size());
		assertEquals(1, User.getNumUsersCreated());
		
	}

}
