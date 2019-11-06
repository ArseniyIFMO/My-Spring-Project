package myPckg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ShowUsersController {
    static  int j = 0;
    @Autowired
    private MessageRepo repo;
    @GetMapping("/users")
    public String users(@RequestParam(name = "name", required = false,defaultValue = "World") String name,
                        Model model){
        return "users";
    }

    @GetMapping("/main")
    public String main(@RequestParam(name = "name", required = false,defaultValue = "World") String name, Map<String, Object> model){
        Iterable<Notes> users = repo.findAll();

        model.put("users", users);

        return "main";
    }
    @GetMapping("/")
    public String main2(@RequestParam(name = "name", required = false,defaultValue = "World") String name, Map<String, Object> model){
        Iterable<Notes> users = repo.findAll();

        model.put("users", users);

        return "main";
    }
    @PostMapping("add")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
       Notes user = new Notes(j, text, tag);
        j++;
        repo.save(user);

        Iterable<Notes> users = repo.findAll();

        model.put("users", users);

        return "main";
    }
    @PostMapping
    public String add3(Map<String, Object> model) {
        return "login";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String text, Map<String, Object> model){
        List<Notes> users = repo.findByName(text);
        model.put("users", users);
        return "main";
    }

}
