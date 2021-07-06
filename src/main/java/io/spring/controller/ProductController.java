package io.spring.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.spring.entities.Category;
import io.spring.entities.Product;
import io.spring.service.CategoryService;
import io.spring.service.ProductService;

@Controller
public class ProductController {
	private Integer idPb = null;
	private int index = -1;
	List<Category> list;
	


	@Autowired
	private CategoryService categoryService;

	@GetMapping("product/create")
	public String viewCreate(Model model) {
		model.addAttribute("productForm", new Product());
		return "admin/products/create";
	}

//	@PostMapping("product/create")
//	public String saveProduct(Model model) {
//		return"admin/product/create";
//	}

	@Autowired
	private ProductService productService;

	/* list product */
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView productPage() {
		ModelAndView m = new ModelAndView("productListPage");

		m.addObject("productList", productService.getAllProducts());
		return m;
	}

	/* delete product */
	@RequestMapping(value = "/admin/products/delete/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable(name = "id") String id, RedirectAttributes redirAttrs) {
		productService.delete(Integer.parseInt(id));
		redirAttrs.addFlashAttribute("Message", "đã xóa thành công");
		return "redirect:/products";
	}

	/* create product */
	@RequestMapping(value = "/product/create", method = RequestMethod.POST)
	public String saveProduct(@Validated @ModelAttribute("productForm") Product product, BindingResult bindingResult,
			RedirectAttributes redirAttrs, Model model) {
		boolean check = bindingResult.hasErrors();
		List<Product> list = productService.getAllProducts();
		if (!check) {
			// create
			if (idPb == null) {
				redirAttrs.addFlashAttribute("Message", "Tạo mới danh mục thành công!");
				Date now = new Date();
				Timestamp timestamp = new Timestamp(now.getTime());
				product.setCreatedDate(timestamp);
				productService.create(product);
				return "redirect:/products";
			}
			// update
			else {
				redirAttrs.addFlashAttribute("Message", "Cập nhật danh mục thành công!");
				Date now = new Date();
				Timestamp timestamp = new Timestamp(now.getTime());
				String date = String.valueOf(list.get(index).getCreatedDate());
				product.setCreatedDate(Timestamp.valueOf(date));
				product.setUpdatedDate(timestamp);
				productService.create(product);
				return "redirect:/products";
			}
		} else {
			if (idPb == null) {
				return "ProductCreatePage";
			} else {
				return "ProductUpdatePage";
			}
		}
	}

	/* update product */
	@RequestMapping(value = "/product/update/{id}", method = RequestMethod.GET)
	public ModelAndView productViewUpdatePage(@PathVariable(name = "id") String id, Model model) {
		List<Product> list = productService.getAllProducts();
		ModelAndView m = new ModelAndView("productUpdatePage");
		Product product = productService.getById(id);
		idPb = product.getId();
		index = list.indexOf(product);
		System.out.println(index);
		model.addAttribute("productForm", product);
		m.addObject("categorisList", categoryService.getAllCategories());
		return m;
	}

}
