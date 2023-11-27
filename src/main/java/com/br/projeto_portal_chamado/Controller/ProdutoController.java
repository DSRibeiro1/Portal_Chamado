package com.br.projeto_portal_chamado.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.projeto_portal_chamado.Model.Produto;
import com.br.projeto_portal_chamado.Repository.ProdutoRepository;

//Mapeado como Controller. Controla as requisições
@Controller
public class ProdutoController {

    // Autowired = Injeção de dependências

    @Autowired
    ProdutoRepository produtoRepository;

    // Cadastrar
    @GetMapping("/homeProduto")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("homeProduto");
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos = (ArrayList<Produto>) produtoRepository.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }

    // Cadastrar. Salvar
    // @PostMapping: Determina que o método aceitará requisições HTTP do tipo POST.
    @PostMapping("/homeProduto")
    public String salvar(Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/listProduto";

    }

    // Exibir Cadastro
    @GetMapping("/listProduto")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("listProduto");
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos = (ArrayList<Produto>) produtoRepository.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }

    @GetMapping("/excluirProduto/{id}")
    public String excluir(@PathVariable("id") Long id) {
        produtoRepository.deleteById(id);
        return "redirect:/listProduto";

    }
}
