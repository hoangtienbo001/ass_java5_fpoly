package io.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import io.spring.repository.ProductRepository;
import io.spring.service.ProductService;
import io.spring.service.ProductServiceImpl;
@Controller
public class HomeController {
	
//	@GetMapping(value={"/home","/index","/",""})
//	public String homePage(Model model){
//		model.addAttribute("user","HTB");
//		return "homePage";
//	}
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value={"/produc"})
	public String productPage(Model model){
		model.addAttribute("user","Product Page");
		return "products/list";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView productPage() {
		ModelAndView m = new ModelAndView("homePage");
		m.addObject("homePage", productService.getAllProducts());
		return m;
	}

	
}
