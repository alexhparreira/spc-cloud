package com.spcbrasil.api.consumidor.data;

import com.spcbrasil.api.data.model.Consumidor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumidorRepository extends MongoRepository<Consumidor, String>, QuerydslPredicateExecutor<Consumidor> {


    Consumidor findByCpf(Long cpf);
}
