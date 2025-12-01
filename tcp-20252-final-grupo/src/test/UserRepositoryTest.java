package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.repository.UserRepository;
import com.model.User;

import java.io.*;
import java.util.ArrayList;

public class UserRepositoryTest {

    private static final String TEST_PATH = "users.txt";

    // Limpa o arquivo antes de cada teste
    private void resetFile() throws IOException {
        File f = new File(TEST_PATH);
        if (f.exists()) f.delete();
        f.createNewFile();
    }

    @Test
    public void testSaveAndLoadUser() throws IOException {
        resetFile();

        User u1 = new User(1, "Leandro", "Silva", "leandro@test", "111", "123");
        User u2 = new User(2, "Bob", "Esponja", "bob@test", "222", "abc");

        ArrayList<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);

        UserRepository repo = new UserRepository();

        repo.saveAll(list);

        ArrayList<User> loaded = repo.loadAll();

        assertEquals(2, loaded.size());

        // Usuário 1
        assertEquals(1, loaded.get(0).getId());
        assertEquals("Leandro", loaded.get(0).getName());
        assertEquals("Silva", loaded.get(0).getSurname());
        assertEquals("leandro@test", loaded.get(0).getEmail());
        assertEquals("111", loaded.get(0).getCpf());
        assertEquals("123", loaded.get(0).getPassword());

        // Usuário 2
        assertEquals(2, loaded.get(1).getId());
        assertEquals("Bob", loaded.get(1).getName());
    }

    @Test
    public void testLoadWhenFileDoesNotExist() throws IOException {
        File f = new File(TEST_PATH);
        if (f.exists()) f.delete();

        UserRepository repo = new UserRepository();
        ArrayList<User> loaded = repo.loadAll();

        assertEquals(0, loaded.size());
    }

}