package com.example;

import com.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
@Controller
public class AdresseController {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private AdressePostaleInterface adresseRepository;

    private long idCusto;

    @GetMapping("/formAdresse")
    public String AdresseAdd(@Valid AdresseForm adresseForm, @RequestParam(value="id", required = false, defaultValue = "0") long param, Model model){
        model.addAttribute(param);
        idCusto = param;
        return "formAdresse";
    }

    @PostMapping("/formAdresse")
    public String checkAdresse(@Valid AdresseForm adresseForm, BindingResult bindingResult, HttpServletRequest request, @RequestParam(value="id", required = false, defaultValue = "0") long param, Model model) {

        if (bindingResult.hasErrors()) {
            return "formAdresse";
        }

        AdressePostale ap = new AdressePostale();
        ap.setCodePostal(adresseForm.getCodepostale());
        ap.setNumRue(adresseForm.getNumRue());
        ap.setVille(adresseForm.getVille());
        ap.setRue(adresseForm.getRue());

        Customer c = repository.findById(idCusto);
        Collection<AdressePostale> adressses = c.getAdressesPostales();
        if(adressses != null){
            adressses.add(ap);
        }
        c.setAdressesPostales(adressses);
        adresseRepository.save(ap);
        repository.save(c);

        System.out.println("SAVE réussi");

        return "redirect:/clients";
    }


    @GetMapping("/adresses")
    public String mailsId(@RequestParam(name="id",required=false,defaultValue="0") long id, Model model)
    {
        model.addAttribute("id", id);
        return "adresses";
    }

    @ModelAttribute("listeAdresses")
    public List<String> getListeAdresses(@RequestParam(name="id",required=false,defaultValue="0") long id, Model model)
    {
        ArrayList<String> results = new ArrayList<String>();
        Customer c = repository.findById(id);
        if(c != null){
            Collection<AdressePostale> mails = c.getAdressesPostales();
            if(mails != null)
                mails.forEach(e -> results.add(e.toString()));
        }
        if(results.size() == 0)
            results.add("Aucune adresse postale");

        return results;
    }

    @ModelAttribute("idContact")
    public int getId(@RequestParam(value="id", required = false, defaultValue = "0") long param){
        return (int)param;
    }



}
