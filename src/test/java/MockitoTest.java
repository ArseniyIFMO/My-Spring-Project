import myPckg.User;
import myPckg.UserRepo;
import myPckg.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
//    @Autowired
//    UserService userSerice;

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
