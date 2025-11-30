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

            Creator c = new Creator("Pedro", "Alberto", "p@mail", "222", "abc");
            c.setId(20);

            userService.getUsers().add(c);

            BookClubService bcService = new BookClubService(userService);

            


        // Criar dois clubes
        BookClub c1 = bcService.createClub(c, "Clube 2");
        BookClub c2 = bcService.createClub(c, "Clube 3");

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

    @Test
        public void testGetClubsForUser() {

        UserService userService = new UserService();
        userService.getUsers().clear();

        // Criar dois usuários
        Creator creator = new Creator("Ana", "Silva", "ana@mail", "444", "pw");
        creator.setId(1);

        User participant = new User("Joao", "Souza", "joao@mail", "555", "pw");
        participant.setId(2);

        userService.getUsers().add(creator);
        userService.getUsers().add(participant);

        BookClubService bcService = new BookClubService(userService);

        BookClub club1 = bcService.createClub(creator, "Clube A"); // criador participa
        BookClub club2 = bcService.createClub(creator, "Clube B"); // criador participa
        BookClub club3 = bcService.createClub(creator, "Clube C"); // criador participa

        // Adicionar participante apenas ao clube 2
        club2.getParticipants().add(participant);

        // Testar clubes do criador
        ArrayList<BookClub> creatorClubs = bcService.getClubsForUser(creator);
        assertEquals(3, creatorClubs.size());
        assertTrue(creatorClubs.contains(club1));
        assertTrue(creatorClubs.contains(club2));
        assertTrue(creatorClubs.contains(club3));

        // Testar clubes do participante
        ArrayList<BookClub> participantClubs = bcService.getClubsForUser(participant);
        assertEquals(1, participantClubs.size());
        assertEquals(club2, participantClubs.get(0));

        // Testar usuário que não participa nem criou
        User stranger = new User("Mario", "Oliveira", "m@mail", "999", "pw");
        stranger.setId(7);
        userService.getUsers().add(stranger);

        ArrayList<BookClub> strangerClubs = bcService.getClubsForUser(stranger);
        assertEquals(0, strangerClubs.size());

        // Verificar que o serviço mantém os 3 clubes
        assertEquals(3, bcService.getAllClubs().size());
}

    @Test
    public void testDuplicateClubNameIsNotAllowed() {

        UserService userService = new UserService();
        userService.getUsers().clear();

        Creator c = new Creator("Ana", "Silva", "ana@mail", "111", "pw");
        c.setId(50);
        userService.getUsers().add(c);

        BookClubService bcService = new BookClubService(userService);

        BookClub first = bcService.createClub(c, "Clube");
        assertNotNull(first);
        assertEquals("Clube", first.getName());

        BookClub duplicate = bcService.createClub(c, "Clube");
        assertNull(duplicate);  

        // Criador deve ter apenas 1 clube
        assertEquals(1, c.getCreatedBookClubs().size());
        assertEquals(first, c.getCreatedBookClubs().get(0));

        // Serviço também deve ter apenas 1 clube
        assertEquals(1, bcService.getAllClubs().size());
        assertEquals("Clube", bcService.getAllClubs().get(0).getName());
}




}