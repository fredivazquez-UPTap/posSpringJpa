package edu.uptap.pos.controllers;

import edu.uptap.pos.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String login(Model model) {
        model.addAttribute("message","hello thymeleaf");
        return "login";
    }

}
