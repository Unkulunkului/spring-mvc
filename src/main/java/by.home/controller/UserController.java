package by.home.controller;

import by.home.entity.User;
import by.home.entity.UserModel;
import by.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/user")

public class UserController{


    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public ModelAndView getRegistrationPage(ModelAndView modelAndView){
        modelAndView.setViewName("user/registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView postRegistrationPage(@Valid User user, BindingResult bindingResult, ModelAndView modelAndView){
        if (bindingResult.hasErrors()) {
            Map<String, String> a = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                a.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            System.out.println(a);
            modelAndView.addAllObjects(a);
            modelAndView.setViewName("user/registration");
        } else {
            userService.addUser(user);
            modelAndView.setViewName("redirect:authorization");
        }
        return modelAndView;
    }

    @GetMapping("/authorization")
    public ModelAndView getAuthorizationPage(ModelAndView modelAndView){
        modelAndView.setViewName("user/authorization");
        return modelAndView;
    }

    @PostMapping("/authorization")
    public ModelAndView postAuthorizationPage(@Valid UserModel userModel, BindingResult bindingResult, ModelAndView modelAndView,
                                              HttpSession httpSession){
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                if(!fieldError.getField().equals("name")) {
                    map.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            modelAndView.addAllObjects(map);
            modelAndView.setViewName("user/authorization");
        }else{
            User user = new User();
            user.setLogin(userModel.getLogin());
            user.setPassword(userModel.getPassword());
            User byLogin = userService.getByLogin(user);
            if (byLogin != null && userService.checkPassword(byLogin, user.getPassword())) {
                httpSession.setAttribute("user",byLogin);
                modelAndView.setViewName("redirect:/");
            }else {
                modelAndView.addObject("wrongResult","Wrong login or password!");
                modelAndView.setViewName("user/authorization");
            }
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView getPage(ModelAndView modelAndView, HttpSession httpSession){
        httpSession.invalidate();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
