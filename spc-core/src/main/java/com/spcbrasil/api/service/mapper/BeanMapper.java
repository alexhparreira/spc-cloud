package com.spcbrasil.api.service.mapper;

import java.io.Serializable;

public interface BeanMapper<E extends Serializable, D extends Object> {

    E mapDtoToEntity(D source, E target);

    D mapEntityToDTO(E source, D target);
}
