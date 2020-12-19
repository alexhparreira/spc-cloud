package com.spcbrasil.api.pagamento.data;

import com.spcbrasil.api.data.model.Pagamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends MongoRepository<Pagamento, String>, QuerydslPredicateExecutor<Pagamento> {
    List<Pagamento> findByConsumidorId(String consumidorId);
}
