package com.bookstore.demo.controller;

import com.bookstore.demo.entity.User;
import com.bookstore.demo.service.UserService;
import com.sun.deploy.net.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        User user=(User)request.getSession().getAttribute("user");
        if(user==null)
            return "user/login";
        else
            return "index";
    }

    @RequestMapping("user/getAll")
    public String list(Model model) {
        List<User> users=userService.getUserList();
        model.addAttribute("users", users);
        return "user/getAll";
    }

    @RequestMapping("/user/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/user/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/user/getAll";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,int id) {
        User user=userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/list";
    }

    @ResponseBody
    @RequestMapping("/user/del")
    public String delete(@RequestParam(name = "id")int id) {
        userService.delete(id);
        return "1";
    }

    @RequestMapping("/login")
    public String login(User user, Model model){
        if(userService.findUser(user)==true) {
            model.addAttribute("user",user);
            return "index";
        }
        else
            return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "user/login";
    }

    @RequestMapping("/userWatch")
    public String watch(HttpServletRequest request){
        return "user/userWatch";
    }
}
