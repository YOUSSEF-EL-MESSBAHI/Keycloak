package com.mesbahi.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keycloak.adapters.AdapterDeploymentContext;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.spi.HttpFacade;
import org.keycloak.adapters.springsecurity.facade.SimpleHttpFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mesbahi.repo.ProductRepo;

@Controller
public class ProductController {
	@Autowired 
	private ProductRepo productRepo;
	@Autowired
	private AdapterDeploymentContext adapterDeploymentContext;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/products")
	public String index(Model model) {
		model.addAttribute("products", productRepo.findAll());
		return "products";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws ServletException {
		request.logout();
		return "redirect:/index";
	}
	@GetMapping("/changePassword")
	public String cpw(RedirectAttributes attributes,HttpServletRequest request,HttpServletResponse response){
		HttpFacade facade=new SimpleHttpFacade(request, response);
		KeycloakDeployment deployment=adapterDeploymentContext.resolveDeployment(facade);
		attributes.addAttribute("referrer", deployment.getResourceName());
		return "redirect:" +deployment.getAccountUrl()+ "/password";
	}
	
}
