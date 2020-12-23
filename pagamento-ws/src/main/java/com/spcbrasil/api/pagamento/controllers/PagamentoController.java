package com.spcbrasil.api.pagamento.controllers;

import com.spcbrasil.api.pagamento.service.PagamentoService;
import com.spcbrasil.api.shared.InfoPagamentoDTO;
import com.spcbrasil.api.shared.PagamentoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("pgto")
@EnableCircuitBreaker
public class PagamentoController {

	@Autowired
	private Environment env;

	@Autowired
	private PagamentoService pagamentoService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@GetMapping(value = "/consumidor/{id}",  produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<InfoPagamentoDTO> getById(@PathVariable String id) {

		logger.info("dentro do Micro Serviço de Pagamentos");

		InfoPagamentoDTO response = pagamentoService.findByConsumidorId(id);

		logger.info("Saindo do Microserviço");

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}





}
