package org.example.ishop.dto;

public class ConstructorDTO {

    private String clazz;
    private String info;

    public ConstructorDTO() {
    }


    public ConstructorDTO(String clazz, String info) {
        this.clazz = clazz;
        this.info = info;
    }


    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
