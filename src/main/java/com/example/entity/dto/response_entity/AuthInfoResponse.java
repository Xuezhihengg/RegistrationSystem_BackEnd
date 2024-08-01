package com.example.entity.dto.response_entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthInfoResponse {
    private String personnelId;
    private String position;
}
