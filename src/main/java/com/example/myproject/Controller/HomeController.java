package com.example.myproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.myproject.model.User;

@Controller
@ResponseBody
public class HomeController {
    
    @RequestMapping("/")
    public String hello() {
        return "Hello";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public User getUser() {
        User user = new User();
            user.setId("1");
            user.setName("UserName");
            user.setEmailId("user@gmail.com");
            
        return user;
    }

    @GetMapping("/user/{id}/{name}")
    public String getUserById(@PathVariable("id") String id,
                              @PathVariable("name") String name) {

        return "User id " + id + "Name is : " + name;
    }

    @GetMapping("/requestParam")
    public String getUserParameter(@RequestParam String name,
                                    @RequestParam(name = "email",
                                                required = false,
                                                defaultValue = "") String emailId) {
            
        return "name is : " + name + " and emailId is : " + emailId;
    }


}
