package com.example;

import com.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
@Controller
public class XMLController {

    @Autowired
    CustomerRepository custoRep;

    @Autowired
    AdresseMailInterface adresseInter;

    private long getLong(String value){
        return Long.parseLong(value);
    }

    @RequestMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody
    CustomerXML XMLrequests(@RequestParam(value = "id", required = false, defaultValue = "0") String id,
                            @RequestParam(value = "action", required = false, defaultValue = "contacts") String action)
    {

        CustomerXML customer = new CustomerXML();

        switch(action){
            case "contacts":
                for (Customer custo : custoRep.findAll()) {
                    custo.setMails(null); // on set à null pour éviter une boucle infinie de génération de XML
                    custo.setAdressesPostales(null); //même raison ici
                    customer.getCustomer().add(custo);
                }
                return customer;
            case "contact":
                Customer custo = custoRep.findById(getLong(id));
                custo.setMails(null);
                custo.setAdressesPostales(null);
                customer.getCustomer().add(custo);
                return customer;
        }
        return null;
    }
}
