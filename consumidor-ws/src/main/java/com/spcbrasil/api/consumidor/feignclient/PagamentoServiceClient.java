package com.spcbrasil.api.consumidor.feignclient;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import com.spcbrasil.api.shared.InfoPagamentoDTO;
import com.spcbrasil.api.shared.PagamentoDTO;
import com.spcbrasil.api.util.StringUtil;
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
import java.util.ArrayList;
import java.util.List;



@FeignClient(name = "pagamento-ws", fallbackFactory = PgtoFallbackFactory.class)
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

        } else if(cause instanceof HystrixTimeoutException){

            logger.error("Timeout Circuit Breaker");

            // nesse caso pode pegar a informação do cache ou mesmo de uma tabela local

            return getLocalData(id);
        }
        else{
            logger.error("Outro erro aconteceu ao chamar com o consumidor Id: "+id+" Mensagem de Erro: "+cause.getLocalizedMessage());
        }

        return new InfoPagamentoDTO();
    }

    private InfoPagamentoDTO getLocalData(String id) {

        InfoPagamentoDTO infoPagamentoDTO = new InfoPagamentoDTO();

        List<PagamentoDTO> pgtos = new ArrayList<>();
        PagamentoDTO pgto1 = new PagamentoDTO();

        pgto1.setConsumidorId(id);
        pgto1.setDataVencimento("22/12/2020");
        pgto1.setEmpresaNome("Casas Bahia");
        pgto1.setStatus(false);
        pgto1.setEmpresaId("456789567890");
        pgto1.setValor(200.0);

        pgtos.add(pgto1);
        infoPagamentoDTO.setPagamentos(pgtos);

        return infoPagamentoDTO;
    }
}