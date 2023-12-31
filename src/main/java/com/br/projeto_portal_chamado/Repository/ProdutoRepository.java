package com.br.projeto_portal_chamado.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.projeto_portal_chamado.Model.Produto;

//Repositório de interfaces. Isto é, uma fornecedora de métodos
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
