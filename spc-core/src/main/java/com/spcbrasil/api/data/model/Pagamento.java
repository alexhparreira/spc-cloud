package com.spcbrasil.api.data.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

@Document(collection = "pagamentos")
@Data
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 4320748870214037443L;

    @Id
    private String id;

    private String empresaId;

    private String consumidorId;

    private String empresaNome;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dataVencimento;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dataPgto;

    private Boolean status;

    private Double valor;

    private String movimento;



}
