package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jason Mahdjoub
 * @version 1.0
 * @since SpringBoot
 */
@Controller
@SessionAttributes("valueSession2")
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name",required=false,defaultValue="World") String name,
						   	Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	private int valueSession2=42;

	private int value=42;
	@ModelAttribute("value")
	public int getValue() {
		return value;
	}
	@RequestMapping("/endsession")
	public String endSession(HttpSession session){
		session.invalidate();
		return "redirect:/testParam/42";
	}

	//@GetMapping("/clients")
	//public String clients(Model model,
	//					  HttpSession session)
	//{
	//	return "clients";
	//}

	@GetMapping("/testParam/{id}")
	public String testParam(@PathVariable int id,
							Model model,
							HttpSession session,
							@CookieValue(value = "foo2", defaultValue = "hello") String fooCookie,
							HttpServletResponse response)
	{
		model.addAttribute("id", id);
		model.addAttribute("oldValueSession", session.getAttribute("valueSession"));
		session.setAttribute("valueSession", id);
		model.addAttribute("foo", fooCookie);
		response.addCookie(new Cookie("foo2", "newValue"));
		return "param";
	}

	//@ModelAttribute("listeClients")
	//public List<String> getSomeList(){
	//	return Arrays.asList("Client 1", "Client 2", "Client 3");
	//}
}