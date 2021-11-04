package io.javamasters.employeescrud.transformers;

import java.util.ArrayList;
import java.util.List;

public interface IGenericTransformer<ENTITY, DTO> {

    public ENTITY fromDTO(DTO dto);

    public DTO toDTO(ENTITY entity);

    default List<DTO> toListDTO(List<ENTITY> entities) {
        List<DTO> dtos = new ArrayList<>();
        entities.stream().forEach(entity -> {
            dtos.add(toDTO(entity));
        });
        return dtos;
    }

}
