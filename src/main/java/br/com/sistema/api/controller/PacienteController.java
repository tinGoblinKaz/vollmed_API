package br.com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.api.model.paciente.DadosCadastroPaciente;
import br.com.sistema.api.model.paciente.Paciente;
import br.com.sistema.api.model.paciente.PacienteRepository;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired 
    private PacienteRepository pacienteRepository;

    @PostMapping("/cadastro")
    @Transactional 
    public void cadastroPaciente(@RequestBody DadosCadastroPaciente dados) {
        pacienteRepository.save(new Paciente(dados));
        
        return;
    }
    


    // GET Request -> Response -> Ex: Tela Home
    @GetMapping("/") // Aponta para localhost:8080/paciente
    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    };



    // GET/POST Request -> Response -> Ex: Cadastrar Paciente. GET exibe tela de cadastro e POST é chamado quando o botão enviar é clicado. 
    // GET/PUT Request -> Response -> Ex: Alterar telefone. GET exibe a tela de alteração, PUT é chamado quando o botão alterar é clicado. 
    // DELETE
}
