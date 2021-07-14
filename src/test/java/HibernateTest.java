import myPckg.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@SpringBootTest(classes = Main.class)
public class HibernateTest {
    @Autowired
    private MessageRepo repo;

    @Test
    public void f() throws SQLException {
        Notes x = new Notes(1, "x", "y");
        Notes y = new Notes(2, "x", "y");
        Notes z = new Notes(3, "x", "y");
        repo.save(x);
        repo.save(y);
        repo.save(z);
        assertEquals(1,repo.findNotesWithIdMoreThanX(2).size());
    }
}
