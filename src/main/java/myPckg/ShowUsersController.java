package myPckg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class ShowUsersController {
    static int j = 1;
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public String users(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                        Map<String, Object> model) {
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);
        System.out.println("1");
        return "users";
    }

    @GetMapping("/main")
    public String main(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Map<String, Object> model) {
        Iterable<Notes> users = messageRepo.findAll();

        model.put("users", users);
        System.out.println("2");
        return "main";
    }

    @PostMapping("/main")
    public String main3(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Map<String, Object> model) {
        Iterable<Notes> users = messageRepo.findAll();

        model.put("users", users);
        System.out.println("2");
        return "main";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        System.out.println("3");
        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/main";
    }

    @GetMapping("/")
    public String main2(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Map<String, Object> model) {
        Iterable<Notes> users = messageRepo.findAll();
        System.out.println("4");
        model.put("users", users);

        return "main";
    }

    @GetMapping("/registration")
    public String reg() {
        System.out.println("5");
        return "registration";
    }

    @PostMapping("add")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Notes user = new Notes(j, text, tag);
        j++;
        messageRepo.save(user);

        Iterable<Notes> users = messageRepo.findAll();

        model.put("users", users);
        System.out.println("6");
        return "main";
    }
    @GetMapping("/messageById/{id}")
    public String messageById2(@PathVariable String id, Map<String, Object> model){
        int intId = Integer.parseInt(id);
        List<Notes> foundNotes  = messageRepo.findById(intId);
        model.put("users", foundNotes);
        return "messageById";
    }
    @GetMapping("/messageById")
    public String messageById(@RequestParam String text, Map<String, Object> model){
        int intId = Integer.parseInt(text);
        List<Notes> foundNotes  = messageRepo.findById(intId);
        model.put("users", foundNotes);
        return "messageById";
    }
    @PostMapping
    public String add3(Map<String, Object> model) {
        System.out.println("7");
        return "login.mustache";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String text, Map<String, Object> model) {
        System.out.println("8");
        List<Notes> users = messageRepo.findByName(text);
        model.put("users", users);
        return "main";
    }

    @PostMapping("filterById")
    public String filterById(@RequestParam String text, Map<String, Object> model){
        int id = Integer.parseInt(text);
        Iterable<Notes> users = messageRepo.findNotesWithIdMoreThanX(id);
        model.put("users", users);
        return "main";
    }

    @GetMapping("/login")
    public String login23(){
        System.out.println("a");
        return "login.mustache";
    }

}
