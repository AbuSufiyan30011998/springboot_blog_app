package com.ashokit.exceptions;

public class ResourceNotFoundException extends RuntimeException{


    String resouceName;
    String fieldName;
    Long fieldValue;

    public ResourceNotFoundException(String resouceName, String fieldName, Long fieldValue) {
        super(String.format(" %s not found with this %s : %s ",resouceName,fieldName,fieldValue));
        this.resouceName = resouceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
