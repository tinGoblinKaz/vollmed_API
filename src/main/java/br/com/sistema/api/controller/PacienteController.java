package br.com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import br.com.sistema.api.model.paciente.DadosAtualizacaoPaciente;
import br.com.sistema.api.model.paciente.DadosCadastroPaciente;
import br.com.sistema.api.model.paciente.Paciente;
import br.com.sistema.api.model.paciente.PacienteRepository;
import jakarta.transaction.Transactional;



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
    @GetMapping("/listar-todos") // Aponta para localhost:8080/paciente
    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    };

     @DeleteMapping("/deletar/{id}")
    @Transactional 
    public void excluir(@PathVariable Integer id){
        pacienteRepository.deleteById(id);
    } 

    @DeleteMapping("/alterar-status/{id}")
    @Transactional 
    public void alterarStatus(@PathVariable Integer id){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluirLogico();
    }

    @PutMapping("/atualizar")
    @Transactional 
    public void atualizar(@RequestBody DadosAtualizacaoPaciente dados){
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }



}
