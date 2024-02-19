package com.operation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.operation.dao.ProductDao;
import com.operation.entity.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model m) {
		System.out.println("Product on ");
		List<Product> products = productDao.getProducts();
		m.addAttribute("product", products);
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title","Add Product");
		return "add_product_form";
	}
	
	@RequestMapping(value="/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest hsr) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView rv=new RedirectView();
		rv.setUrl(hsr.getContextPath()+"/");
		return rv;
	}
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId,HttpServletRequest hsr) {
		this.productDao.deleteProduct(productId);
		RedirectView rv=new RedirectView();
		rv.setUrl(hsr.getContextPath()+"/");
		return rv;
	}
	
	@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId") int productId,Model m ) {
		Product product = this.productDao.getProduct(productId);
		m.addAttribute("product", product);
		return "update_form";
	}
	
}

































