package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.model.BookClub;
import com.model.Poll;
import com.model.User;
import com.model.BookPoll;
import com.model.DatePoll;
import com.service.PollService;

public class ProvServicePollTest {

    private PollService pollService;
    private BookClub clubA;

    @BeforeEach
    public void setup() {
        File f = new File("polls.xls");
        if (f.exists()) f.delete();

        pollService = new PollService();

        User creator = new User("Rafael ", "Silva", "rafa@test", "123", "pw");

        clubA = new BookClub(creator, "Sci-Fi Club");
    }

    @Test
    public void testCriarBookPollParaClube() {
        ArrayList<String> options = new ArrayList<>();
        options.add("Duna");
        options.add("Fundação");

        Poll p = pollService.createPollForBookClub(
            clubA,
            "BOOK",
            "Qual livro ler?",
            options
        );

        // Poll criada corretamente
        assertNotNull(p);
        assertEquals(1, p.getId());
        assertTrue(p instanceof BookPoll);

        // Está no PollService
        assertEquals(1, pollService.getPolls().size());

        // Está dentro do BookClub
        assertEquals(1, clubA.getPolls().size());
        assertEquals(p, clubA.getPolls().get(0));

        // Relacionamento bidirecional
        assertEquals(clubA, p.getBookClub());
    }

    @Test
    public void testCriarDatePollParaClube() {
        ArrayList<String> options = new ArrayList<>();
        options.add("05/03");
        options.add("07/03");

        Poll p = pollService.createPollForBookClub(
            clubA,
            "DATE",
            "Quando será o encontro?",
            options
        );

        // Poll criada corretamente
        assertNotNull(p);
        assertEquals(1, p.getId());
        assertTrue(p instanceof DatePoll);
        assertEquals(2, p.getOptions().size());
    }

    @Test
    public void testIdsIncrementamCorretamente() {
        ArrayList<String> opts = new ArrayList<>();
        opts.add("A");
        opts.add("B");

        Poll p1 = pollService.createPollForBookClub(clubA, "BOOK", "Teste 1", opts);
        Poll p2 = pollService.createPollForBookClub(clubA, "BOOK", "Teste 2", opts);
        Poll p3 = pollService.createPollForBookClub(clubA, "DATE", "Teste 3", opts);

        assertEquals(1, p1.getId());
        assertEquals(2, p2.getId());
        assertEquals(3, p3.getId());
    }

    @Test
    public void testSaveAndLoadPolls() {
        ArrayList<String> opts = new ArrayList<>();
        opts.add("A");
        opts.add("B");

        // cria duas polls
        pollService.createPollForBookClub(clubA, "BOOK", "Pergunta 1", opts);
        pollService.createPollForBookClub(clubA, "DATE", "Pergunta 2", opts);

        // carrega novamente
        PollService loaded = new PollService();
        ArrayList<BookClub> clubs = new ArrayList<>();
        clubs.add(clubA);

        loaded.loadPolls(clubs);

        // Deve ter carregado as duas
        assertEquals(2, loaded.getPolls().size());
        assertEquals(2, clubA.getPolls().size());

        // Consistência
        assertEquals("Pergunta 1", loaded.getPolls().get(0).getQuestion());
        assertEquals("Pergunta 2", loaded.getPolls().get(1).getQuestion());
    }
}