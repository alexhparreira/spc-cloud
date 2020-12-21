package com.spcbrasil.api.pagamento.controllers;

import com.spcbrasil.api.pagamento.service.PagamentoService;
import com.spcbrasil.api.shared.InfoPagamentoDTO;
import com.spcbrasil.api.shared.PagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("pgto")
public class PagamentoController {

	@Autowired
	private Environment env;

	@Autowired
	private PagamentoService pagamentoService;


	@GetMapping(value = "/consumidor/{id}",  produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<InfoPagamentoDTO> getById(@PathVariable String id) {


		InfoPagamentoDTO response = pagamentoService.findByConsumidorId(id);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}





}
