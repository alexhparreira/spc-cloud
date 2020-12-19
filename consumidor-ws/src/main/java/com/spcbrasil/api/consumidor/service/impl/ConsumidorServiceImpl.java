package com.spcbrasil.api.consumidor.service.impl;


import com.spcbrasil.api.consumidor.data.ConsumidorRepository;
import com.spcbrasil.api.consumidor.service.mapper.ConsumidorMapper;
import com.spcbrasil.api.data.model.Consumidor;
import com.spcbrasil.api.consumidor.service.ConsumidorService;
import com.spcbrasil.api.shared.ConsumidorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumidorServiceImpl implements ConsumidorService {

    @Autowired
    private ConsumidorRepository consumidorRepository;

    @Autowired
    private ConsumidorMapper consumidorMapper;

    @Override
    public ConsumidorDTO findByCPF(Long cpf) {

        Consumidor consumidor = consumidorRepository.findByCpf(cpf);

        ConsumidorDTO consumidorDTO = new ConsumidorDTO();

        consumidorMapper.entityToDTO(consumidor,null,consumidorDTO);

        return consumidorDTO;
    }
}
