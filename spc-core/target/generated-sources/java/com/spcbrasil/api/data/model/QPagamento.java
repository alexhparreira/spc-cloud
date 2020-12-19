package com.spcbrasil.api.data.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPagamento is a Querydsl query type for Pagamento
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPagamento extends EntityPathBase<Pagamento> {

    private static final long serialVersionUID = 911736161L;

    public static final QPagamento pagamento = new QPagamento("consumidor");

    public final StringPath consumidorId = createString("consumidorId");

    public final DateTimePath<java.util.Date> dataPgto = createDateTime("dataPgto", java.util.Date.class);

    public final DateTimePath<java.util.Date> dataVencimento = createDateTime("dataVencimento", java.util.Date.class);

    public final StringPath empresaId = createString("empresaId");

    public final StringPath empresaNome = createString("empresaNome");

    public final StringPath id = createString("id");

    public final BooleanPath status = createBoolean("status");

    public final NumberPath<Double> valor = createNumber("valor", Double.class);

    public QPagamento(String variable) {
        super(Pagamento.class, forVariable(variable));
    }

    public QPagamento(Path<? extends Pagamento> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPagamento(PathMetadata metadata) {
        super(Pagamento.class, metadata);
    }

}

