package com.br.projeto_portal_chamado.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.br.projeto_portal_chamado.Model.Tipo;
import com.br.projeto_portal_chamado.Model.Usuario;
import com.br.projeto_portal_chamado.Repository.ChamadoRepository;
import com.br.projeto_portal_chamado.Repository.TipoRepository;
import com.br.projeto_portal_chamado.Repository.UsuarioRepository;

//Mapeado como Controller. Controla as requisições
@Controller
public class UsuarioController {

    // Autowired = Injeção de dependências

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ChamadoRepository chamadoRepository;

    @Autowired
    TipoRepository tipoRepository;

    // Cadastrar
    @GetMapping("/homeUsuario")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("homeUsuario");
        ArrayList<Tipo> tipos = new ArrayList<>();
        tipos = (ArrayList<Tipo>) tipoRepository.findAll();
        mv.addObject("tipos", tipos);

        return mv;
    }

    // Cadastrar. Salvar
    // @PostMapping: Determina que o método aceitará requisições HTTP do tipo POST.
    @PostMapping("/homeUsuario")
    public String salvar(Usuario usuario, @RequestParam("tipo") List<Long> tipoId) {
        ArrayList<Tipo> tipos = new ArrayList<>();
        for (Long id : tipoId) {
            tipos.add(tipoRepository.findById(id).get());
        }
        usuario.setTipos(tipos);
        usuarioRepository.save(usuario);

        return "redirect:/listUsuario";
    }

    // Exibir Cadastro
    @GetMapping("/listUsuario")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("listUsuario");
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
        mv.addObject("usuarios", usuarios);
        return mv;
    }

    // Cadastrar
    @GetMapping("/homeLogin")
    public String loginUsuario() {
        return "homeLogin";
    }

    // Salvar
    @PostMapping("/verificaLoginUsuario")
    public String verificar(Usuario usuario) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
        for (Usuario usuario1 : usuarios) {
            if (usuario1.getCpf().equalsIgnoreCase(usuario.getCpf())
                    && usuario1.getSenha().equalsIgnoreCase(usuario.getSenha())) {
                return "redirect:/homeTelaInicial";
            }
        }
        return "redirect:/homeLogin";
    }

    @GetMapping("/excluirUsuario/{id}")
    public String excluir(@PathVariable("id") Long id) {
        usuarioRepository.deleteById(id);
        return "redirect:/listUsuario";

    }
}
