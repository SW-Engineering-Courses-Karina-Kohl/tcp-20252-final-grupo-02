package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.model.User;
import com.service.UserService;

import java.io.*;

public class UserServiceTest {

    private static final String TEST_PATH = "users.csv";

    private void resetFile() throws IOException {
        File f = new File(TEST_PATH);
        if (f.exists()) f.delete();
        f.createNewFile();
    }

    

    @Test
    public void testFindByEmail() throws IOException {
        resetFile();

        UserService service = new UserService();
        service.getUsers().clear();

        User u = new User("Bob", "Esponja", "bob@test", "222", "abc");
        service.getUsers().add(u);

        assertNotNull(service.findUserByEmail("bob@test"));
        assertNull(service.findUserByEmail("nao_existe"));
    }

    @Test
    public void testFindById() throws IOException {
        resetFile();

        UserService service = new UserService();
        service.getUsers().clear();

        User u = new User("Ana", "Maria", "ana@test", "333", "pw");
        u.setId(99);

        service.getUsers().add(u);

        assertEquals(u, service.findById(99));
        assertNull(service.findById(100));
    }
}