package com.spcbrasil.api.consumidor.controllers;

import com.spcbrasil.api.consumidor.service.ConsumidorService;
import com.spcbrasil.api.shared.ConsumidorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("consumidor")
public class ConsumidorController {

	@Autowired
	private Environment env;

	@Autowired
	private ConsumidorService consumidorService;


	@GetMapping(value = "/cpf/{cpf}",  produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ConsumidorDTO> getById(@RequestHeader("Authorization") String token, @PathVariable String cpf) {

		ConsumidorDTO response = consumidorService.findByCPF( Long.parseLong(cpf) );
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}



}
