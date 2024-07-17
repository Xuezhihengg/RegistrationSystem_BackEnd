package com.example.entity.dto.response_entity;

import com.example.entity.Batch;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BatchesWIthPageInfo {
    private List<Batch> batches;
    private long totalPages;
}
