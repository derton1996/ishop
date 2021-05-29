package org.example.ishop.controllers;

import org.example.ishop.dto.SaleDTO;
import org.example.ishop.dto.converters.SaleConverter;
import org.example.ishop.services.sale.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/sale")
public class SaleController {

    private final SaleService saleService;
    private final SaleConverter converter;

    @Autowired
    public SaleController(SaleService saleService, SaleConverter converter) {
        this.saleService = saleService;
        this.converter = converter;
    }

    @GetMapping
    public String getAllSales(Model model) {
        List<SaleDTO> saleDTOs = saleService.findAll().stream()
                .map(converter::entityToDTO)
                .collect(Collectors.toList());
        model.addAttribute(saleDTOs);
        return "sale/all";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") String id, Model model) {
        model.addAttribute("saleDTO", converter.entityToDTO(saleService.findById(id)));
        return "sale/one";
    }

    @GetMapping("/new")
    public String newSale(Model model) {
        model.addAttribute("saleDTO", new SaleDTO());
        return "sale/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("saleDTO") SaleDTO saleDTO, @RequestParam("file") MultipartFile image) {
        saleService.save(converter.dtoToEntity(saleDTO), image);
        return "redirect:/sale";
    }

    @PostMapping("/upload")
    public String createImage(@RequestParam("file") MultipartFile image) {

        try {
            byte[] design = image.getBytes();
            Base64.getEncoder().encodeToString(design);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/sale";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        model.addAttribute("saleDTO", converter.entityToDTO(saleService.findById(id)));
        return "sale/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("saleDTO") SaleDTO saleDTO, @RequestParam("file") MultipartFile image) {
        saleService.update(converter.dtoToEntity(saleDTO), image);
        return "redirect:/sale";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String id) {
        saleService.deleteById(id);
        return "redirect:/sale";
    }

}
