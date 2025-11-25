package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.AppSystem;
import com.model.Creator;

public class CreatorTest {

	@Test
	public void testConstructor() {
		
		String name = "Matheus";
		String surname = "Candiotto";
		String email = "matheus.candiotto@ufrgs.br";
		String cpf = "012345678-90";
		String password = "SenhaMuitoSegura";
		
		Creator newCreator = new Creator(name, surname, email, cpf, password);
		
		assertEquals(Creator.getNumUsersCreated(), newCreator.getId());
		assertEquals(name, newCreator.getName());
		assertEquals(surname, newCreator.getSurname());
		assertEquals(cpf, newCreator.getCpf());
		assertEquals(email, newCreator.getEmail());
		assertEquals(password, newCreator.getPassword());
		assertEquals(0, newCreator.getJoinedBookClubs().size());
		assertEquals(0, newCreator.getCreatedBookClubs().size());
		
	}
	
	@Test
	public void testCreateCreator() {
		
		String name = "Matheus";
		String surname = "Candiotto";
		String cpf = "012345678-90";
		String email = "matheus.candiotto@ufrgs.br";
		String password = "SenhaMuitoSegura";
		
		Creator newCreator = new Creator(name, surname, cpf, email, password);
		
		AppSystem appSystem = new AppSystem();
		
		appSystem.createUser(newCreator);
		
		assertEquals(1, appSystem.getUsers().size());
		
	}
	
	@Test
	public void testDeleteCreator() {
		
		String name = "Matheus";
		String surname = "Candiotto";
		String cpf = "012345678-90";
		String email = "matheus.candiotto@ufrgs.br";
		String password = "SenhaMuitoSegura";
		
		Creator newCreator = new Creator(name, surname, cpf, email, password);
		
		AppSystem appSystem = new AppSystem();		
		appSystem.createUser(newCreator);
		appSystem.deleteUser(newCreator);
		
		assertEquals(0, appSystem.getUsers().size());
		
	}

}
