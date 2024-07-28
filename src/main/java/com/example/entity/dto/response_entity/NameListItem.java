package com.example.entity.dto.response_entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NameListItem {
    private String personnelName;
    private String personnelId;
    private String duty;
}
