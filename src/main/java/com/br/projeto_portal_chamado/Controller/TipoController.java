package com.br.projeto_portal_chamado.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.projeto_portal_chamado.Model.Tipo;
import com.br.projeto_portal_chamado.Model.Usuario;
import com.br.projeto_portal_chamado.Repository.TipoRepository;
import com.br.projeto_portal_chamado.Repository.UsuarioRepository;

//Mapeado como Controller. Controla as requisições
@Controller
public class TipoController {

    // Autowired = Injeção de dependências

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TipoRepository tipoRepository;

    // Cadastrar
    @GetMapping("/homeTipo")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("homeTipo");
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
        mv.addObject("usuarios", usuarios);

        return mv;
    }

    // Cadastrar. Salvar
    // @PostMapping: Determina que o método aceitará requisições HTTP do tipo POST.
    @PostMapping("/homeTipo")
    public String salvar(Tipo tipo) {

        tipoRepository.save(tipo);
        return "redirect:/listTipo";
    }

    // Exibir Cadastro
    @GetMapping("/listTipo")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("listTipo");
        ArrayList<Tipo> tipos = new ArrayList<>();
        tipos = (ArrayList<Tipo>) tipoRepository.findAll();
        mv.addObject("tipos", tipos);
        return mv;
    }

    @GetMapping("/excluirTipo/{id}")
    public String excluir(@PathVariable("id") Long id) {
        tipoRepository.deleteById(id);
        return "redirect:/listTipo";

    }
}
