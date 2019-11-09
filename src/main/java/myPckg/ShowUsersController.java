package myPckg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.util.List;
import java.util.Map;

@Controller
public class ShowUsersController {
    static  int j = 0;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MessageRepo messageRepo;
    @GetMapping("/users")
    public String users(@AuthenticationPrincipal User user, @RequestParam(name = "name", required = false,defaultValue = "World") String name,
                        Model model){
        return "users";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user, @RequestParam(name = "name", required = false,defaultValue = "World") String name, Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findByAuthor(user);//?

        model.put("users", messages);

        return "main";
    }
    @GetMapping("/")
    public String main2(@AuthenticationPrincipal User user, @RequestParam(name = "name", required = false,defaultValue = "World") String name, Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findByAuthor(user);//?

        model.put("users", messages);

        return "main";
    }
    @PostMapping("add")
    public String add(@AuthenticationPrincipal User user,@RequestParam String text, Map<String, Object> model) {
        Message msg = new Message(text, user);//??
        j++;
        messageRepo.save(msg);

        Iterable<Message> messages = messageRepo.findByAuthor(user);//?

        model.put("users", messages);

        return "main";
    }
    @PostMapping
    public String add3(Map<String, Object> model) {
        return "login";
    }

    @PostMapping("filter")
    public String filter(@AuthenticationPrincipal User user, @RequestParam String text, Map<String, Object> model){
        List<Message> users = messageRepo.findByAuthorAndAndText(user ,text);//?
        model.put("users", users);
        return "main";
    }

}
