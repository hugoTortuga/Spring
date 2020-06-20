package com.example;

import com.example.model.AdresseMail;
import com.example.model.AdresseMailInterface;
import com.example.model.Customer;
import com.example.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
@Controller
public class ClientsController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/clients")
    public String clients(Model model,
                          HttpSession session)
    {
        return "clients";
    }

    @ModelAttribute("listeClientsAffichage")
    public List<String> getListeClientsAffichage()
    {
        ArrayList<String> results = new ArrayList<String>();

        for (Customer customer : repository.findAll()) {
            results.add(customer.toString());
        }
        return results;
    }

    @ModelAttribute("listeClients")
    public List<Customer> getListeClients()
    {
        return (List<Customer>) repository.findAll();
    }



}
