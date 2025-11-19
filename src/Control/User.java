package Control;
import java.util.ArrayList;

public class User{
	
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private ArrayList<BookClub> joinedBookClubs;
	private static final int MAX_BOOKCLUBS_PER_USER = 20;
	private static int numUsersCreated = 0;
	
	public User(String name, String surname, String email, String cpf, String password) {
		
		this.id = ++numUsersCreated;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		
	}


// Converte o objeto para uma String legivel	
@Override
	public String toString() {
		return String.format("User{id=%d, name='%s', surname='%s', email='%s'}", id, name, surname, email, password);
	}


}
