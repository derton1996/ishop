package org.example.ishop.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ishop.dto.ConstructorDTO;
import org.example.ishop.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/temp")
public class TempController {


    @GetMapping
    public String getTemp(Model model) {
        ArrayList<ConstructorDTO> list = new ArrayList<>();
        model.addAttribute("resultDTO", list);
        return "temp";
    }

    @PostMapping("/create")
    public String create(@RequestBody String json) {
        return "temp";
    }
}
