package com.recipes.controller;

import com.recipes.dbfiller.DbFiller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fill")
public class DBFillerController {
    private final DbFiller filler;

    @PostMapping("/all")
    public void fill() {
        filler.fill();
    }
}
