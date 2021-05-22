package org.example.ishop.dto.converters;

import org.example.ishop.dto.BaseDTO;
import org.example.ishop.entities.BaseEntity;

public interface Converter<E extends BaseEntity, DTO extends BaseDTO> {

    E dtoToEntity(DTO dto);

    DTO entityToDTO(E e);

}
