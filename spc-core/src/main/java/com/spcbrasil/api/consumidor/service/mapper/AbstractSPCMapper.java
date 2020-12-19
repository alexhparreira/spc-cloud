package com.spcbrasil.api.consumidor.service.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSPCMapper<T,D> implements SPCMapper<PersistBean,GenericDTO> {


    @Override
    public PersistBean mapToEntity(GenericDTO source, PersistBean target) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        target =  modelMapper.map(source, target.getClass());
        return target;
    }

    @Override
    public GenericDTO mapToDTO(PersistBean source, GenericDTO target) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        target =  modelMapper.map(source, target.getClass());
        return target;
    }

    @Override
    public List<PersistBean> mapToEntityList(List<GenericDTO> sourceList, PersistBean target) {

        /*
        List<TaskDto> taskDtos = tasks.stream().map(task -> modelMapper.map(task, TaskDto.class)).collect(Collectors.toList());
         */
        List<PersistBean> response = new ArrayList<>();

        sourceList.forEach(dto -> {
            PersistBean entity = mapToEntity(dto, new PersistBean());
            response.add(entity);
        });

        return response;
    }

    @Override
    public List<GenericDTO> mapToDTOList(List<PersistBean> sourceList, GenericDTO target) {

        List<GenericDTO> response = new ArrayList<>();

        sourceList.forEach(entity -> {
            GenericDTO dto = mapToDTO(entity, new GenericDTO());
            response.add(dto);
        });

        return response;

    }

}
