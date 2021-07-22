package org.example.ishop.controllers;

import org.example.ishop.dto.ConstructorDTO;
import org.example.ishop.dto.ResultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/temp")
public class TempController {

    @GetMapping
    public String getTemp(Model model) {
        model.addAttribute("resultDTO", new ResultDTO());
        return "temp";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("resultDTO") ResultDTO resultDTO) {
        return "temp";
    }
}
