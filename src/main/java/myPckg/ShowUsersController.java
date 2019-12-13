package myPckg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class ShowUsersController {
    static int j = 0;
    @Autowired
    private MessageRepo repo;
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
        Iterable<Notes> users = repo.findAll();

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

        return "redirect:/login";
    }

    @GetMapping("/")
    public String main2(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Map<String, Object> model) {
        Iterable<Notes> users = repo.findAll();
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
        repo.save(user);

        Iterable<Notes> users = repo.findAll();

        model.put("users", users);
        System.out.println("6");
        return "main";
    }

    @PostMapping
    public String add3(Map<String, Object> model) {
        System.out.println("7");
        return "login.mustache";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String text, Map<String, Object> model) {
        System.out.println("8");
        List<Notes> users = repo.findByName(text);
        model.put("users", users);
        return "main";
    }

    @GetMapping("/login")
    public String login23(){
        System.out.println("a");
        return "login.mustache";
    }
}
