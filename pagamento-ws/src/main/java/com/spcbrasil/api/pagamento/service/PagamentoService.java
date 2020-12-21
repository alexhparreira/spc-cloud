package com.spcbrasil.api.pagamento.service;

import com.spcbrasil.api.shared.InfoPagamentoDTO;


public interface PagamentoService {
    InfoPagamentoDTO findByConsumidorId(String id);
}
