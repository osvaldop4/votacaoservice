package com.example.votacaoapi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.votacaoapi.entidade.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao,Integer> {

}
