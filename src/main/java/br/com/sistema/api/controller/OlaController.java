package br.com.sistema.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("ola")

public class OlaController {

    @GetMapping("/olamundo")
    public String olaMundo() {
        return "Olá Mundo!";
    }
}