package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.repository.BookClubRepository;
import com.service.UserService;
import com.model.BookClub;
import com.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BookClubRepositoryTest {

    private static final String TEST_PATH = "bookClubs.txt";

    // Limpa o arquivo antes de cada teste
    private void resetFile() throws IOException {
        File f = new File(TEST_PATH);
        if (f.exists()) f.delete();
        f.createNewFile();
    }

    @Test
    public void testSaveAndLoad() throws IOException{
        resetFile();

        UserService us = new UserService();
        BookClubRepository repo = new BookClubRepository();


        User u  = new User("Teste", "Creator", "111", "c@test", "123");
        
        // O criador precisa estar registrado no sistema de usuarios    
            us.getUsers().add(u);
       
        BookClub bc = new BookClub(u, "Clube de Teste");

        ArrayList<BookClub> lista = new ArrayList<>();
        lista.add(bc);

        repo.saveAll(lista);

        ArrayList<BookClub> carregado = repo.loadAll(us);

        assertEquals(1, carregado.size());
        assertEquals("Clube de Teste", carregado.get(0).getName());
        assertEquals(u.getId(), carregado.get(0).getCreator().getId());
    }
}
