package com.spcbrasil.api.consumidor.feignclient;

import com.spcbrasil.api.shared.InfoPagamentoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "pagamento-ws")
public interface PagamentoServiceClient {

    @RequestMapping("/pgto/consumidor/{id}")
    InfoPagamentoDTO getById(@PathVariable String id);

}