package com.pokemon.tradecardgame.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class Converter {
    private static final ModelMapper modelMapper = new ModelMapper();

    static public <D> D convertTo(Object bean, Class<D> dto) {
        return modelMapper.map(bean, dto);
    }

    static public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}