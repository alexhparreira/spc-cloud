package com.spcbrasil.api.pagamento.service.mapper;


import com.spcbrasil.api.data.model.Pagamento;
import com.spcbrasil.api.shared.PagamentoDTO;
import com.spcbrasil.api.util.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class PagamentoMapper {

    public static final String DATE_FORMAT_PT_BR = "dd/MM/yyyy";


    public PagamentoDTO entityToDTO(Pagamento p, PagamentoDTO dto){

            dto.setConsumidorId(p.getConsumidorId());
            dto.setDataPgto(StringUtil.dateToString(p.getDataPgto(), DATE_FORMAT_PT_BR));
            dto.setEmpresaId(p.getEmpresaId());
            dto.setEmpresaNome(p.getEmpresaNome());
            dto.setDataVencimento(StringUtil.dateToString(p.getDataVencimento(), DATE_FORMAT_PT_BR));
            dto.setStatus(p.getStatus());
            dto.setValor(p.getValor());

             return dto;
    }

}
