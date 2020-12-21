package com.spcbrasil.api.consumidor.service.impl;


import com.spcbrasil.api.consumidor.data.ConsumidorRepository;
import com.spcbrasil.api.consumidor.service.mapper.ConsumidorMapper;
import com.spcbrasil.api.data.model.Consumidor;
import com.spcbrasil.api.consumidor.service.ConsumidorService;
import com.spcbrasil.api.shared.ConsumidorDTO;
import com.spcbrasil.api.shared.InfoPagamentoDTO;
import com.spcbrasil.api.shared.PagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ConsumidorServiceImpl implements ConsumidorService {

    @Autowired
    private ConsumidorRepository consumidorRepository;

    @Autowired
    private ConsumidorMapper consumidorMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ConsumidorDTO findByCPF(Long cpf) {

        Consumidor consumidor = consumidorRepository.findByCpf(cpf);

        ConsumidorDTO consumidorDTO = new ConsumidorDTO();

        InfoPagamentoDTO infoPgto = getPagamentos(consumidor.getId());

        consumidorDTO.setPagamentos(infoPgto.getPagamentos());

        consumidorMapper.entityToDTO(consumidor,null,consumidorDTO);

        return consumidorDTO;
    }

    @Override
    public  InfoPagamentoDTO getPagamentos(String consumidorId){

        ResponseEntity<InfoPagamentoDTO> response = restTemplate.exchange("http://pagamento-ws/",
                HttpMethod.GET,null,InfoPagamentoDTO.class);

        return response.getBody();




    }

}
