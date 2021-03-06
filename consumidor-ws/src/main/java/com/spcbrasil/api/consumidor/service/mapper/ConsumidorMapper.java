package com.spcbrasil.api.consumidor.service.mapper;


import com.spcbrasil.api.data.model.Consumidor;
import com.spcbrasil.api.shared.ConsumidorDTO;
import com.spcbrasil.api.shared.InfoPagamentoDTO;
import com.spcbrasil.api.shared.PagamentoDTO;
import com.spcbrasil.api.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumidorMapper {

    public static final String DATE_FORMAT_PT_BR = "dd/MM/yyyy";


    public ConsumidorDTO entityToDTO(Consumidor consumidor, InfoPagamentoDTO infoPagamentoDTO, ConsumidorDTO consumidorDTO){

        consumidorDTO.setCpf(consumidor.getCpf());
        consumidorDTO.setDataNascimento(StringUtil.dateToString(consumidor.getDataNascimento(),"dd/MM/yyyy"));
        consumidorDTO.setEmail(consumidor.getEmail());
        consumidorDTO.setNome(consumidor.getNome());

        List<PagamentoDTO> pgtos = null;

        if(infoPagamentoDTO!=null){
            pgtos = infoPagamentoDTO.getPagamentos();
        }

        consumidorDTO.setPagamentos(pgtos);

        return consumidorDTO;
    }

}
