package myPckg;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowUsersController {
    @GetMapping("/users")
    public String users(@RequestParam(name = "name", required = false,defaultValue = "World") String name,
                        Model model){
        return "users";
    }
}
