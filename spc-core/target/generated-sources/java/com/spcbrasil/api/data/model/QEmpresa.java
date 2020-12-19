package com.spcbrasil.api.data.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmpresa is a Querydsl query type for Empresa
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmpresa extends EntityPathBase<Empresa> {

    private static final long serialVersionUID = -2008121980L;

    public static final QEmpresa empresa = new QEmpresa("empresa");

    public final NumberPath<Long> cnpj = createNumber("cnpj", Long.class);

    public final StringPath email = createString("email");

    public final StringPath id = createString("id");

    public final StringPath nome = createString("nome");

    public QEmpresa(String variable) {
        super(Empresa.class, forVariable(variable));
    }

    public QEmpresa(Path<? extends Empresa> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmpresa(PathMetadata metadata) {
        super(Empresa.class, metadata);
    }

}

