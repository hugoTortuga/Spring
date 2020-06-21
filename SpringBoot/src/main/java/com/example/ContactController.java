package com.example;

import com.example.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
public class ContactController implements WebMvcConfigurer {
	private static final Logger log = LoggerFactory.getLogger(ServingWebContentApplication.class);

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private AdressePostaleInterface adresseRepository;

	@Autowired
	private AdresseMailInterface mailRepository;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}


	@GetMapping("/")
	public String showMenu(PersonForm personForm) {
		return "main";
	}

	@GetMapping("/form")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	@PostMapping("/form")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult, HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		repository.save(new Customer(personForm.getPrenom(),personForm.getName()));

		return "redirect:/clients";
	}


	long idParam;

	@GetMapping("/update")
	public String updateGet(PersonForm personForm, @RequestParam(value="id", required = false, defaultValue = "0") long param, Model model) {
		model.addAttribute("id", param);
		idParam = param;
		return "update";
	}

	@PostMapping("/update")
	public String updatePost(@Valid PersonForm personForm, BindingResult bindingResult, Model model) {

		if(idParam == 0)
			return "redirect:/clients";

		Customer customer = repository.findById(idParam);
		customer.setFirstName(personForm.getPrenom());
		customer.setLastName(personForm.getName());
		repository.save(customer);
		return "redirect:/clients";
	}

	@GetMapping("/delete")
	public String delete(PersonForm personForm, @RequestParam(value="id", required = false, defaultValue = "0") long param, Model model) {
		model.addAttribute("id", param);
		repository.deleteById(param);
		return "redirect:/clients";
	}

}
