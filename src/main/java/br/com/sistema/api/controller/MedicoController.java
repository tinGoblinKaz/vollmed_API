package br.com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.api.model.medico.DadosCadastroMedico;
import br.com.sistema.api.model.medico.Medico;
import br.com.sistema.api.model.medico.MedicoRepository;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping ("medico")
public class MedicoController {

    @Autowired 
    private MedicoRepository medicoRepository;
    
    @PostMapping("/cadastro")
    @Transactional 
    public void cadastroMedico(@RequestBody DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
        
        return;
    }

    @GetMapping("/") 
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    };


    
}
