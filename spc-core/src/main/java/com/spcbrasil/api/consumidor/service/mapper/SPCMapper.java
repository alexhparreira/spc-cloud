package com.spcbrasil.api.consumidor.service.mapper;

import java.io.Serializable;
import java.util.List;

public interface SPCMapper<T extends Serializable, D extends Object> {

    //user =  modelMapper.map(userDetails, Usuario.class);
   T mapToEntity(D source,T target);

   D mapToDTO(T source,D target);

   List<T> mapToEntityList(List<D> source, T target);

   List<D> mapToDTOList(List<T> source,D target);

}
