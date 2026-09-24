package br.com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.sistema.api.model.medico.DadosAtualizacaoMedico;
import br.com.sistema.api.model.medico.DadosCadastroMedico;
import br.com.sistema.api.model.medico.Medico;
import br.com.sistema.api.model.medico.MedicoRepository;
import jakarta.transaction.Transactional;



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

    @GetMapping("/listar-todos") 
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    };

    @DeleteMapping("/deletar/{id}")
    @Transactional 
    public void excluir(@PathVariable Integer id){
        medicoRepository.deleteById(id);
    } 

    @DeleteMapping("/alterar-status/{id}")
    @Transactional 
    public void alterarStatus(@PathVariable Integer id){
        var medico = medicoRepository.getReferenceById(id);
        medico.excluirLogico();
    } 
    
    @PutMapping("/atualizar")
    @Transactional 
    public void atualizar(@RequestBody DadosAtualizacaoMedico dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    
}
