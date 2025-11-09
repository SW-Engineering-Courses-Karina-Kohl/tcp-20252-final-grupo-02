package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.Creator;
import com.Main;

public class CreatorTest {

	@Test
	public void testConstructor() {
		
		String name = "Matheus";
		String surname = "Candiotto";
		String email = "matheus.candiotto@ufrgs.br";
		String password = "SenhaMuitoSegura";
		
		Creator newCreator = new Creator(name, surname, email, password);
		
		assertEquals(Creator.getNumUsersCreated(), newCreator.getId());
		assertEquals(name, newCreator.getName());
		assertEquals(surname, newCreator.getSurname());
		assertEquals(email, newCreator.getEmail());
		assertEquals(password, newCreator.getPassword());
		assertEquals(0, newCreator.getJoinedBookClubs().size());
		assertEquals(0, newCreator.getCreatedBookClubs().size());
		
	}
	
	@Test
	public void testCreateCreator() {
		
		String name = "Matheus";
		String surname = "Candiotto";
		String email = "matheus.candiotto@ufrgs.br";
		String password = "SenhaMuitoSegura";
		
		Creator newCreator = new Creator(name, surname, email, password);
		
		Main main = new Main();
		
		main.createUser(newCreator);
		
		assertEquals(1, main.getUsers().size());
		
	}
	
	@Test
	public void testDeleteCreator() {
		
		String name = "Matheus";
		String surname = "Candiotto";
		String email = "matheus.candiotto@ufrgs.br";
		String password = "SenhaMuitoSegura";
		
		Creator newCreator = new Creator(name, surname, email, password);
		
		Main main = new Main();
		
		main.createUser(newCreator);
		main.deleteUser(newCreator);
		
		assertEquals(0, main.getUsers().size());
		
	}

}
