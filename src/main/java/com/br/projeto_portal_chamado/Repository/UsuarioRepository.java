package com.br.projeto_portal_chamado.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.projeto_portal_chamado.Model.Usuario;

//Repositório de interfaces. Isto é, uma fornecedora de métodos
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
