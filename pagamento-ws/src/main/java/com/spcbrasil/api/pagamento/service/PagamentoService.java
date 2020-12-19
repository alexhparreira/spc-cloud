package com.spcbrasil.api.pagamento.service;

import com.spcbrasil.api.shared.PagamentoDTO;

import java.util.List;

public interface PagamentoService {
    List<PagamentoDTO> findByConsumidorId(String id);
}
