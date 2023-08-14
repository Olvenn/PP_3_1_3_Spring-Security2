package springSecurity.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springSecurity.models.User;
import springSecurity.service.UserServiceImp;
import springSecurity.util.UserValidator;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class UsersController {

    private UserServiceImp userService;

    @Autowired
    public UsersController(UserServiceImp userService) {

        this.userService = userService;
    }

    @GetMapping("/user")
    public String showUser(Model model, Principal principal) {
        model.addAttribute("user",
                userService.findByUsername(principal.getName()));
        System.out.println(principal.getName());
        return "users/user";
    }


}
