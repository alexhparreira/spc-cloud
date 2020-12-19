package com.spcbrasil.api.shared;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ConsumidorDTO implements Serializable {

	private static final long serialVersionUID = -953297098295050686L;

	private String id;
	private String nome;
	private String email;
	private String dataNascimento;
	private Long cpf;
	private List<PagamentoDTO> pagamentos;

}
