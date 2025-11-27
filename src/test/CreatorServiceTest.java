package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.model.BookClub;
import com.model.Creator;
import com.model.User;
import com.service.BookClubService;
import com.service.CreatorService;
import com.service.UserService;

import java.io.File;
import java.io.IOException;

public class CreatorServiceTest {

    private static final String USERS = "users.txt";
    private static final String CLUBS = "bookClubs.txt";

    // Nesse teste é preciso resetar os dois arquivos 
    private void resetFiles() throws IOException {
        File fu = new File(USERS);
        if (fu.exists()) fu.delete();
        fu.createNewFile();

        File fc = new File(CLUBS);
        if (fc.exists()) fc.delete();
        fc.createNewFile();
    }

    @BeforeEach
    public void setup() throws IOException {
        resetFiles();
    }

 
    @Test
    public void testDeleteClubSuccess() {

        UserService userService = new UserService();
        userService.getUsers().clear();

        BookClubService bcService = new BookClubService(userService);

        CreatorService creatorService = new CreatorService(bcService);


        User u = new User("Nome", "Sobrenome", "email@gmail.com", "111", "pw");
        u.setId(10);
        userService.getUsers().add(u);

   
        BookClub bc = bcService.createClub(u, "Clube1");

        Creator c = (Creator) userService.findById(10);

        boolean ok = creatorService.deleteClub(c, bc.getId());

        assertTrue(ok);
        assertEquals(0, c.getCreatedBookClubs().size());
        assertEquals(0, bcService.getAllClubs().size());
    }


    @Test
    public void testDeleteClubFailNotOwner() {

        UserService userService = new UserService();
        userService.getUsers().clear();

        BookClubService bcService = new BookClubService(userService);
        CreatorService creatorService = new CreatorService(bcService);

        // Criador 1
        User u1 = new User("Criador", "1", "1@mail", "111", "x");
        u1.setId(20);
        userService.getUsers().add(u1);

        // Criador 2
        User u2 = new User("Criador", "2", "2@mail", "222", "y");
        u2.setId(30);
        userService.getUsers().add(u2);

        BookClub bc = bcService.createClub(u1, "Clube 2");

    
        Creator c2 = userService.promoteUserToCreator(u2);

        
        boolean ok = creatorService.deleteClub(c2, bc.getId());

        assertFalse(ok);

        
        assertEquals(1, bcService.getAllClubs().size());
    }


    @Test
    public void testDeleteUpdatesFile() throws IOException {

        UserService userService = new UserService();
        userService.getUsers().clear();

        BookClubService bcService = new BookClubService(userService);
        CreatorService creatorService = new CreatorService(bcService);

        User u = new User("Criador", "1", "1@mail", "444", "pass");
        u.setId(40);
        userService.getUsers().add(u);

        BookClub bc = bcService.createClub(u, "Clube 4");

        Creator c = (Creator) userService.findById(40);

        creatorService.deleteClub(c, bc.getId());

        BookClubService reload = new BookClubService(userService);

        assertEquals(0, reload.getAllClubs().size());
    }
}