import myPckg.User;
import myPckg.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
    @Mock
    UserRepo userRepo;

    @Test
    public void addUser(){
        User x = new User();
        User y = new User();
        userRepo.save(new User());
        userRepo.save(x);
        userRepo.save(y);
        Mockito.verify(userRepo, Mockito.times(1)).save(x);
    }
}
