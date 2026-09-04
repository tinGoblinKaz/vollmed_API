package br.com.sistema.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController 
@RequestMapping ("medico")
public class MedicoController {
    
    @GetMapping("/") 
    public String exibirHome() {
        return "a";
    };

    @PostMapping("/cadastro")
    public String cadastroMedico(String dados) {
        
        return dados;
    }
    
    
}
