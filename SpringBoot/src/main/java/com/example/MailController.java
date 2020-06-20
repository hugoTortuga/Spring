package com.example;


import com.example.model.AdresseMail;
import com.example.model.AdresseMailInterface;
import com.example.model.Customer;
import com.example.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
@Controller
public class MailController {

    @Autowired
    private AdresseMailInterface mailInterface;

    @Autowired
    private CustomerRepository repository;


    @GetMapping("/mails")
    public String mailsId(@RequestParam(name="id",required=false,defaultValue="0") long id, Model model)
    {
        model.addAttribute("id", id);
        return "mails";
    }

    @ModelAttribute("listeMailsId")
    public List<String> getListeMailsBycustomer(@RequestParam(name="id",required=false,defaultValue="0") long id, Model model)
    {
        ArrayList<String> results = new ArrayList<String>();
        Customer c = repository.findById(id);
        if(c != null){
            Collection<AdresseMail> mails = c.getMails();
            if(mails != null)
                mails.forEach(e -> results.add(e.getMail()));
        }
        if(results.size() == 0)
            results.add("Aucune adresse email");

        return results;
    }
}
