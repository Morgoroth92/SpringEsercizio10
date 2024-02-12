package com.example.SpringEsercizio10.controllers;

import com.example.SpringEsercizio10.entities.ProgrammingLenguage;
import com.example.SpringEsercizio10.repositories.ProgrammingLenguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/v1")
public class ProgrammingLenguageController {

    @Autowired
    ProgrammingLenguageRepository programmingLenguageRepository;

    @GetMapping(path = "/read")
    public Page<ProgrammingLenguage> readPage(
            @RequestParam(required = true) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> size) {
        if (page.isPresent() && size.isPresent()) {
            PageRequest pageable = PageRequest.of(page.get(), size.get());
            Page<ProgrammingLenguage> languagePage = programmingLenguageRepository.findAll(pageable);
            return languagePage;
        } else {
            Page<ProgrammingLenguage> programmingLanguagePage = Page.empty();
            return programmingLanguagePage;
        }
    }

    @PostMapping(path = "/create")
    public ProgrammingLenguage create(@RequestBody ProgrammingLenguage programmingLanguage) {
        return programmingLenguageRepository.saveAndFlush(programmingLanguage);
    }

    @PatchMapping(path = "/patch/{id}")
    public ProgrammingLenguage patch(@PathVariable Long id, @RequestBody ProgrammingLenguage programmingLanguage) {
        return programmingLenguageRepository.saveAndFlush(programmingLanguage);
    }

}
