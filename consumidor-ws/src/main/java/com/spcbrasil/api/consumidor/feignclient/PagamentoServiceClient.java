package com.spcbrasil.api.consumidor.feignclient;

import com.spcbrasil.api.shared.PagamentoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@FeignClient(name = "pagamento-ws")
@Qualifier("pagamentoServiceClient")
public interface PagamentoServiceClient {

    @RequestMapping("/consumidor/{id}")
    public List<PagamentoDTO> getById(@PathVariable String id);

}
