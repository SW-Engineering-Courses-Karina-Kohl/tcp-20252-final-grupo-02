package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.model.BookClub;
import com.model.Creator;
import com.model.User;
import com.service.BookClubService;
import com.service.UserService;

import java.io.*;
import java.util.ArrayList;

public class BookClubServiceTest {

    private static final String USERS = "users.txt";
    private static final String CLUBS = "bookClubs.txt";

    private void resetFiles() throws IOException {
        File u = new File(USERS);
        if (u.exists()) u.delete();
        u.createNewFile();

        File c = new File(CLUBS);
        if (c.exists()) c.delete();
        c.createNewFile();
    }

    @BeforeEach
    public void setup() throws IOException {
        resetFiles();
    }

    @Test
    public void testCreateClubAndPromotion() {


        UserService userService = new UserService();
        userService.getUsers().clear(); 

        BookClubService bcService = new BookClubService(userService);

     
        User u = new User("Nome", "Sobrenome", "nome@mail", "111", "123");
        u.setId(10);
        userService.getUsers().add(u);

        // Criar o clube promove o usuario automaticamente 
        BookClub bc = bcService.createClub(u, "Clube 1");

        assertNotNull(bc);
        assertEquals("Clube 1", bc.getName());

        assertTrue(userService.findById(10) instanceof Creator);

        Creator c = (Creator) userService.findById(10);

        // Criador deve ter o clube na lista dele
        assertEquals(1, c.getCreatedBookClubs().size());
        assertEquals(bc, c.getCreatedBookClubs().get(0));

        // Clubes devem ter sido persistidos
        ArrayList<BookClub> loaded = bcService.getAllClubs();
        assertEquals(1, loaded.size());
        assertEquals("Clube 1", loaded.get(0).getName());
    }

    @Test
    public void testMultipleClubsCreation() {

        UserService userService = new UserService();
        userService.getUsers().clear();

        BookClubService bcService = new BookClubService(userService);

        User u = new User("Pedro", "Alberto", "p@mail", "222", "abc");
        u.setId(20);

        userService.getUsers().add(u);

        // Criar dois clubes
        BookClub c1 = bcService.createClub(u, "Clube 2");
        BookClub c2 = bcService.createClub(u, "Clube 3");

        // Criador automaticamente
        Creator creator = (Creator) userService.findById(20);

        assertEquals(2, creator.getCreatedBookClubs().size());
        assertEquals(c1, creator.getCreatedBookClubs().get(0));
        assertEquals(c2, creator.getCreatedBookClubs().get(1));

        // Serviço deve ter ambos
        assertEquals(2, bcService.getAllClubs().size());
    }

    @Test
    public void testClubCreationPersistsToFile() throws IOException {

        UserService userService = new UserService();
        userService.getUsers().clear();

        BookClubService bcService = new BookClubService(userService);

        User u = new User("Carlos", "Pereira", "c@mail", "333", "pw");
        u.setId(30);
        userService.getUsers().add(u);

        bcService.createClub(u, "Clube 4");

        // Carregar novamente do arquivo
        BookClubService bcServiceReloaded = new BookClubService(userService);

        assertEquals(1, bcServiceReloaded.getAllClubs().size());
        assertEquals("Clube 4", bcServiceReloaded.getAllClubs().get(0).getName());
    }
}