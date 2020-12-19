package com.spcbrasil.api.data.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConsumidor is a Querydsl query type for Consumidor
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConsumidor extends EntityPathBase<Consumidor> {

    private static final long serialVersionUID = -434608532L;

    public static final QConsumidor consumidor = new QConsumidor("consumidor");

    public final NumberPath<Long> cpf = createNumber("cpf", Long.class);

    public final DateTimePath<java.util.Date> dataNascimento = createDateTime("dataNascimento", java.util.Date.class);

    public final StringPath email = createString("email");

    public final StringPath id = createString("id");

    public final StringPath nome = createString("nome");

    public QConsumidor(String variable) {
        super(Consumidor.class, forVariable(variable));
    }

    public QConsumidor(Path<? extends Consumidor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConsumidor(PathMetadata metadata) {
        super(Consumidor.class, metadata);
    }

}

