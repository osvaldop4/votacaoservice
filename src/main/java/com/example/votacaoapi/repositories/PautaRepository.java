package com.example.votacaoapi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.votacaoapi.entidade.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta,Integer> {

}
