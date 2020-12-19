package com.spcbrasil.api.data.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "pagamentos")
@Data
public class Empresa implements Serializable {

    private static final long serialVersionUID = 4320748870214037443L;

    @Id
    private String id;

    private String nome;

    private String email;

    private Long cnpj;


}
