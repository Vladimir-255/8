package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //    @GetMapping(value = "")
//    public String printUsers(ModelMap model) {
//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);
//        return "allusers";
//    }
    @GetMapping(value = "")
    public String allUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "allusers";
    }
//////////////////////////////////////////////////
    @GetMapping(value = "/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getByID(id));
        return "updateUser";
    }

    @PutMapping(value ="/{id}/update")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id){
        userService.updateUser(user, id);
        return "redirect:/users";
    }
/////////////////////////////////////////
    @GetMapping(value = "/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
/////////////////////////////////////
    @GetMapping(value = "/{id}")
    public String findUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("curent_user", userService.getByID(id));
        return "user";
    }
////////////////////////////////////////

    @GetMapping(value = "/adduser")
    public String addUser(@ModelAttribute("user") User user) {
        return "adduser";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        System.out.println("post proshel1");
        userService.addUser(user);
        System.out.println("post proshel2");
        return "redirect:/users";

    }
}


