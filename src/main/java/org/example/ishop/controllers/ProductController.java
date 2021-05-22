package org.example.ishop.controllers;

import org.example.ishop.dto.ProductDTO;
import org.example.ishop.dto.converters.ProductConverter;
import org.example.ishop.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductConverter converter;

    @Autowired
    public ProductController(ProductService productService, ProductConverter converter) {
        this.productService = productService;
        this.converter = converter;
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        return "product/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("productDTO") ProductDTO productDTO) {
        productService.save(converter.dtoToEntity(productDTO));
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") String id, Model model) {
        model.addAttribute("productDTO", converter.entityToDTO(productService.findById(id)));
        return "product/edit";
    }

    @PatchMapping("/edit")
    public String update(@ModelAttribute("productDTO") ProductDTO productDTO) {
        productService.update(converter.dtoToEntity(productDTO));
        return "redirect:/product";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        productService.deleteById(id);
        return "redirect:/product";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") String id, Model model) {
        model.addAttribute("productDTO", converter.entityToDTO(productService.findById(id)));
        return "product/one";
    }

    @GetMapping
    public String findAll(Model model) {
        List<ProductDTO> allProductDTOs = productService.findAll().stream()
                .map(converter::entityToDTO)
                .collect(Collectors.toList());

        model.addAttribute("productDTOList", allProductDTOs);
        return "product/productList";
    }

}
