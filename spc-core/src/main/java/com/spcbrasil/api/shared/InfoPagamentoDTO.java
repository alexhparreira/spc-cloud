package com.spcbrasil.api.shared;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class InfoPagamentoDTO implements Serializable {

	private List<PagamentoDTO> pagamentos;

}
