package com.br.projeto_portal_chamado.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.projeto_portal_chamado.Model.Fila;
import com.br.projeto_portal_chamado.Repository.FilaRepository;

//Mapeado como Controller. Controla as requisições
@Controller
public class FilaController {

    // Autowired = Injeção de dependências

    @Autowired
    FilaRepository filaRepository;

    // Cadastrar
    @GetMapping("/homeFila")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("homeFila");
        ArrayList<Fila> filas = new ArrayList<>();
        filas = (ArrayList<Fila>) filaRepository.findAll();
        mv.addObject("filas", filas);

        return mv;
    }

    // Cadastrar. Salvar
    // @PostMapping: Determina que o método aceitará requisições HTTP do tipo POST.
    @PostMapping("/homeFila")
    public String salvar(Fila fila) {
        filaRepository.save(fila);
        return "redirect:/listFila";
    }

    // Exibir Cadastro
    @GetMapping("/listFila")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("listFila");
        ArrayList<Fila> filas = new ArrayList<>();
        filas = (ArrayList<Fila>) filaRepository.findAll();
        mv.addObject("filas", filas);
        return mv;
    }

    @GetMapping("/excluirFila/{id}")
    public String excluir(@PathVariable("id") Long id) {
        filaRepository.deleteById(id);
        return "redirect:/listFila";

    }
}
