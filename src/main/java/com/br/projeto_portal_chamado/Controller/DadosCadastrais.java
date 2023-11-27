package com.br.projeto_portal_chamado.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//Mapeado como Controller. Controla as requisições
@Controller
public class DadosCadastrais {

    // Vai para a tela de Dados Cadastrais
    @GetMapping("/dadosCadastrais")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("dadosCadastrais");
        return mv;
    }

}
