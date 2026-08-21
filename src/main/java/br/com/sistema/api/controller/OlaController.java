package br.com.sistema.api.controller;

// Fica no subpacote "controller" — o @ComponentScan vai encontrá-lo

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// Três anotações do Spring MVC: definem o comportamento HTTP da classe

@RestController
// Combina @Controller + @ResponseBody.
// @Controller: registra a classe como um bean que trata requisições HTTP.
// @ResponseBody: serializa automaticamente o retorno do método para JSON/texto
// no corpo da resposta HTTP (sem isso, o Spring tentaria encontrar uma view
// HTML)

@RequestMapping("ola")
// Define o caminho base para TODOS os métodos desta classe.
// A URL completa será: http://localhost:8080/ola
// Pode conter múltiplos níveis: "api/v1/medicos"

public class OlaController {

    @GetMapping
    // Mapeia este método para requisições HTTP GET no caminho base (/ola).
    // Se fosse @GetMapping("teste") seria GET /ola/teste

    public String olaMundo() {
        // O método retorna uma String. Com @RestController, ela é
        // enviada diretamente no corpo da resposta HTTP como texto puro.
        // Se retornasse um objeto Java, o Jackson o converteria para JSON.

        return "Olá Mundo!";
        // Resposta: HTTP 200 OK, body: Olá Mundo!
    }
}