import myPckg.MessageRepo;
import myPckg.ShowUsersController;
import myPckg.UserRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShowUsersController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ShowUserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private MessageRepo messageRepo;

    @MockBean
    private UserRepo userRepo;

    @Test
    public void testAdd() throws Exception {
        LinkedMultiValueMap map = new LinkedMultiValueMap<>();
        map.add("text", "text");
        map.add("tag", "tag");
        MvcResult result = mockMvc.perform(post("/add").params(map)).andReturn();
        verify(messageRepo).save(any());
    }
}
