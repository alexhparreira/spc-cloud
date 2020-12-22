package com.spcbrasil.api.consumidor.feignclient;

import com.spcbrasil.api.shared.InfoPagamentoDTO;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "pagamento-ws",fallbackFactory = PgtoFallbackFactory.class)
@Qualifier("pagamentoServiceClient")
public interface PagamentoServiceClient {

    @RequestMapping("/pgto/consumidor/{id}")
    InfoPagamentoDTO getById(@PathVariable String id);

}

@Component
class PgtoFallbackFactory implements FallbackFactory<PagamentoServiceClient> {


    @Override
    public PagamentoServiceClient create(Throwable cause) {
        return new PagamentoServiceClientFallback(cause);
    }
}

class PagamentoServiceClientFallback implements PagamentoServiceClient{

    private final Throwable cause;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public PagamentoServiceClientFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public InfoPagamentoDTO getById(String id) {

        if(cause instanceof FeignException && ((FeignException)cause).status()== HttpStatus.SC_NOT_FOUND){

            logger.error("Erro 404 ao chamar com o consumidor Id: " + id);

        } else{
            logger.error("Outro erro aconteceu ao chamar com o consumidor Id: "+id+" Mensagem de Erro: "+cause.getLocalizedMessage());
        }

        return new InfoPagamentoDTO();
    }
}