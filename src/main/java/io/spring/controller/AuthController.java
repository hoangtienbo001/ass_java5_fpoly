package io.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.spring.entities.Account;
import io.spring.service.AccountService;
import utils.Const;

@Controller
public class AuthController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET, value = { "/login" })
	public String loginView(Model model) {
		model.addAttribute("account", new Account());
		return "Login";
	}

	@RequestMapping(method = RequestMethod.POST, value = { "", "/login" })
	public String checkLogin(@Validated @ModelAttribute("account") Account account, BindingResult result,
			HttpSession session, @RequestParam("username") String user, @RequestParam("password") String password,
			Model model) {
		boolean check = result.hasErrors();

		account = accountService.findByUser(user, password);

		if (!check) {
			session.setAttribute(Const.USER_LOGGED, account);
			return "redirect:/products";
		} else {
			return "Login";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/404NotFound" })
	public String View404NotFound(Model model) {
		return "404NotFound";
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/account/ban" })
	public String viewBanAccount(Model model) {
		return "BanAccount";
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/home" })
	public String viewClient(Model model) {
		return "ClientView";
	}
}
