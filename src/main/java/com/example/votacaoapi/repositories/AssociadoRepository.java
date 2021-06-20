package com.example.votacaoapi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.votacaoapi.entidade.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado,Integer> {

}
