package com.example.secureWeb;

import com.example.model.Customer;
import com.example.model.CustomerRepository;
import com.example.model.LoginForm;
import com.example.model.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String getClients(Model model, @Valid LoginForm loginForm,
                          HttpSession session)
    {
        return "login";
    }

    @PostMapping("/login")
    public String clients(Model model, @Valid LoginForm loginForm,
                          HttpSession session)
    {
        return "login";
    }


    @PostMapping("/logout")
    public String logout()
    {
        return "main";
    }
}
