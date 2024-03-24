package com.bottomline.autocomplete.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bottomline.autocomplete.service.NameService;

import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AutoCompleteController {

    private final NameService nameService;

    @Autowired
    public AutoCompleteController(NameService nameService) {
        this.nameService = nameService;
    }
//
    @GetMapping("/autocomplete")
    @ResponseBody
    public List<String> autocomplete(@RequestParam("prefix") String prefix) {
        List<String> autocompleteList =  nameService.autocomplete(prefix);
        if (autocompleteList != null) {
            return autocompleteList;
        } else {
            return Collections.emptyList();
        }
    }

}


