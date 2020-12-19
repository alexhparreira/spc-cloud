package com.spcbrasil.api.shared;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class PagamentoDTO implements Serializable {

	private static final long serialVersionUID = -953297098295050686L;

	private String id;

	private String empresaId;

	private String consumidorId;

	private String empresaNome;

	private String dataVencimento;

	private String dataPgto;

	private Boolean status;

	private Double valor;



	
	
}
