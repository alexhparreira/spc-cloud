package com.spcbrasil.api.consumidor.service;

import com.spcbrasil.api.shared.ConsumidorDTO;

public interface ConsumidorService {
    ConsumidorDTO findByCPF(Long id);
}
