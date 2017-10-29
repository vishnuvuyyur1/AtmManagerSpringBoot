package codebase.ingatmmanager.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Vishnu
 *
 */

@Controller
@Secured("USER")
public class IngAtmManagerAppController {
	
	@RequestMapping("/")
	public String homePage(Model model) {
		model.addAttribute("message", "Welcome to ING ATM Manager");
		return "IngAtmManagerHomePage";
	}
}
