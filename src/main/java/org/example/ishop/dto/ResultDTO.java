package org.example.ishop.dto;

import java.util.List;

public class ResultDTO {

    List<ConstructorDTO> constructorDTOList;

    public ResultDTO() {
    }

    public ResultDTO(List<ConstructorDTO> constructorDTOList) {
        this.constructorDTOList = constructorDTOList;
    }

    public List<ConstructorDTO> getConstructorDTOList() {
        return constructorDTOList;
    }

    public void setConstructorDTOList(List<ConstructorDTO> constructorDTOList) {
        this.constructorDTOList = constructorDTOList;
    }
}
