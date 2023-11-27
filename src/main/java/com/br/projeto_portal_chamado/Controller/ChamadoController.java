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

import com.br.projeto_portal_chamado.Model.Chamado;
import com.br.projeto_portal_chamado.Model.Fila;
import com.br.projeto_portal_chamado.Model.Produto;
import com.br.projeto_portal_chamado.Model.Usuario;
import com.br.projeto_portal_chamado.Repository.ChamadoRepository;
import com.br.projeto_portal_chamado.Repository.FilaRepository;
import com.br.projeto_portal_chamado.Repository.ProdutoRepository;
import com.br.projeto_portal_chamado.Repository.UsuarioRepository;

//Mapeado como Controller. Controla as requisições
@Controller
public class ChamadoController {

    // Autowired = Injeção de dependências

    @Autowired
    ChamadoRepository chamadoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    FilaRepository filaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    // Cadastrar
    @GetMapping("/homeChamado")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("homeChamado");
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
        mv.addObject("usuarios", usuarios);

        ArrayList<Fila> filas = new ArrayList<>();
        filas = (ArrayList<Fila>) filaRepository.findAll();
        mv.addObject("filas", filas);

        ArrayList<Produto> produtos = new ArrayList<>();
        produtos = (ArrayList<Produto>) produtoRepository.findAll();
        mv.addObject("produtos", produtos);

        return mv;
    }

    // Cadastrar. Salvar
    // @PostMapping: Determina que o método aceitará requisições HTTP do tipo POST.
    @PostMapping("/homeChamado")
    public String salvar(Chamado chamado, @RequestParam("usu") List<Long> usuarioId,
            @RequestParam("fila") List<Long> filaId, @RequestParam("prod") List<Long> produtoId) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for (Long id : usuarioId) {
            usuarios.add(usuarioRepository.findById(id).get());

        }

        ArrayList<Fila> filas = new ArrayList<>();
        for (Long id : filaId) {
            filas.add(filaRepository.findById(id).get());

        }

        ArrayList<Produto> produtos = new ArrayList<>();
        for (Long id : produtoId) {
            produtos.add(produtoRepository.findById(id).get());
        }

        chamadoRepository.save(chamado);
        return "redirect:/listChamado";
    }

    // Exibir Cadastro
    @GetMapping("/listChamado")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("listChamado");
        ArrayList<Chamado> chamados = new ArrayList<>();
        chamados = (ArrayList<Chamado>) chamadoRepository.findAll();
        mv.addObject("chamados", chamados);
        return mv;
    }

    // Mudança de Status
    @GetMapping("/resolvido/{id}")
    public String resolvido(@PathVariable("id") Long id) {
        Chamado chamado = chamadoRepository.findById(id).get();
        chamado.setStatus(true);
        chamadoRepository.save(chamado);
        return "redirect:/listChamado";
    }

    @GetMapping("/pendente/{id}")
    public String naoResolvido(@PathVariable("id") Long id) {
        Chamado chamado = chamadoRepository.findById(id).get();
        chamado.setStatus(false);
        chamadoRepository.save(chamado);
        return "redirect:/listChamado";
    }
    ///////////////////////////////////////////////////////////////////

    @GetMapping("/excluirChamado/{id}")
    public String excluir(@PathVariable("id") Long id) {
        chamadoRepository.deleteById(id);
        return "redirect:/listChamado";

    }

    // Detecta id do chamado e direciona para página histórico
    @GetMapping("/historico/{id}")

    public ModelAndView historico(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("Historico");
        Chamado ch = new Chamado();
        ch = chamadoRepository.findById(id).get();
        mv.addObject("chamado", ch);
        return mv;

    }

    // Salva e redireciona para listagem de chamados. Status muda para resolvido.
    @PostMapping("/Historico")
    public String verificar(Chamado chamado) {
        Chamado ch = new Chamado();
        ch = chamadoRepository.findById(chamado.getId()).get();
        ch.setStatus(true);
        ch.setHistorico(chamado.getHistorico());
        chamadoRepository.save(ch);
        return "redirect:/listChamado";

    }
}
