package com.example.votacaoapi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.votacaoapi.entidade.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto,Integer> {

}
