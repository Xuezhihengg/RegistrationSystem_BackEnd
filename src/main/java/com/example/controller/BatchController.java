package com.example.controller;

import com.example.entity.Batch;
import com.example.entity.dto.response_entity.BatchesWIthPageInfo;
import com.example.service.impl.FileServiceImpl;
import com.example.utils.BusinessCodes;
import com.example.entity.dto.response_entity.BusinessException;
import com.example.entity.dto.response_entity.ResponseResult;
import com.example.service.impl.BatchServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 * 批次表 前端控制器
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */

@Validated
@Tag(name = "批次表操作接口", description = "Batch")
@RestController
@RequestMapping("/batch")
public class BatchController {
    @Autowired
    BatchServiceImpl batchServiceImpl;
    @Autowired
    FileServiceImpl fileServiceImpl;

    @Operation(summary = "获取指定批次信息")
    @GetMapping("/{batchId}")
    public ResponseResult<Batch> getById(@PathVariable @NotEmpty String batchId) throws BusinessException {
        Batch batch = batchServiceImpl.getById(batchId);
        if (batch == null) throw new BusinessException(BusinessCodes.Get_Batch_Failed);
        return ResponseResult.success(batch);
    }

    @Operation(summary = "创建新批次")
    @PostMapping("/new")
    public ResponseResult<Batch> add(@RequestParam("batchId") @NotEmpty String batchId, @RequestParam("batchName") @NotEmpty String batchName, @RequestParam("startDate") @NotEmpty String startDate, @RequestParam("endDate") @NotEmpty String endDate, @RequestParam("description") String description, @RequestParam("attachment") MultipartFile file) throws BusinessException {
        Batch batch = Batch.builder().
                batchId(batchId).
                batchName(batchName).
                startDate(LocalDateTime.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME)).
                endDate(LocalDateTime.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME)).
                description(description).
                build();
        try {
            String newPath = fileServiceImpl.upload(file);
            batch.setAttachment(newPath);
        } catch (IOException e) {
            throw new BusinessException(BusinessCodes.Upload_Attachment_Failed);
        }
        batchServiceImpl.save(batch);
        return ResponseResult.success(batch);
    }

    @Operation(summary = "分页模糊搜索批次列表", description = "如果keyword为no_search则不进行搜索，如果pageNum为-1则不进行分页")
    @GetMapping("/search/{keyword}/{pageNum}")
    public ResponseResult<BatchesWIthPageInfo> search(@PathVariable @NotEmpty String keyword, @PathVariable @NotNull int pageNum) throws BusinessException {
        return ResponseResult.success(batchServiceImpl.getBatches(keyword, pageNum));
    }
}
