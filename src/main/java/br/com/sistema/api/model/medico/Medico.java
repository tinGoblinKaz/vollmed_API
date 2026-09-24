package br.com.sistema.api.model.medico;

import br.com.sistema.api.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Boolean ativo= true;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    //Método construtor recebendo o DTO DadosCadastroMedico e conectando a um objeto médico
    public Medico(DadosCadastroMedico dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());


    }
    
    public void excluirLogico(){
        this.ativo=false;
    }
    
    public void atualizarInformacoes(DadosAtualizacaoMedico dados){
        if (dados.nome() !=null){
            this.nome = dados.nome();
        }
        if (dados.email() !=null){
            this.email = dados.email();
        }
        if (dados.endereco() !=null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }
}
