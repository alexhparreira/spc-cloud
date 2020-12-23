package com.spcbrasil.api.consumidor.service;

import com.spcbrasil.api.shared.ConsumidorDTO;
import com.spcbrasil.api.shared.InfoPagamentoDTO;

public interface ConsumidorService {

    ConsumidorDTO findByCPF(Long cpf);

    InfoPagamentoDTO getPagamentos(String consumidorId);



}
