package by.home.controller;

import by.home.entity.User;
import by.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public ModelAndView getRegistrationPage(ModelAndView modelAndView){
        modelAndView.setViewName("user/registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView postRegistrationPage(User user, ModelAndView modelAndView){
        userService.addUser(user);
        modelAndView.setViewName("redirect:authorization");
        return modelAndView;
    }

    @GetMapping("/authorization")
    public ModelAndView getAuthorizationPage(ModelAndView modelAndView){
        modelAndView.setViewName("user/authorization");
        return modelAndView;
    }

    @PostMapping("/authorization")
    public ModelAndView postAuthorizationPage(User user, ModelAndView modelAndView, HttpSession httpSession){
        User byLogin = userService.getByLogin(user);
        if (byLogin != null && userService.checkPassword(byLogin, user.getPassword())) {
            httpSession.setAttribute("user",byLogin);
            modelAndView.setViewName("redirect:/");
        }else {
            modelAndView.addObject("wrongResult","Wrong login or password!");
            modelAndView.setViewName("user/authorization");
        }
        return modelAndView;
    }

}
