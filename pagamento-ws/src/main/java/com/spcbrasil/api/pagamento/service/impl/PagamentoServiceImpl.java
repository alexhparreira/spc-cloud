package com.spcbrasil.api.pagamento.service.impl;

import com.spcbrasil.api.data.model.Pagamento;
import com.spcbrasil.api.pagamento.data.PagamentoRepository;
import com.spcbrasil.api.pagamento.service.PagamentoService;
import com.spcbrasil.api.pagamento.service.mapper.PagamentoMapper;
import com.spcbrasil.api.shared.InfoPagamentoDTO;
import com.spcbrasil.api.shared.PagamentoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PagamentoMapper pagamentoMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public InfoPagamentoDTO findByConsumidorId(String id) {

        logger.info("dentro do findByConsumidorId - ID"+id);

        InfoPagamentoDTO response = new InfoPagamentoDTO();

        List<PagamentoDTO> pagamentoDTOS = new ArrayList<>();

        List<Pagamento> pgtos = pagamentoRepository.findByConsumidorId(id);

           pgtos.forEach( pagamento -> {

            PagamentoDTO dto = new PagamentoDTO();
            dto = pagamentoMapper.entityToDTO(pagamento, dto);
            pagamentoDTOS.add(dto);

        });

        logger.info("Retornando os pagamentos");

        response.setPagamentos(pagamentoDTOS);

        return response;
    }

}
