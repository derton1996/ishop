package org.example.ishop.controllers.strand;

import org.example.ishop.dto.FilterStrandDTO;
import org.example.ishop.entities.StrandElectro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.example.ishop.services.product.ElectroStrandService;

@Controller
@RequestMapping("/strand/electro")
public class StrandElectroController {

    private static final String PREFIX = "strand/electro";

    private final ElectroStrandService electroStrandService;

    @Autowired
    public StrandElectroController(ElectroStrandService electroStrandService) {
        this.electroStrandService = electroStrandService;
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("strandElectro", new StrandElectro());
        return "strand/electro/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("strandElectro") StrandElectro strandElectro, @RequestParam("file") MultipartFile image) {
        electroStrandService.save(strandElectro, image);
        return "redirect:/strand/electro";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") String id, Model model) {
        model.addAttribute("strandElectro", electroStrandService.findById(id));
        return "strand/electro/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("strandElectro") StrandElectro strandElectro, @RequestParam("file") MultipartFile image) {
        electroStrandService.update(strandElectro, image);
        return "redirect:/strand/electro";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        electroStrandService.deleteById(id);
        return "redirect:/strand/electro";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") String id, Model model) {
        model.addAttribute("strandElectro", electroStrandService.findById(id));
        return "strand/electro/one";
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("strandElectroList", electroStrandService.findAll());
        model.addAttribute("filter", new FilterStrandDTO());
        return "strand/electro/all";
    }

    @GetMapping("/filter")
    String filter(Model model, @ModelAttribute("filter") FilterStrandDTO filter) {
        model.addAttribute("strandElectroList", electroStrandService.filter(filter));
        return "strand/electro/all";
    }

}
