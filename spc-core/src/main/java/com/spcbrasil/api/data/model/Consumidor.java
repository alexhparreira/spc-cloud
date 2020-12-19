package com.spcbrasil.api.data.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

@Document(collection = "consumidores")
@Data
public class Consumidor implements Serializable {

    private static final long serialVersionUID = 4320748870214037443L;

    @Id
    private String id;

    @TextIndexed
    private String nome;

    private String email;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dataNascimento;

    @Indexed(unique=true)
    private Long cpf;


}
