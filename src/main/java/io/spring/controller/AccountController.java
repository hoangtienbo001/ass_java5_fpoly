package io.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.spring.entities.Account;
import io.spring.service.AccountService;

@Controller
@RequestMapping("/admin")
public class AccountController {
	@Autowired(required = true)
	private AccountService accountService;

	private Integer idPb = null;
	private int index = -1;

	/*list acc */
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public ModelAndView accountPage() {
		ModelAndView m = new ModelAndView("accountListPage");
		m.addObject("accountsList", accountService.getAllAccount());
		return m;
	}

	/*create acc*/
	@RequestMapping(value = "/accounts/create", method = RequestMethod.GET)
	public ModelAndView accountViewCreatePage(Model model) {
		idPb = null;
		ModelAndView m = new ModelAndView("AccounttCreatePage");
		model.addAttribute("account", new Account());
		return m;
	}

	@RequestMapping(value = "/accounts/create", method = RequestMethod.POST)
	public String saveCategory(@Validated @ModelAttribute("account") Account account, BindingResult bindingResult,
			RedirectAttributes redirAttrs, Model model, @RequestParam("username") String user) {
		boolean check = bindingResult.hasErrors();
		List<Account> list = accountService.getAllAccount();
		if (!check) {
			/*create*/
			if (idPb == null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getUsername().equalsIgnoreCase(user)) {
						model.addAttribute("userMessage", "Tài khoản đã tồn tại!");
						return "AccounttCreatePage";
					}
				}
				redirAttrs.addFlashAttribute("Message", "Tạo mới tài khoản thành công!");
				accountService.create(account);
				return "redirect:/admin/accounts";
			}
			/*update*/
			else {
				redirAttrs.addFlashAttribute("Message", "Cập nhật tài khoản thành công!");
				accountService.create(account);
				return "redirect:/admin/accounts";
			}
		} else {
			if (idPb == null) {
				return "AccounttCreatePage";
			} else {
				return "AccountUpdatePage";
			}
		}
	}

	/*
	 * cập nhật tài khoản
	 */
//	@RequestMapping(value = "/accounts/update/{id}", method = RequestMethod.GET)
//	public ModelAndView accountViewUpdatePage(@PathVariable(name = "id") String id, Model model) {
//		ModelAndView m = new ModelAndView("AccountUpdatePage");
//		Account account = AccountService
//		idPb = account.getId();
//		model.addAttribute("account", account);
//		return m;
//	}
	
	/*delete acc*/
	@RequestMapping(value = "/accounts/delete/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable(name = "id") String id, RedirectAttributes redirAttrs, Model model) {
		redirAttrs.addFlashAttribute("Message", "đã xóa thành công");
		accountService.delete(Integer.parseInt(id));
		return "redirect:/admin/accounts";
	}

}
