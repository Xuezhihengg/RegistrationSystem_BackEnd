package com.example.entity.dto.response_entity;


import com.example.utils.BusinessCodes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException {
    private String code;
    public BusinessException(BusinessCodes code) {
        super(code.getMessage());
        this.code = code.getCode();
    }

}
