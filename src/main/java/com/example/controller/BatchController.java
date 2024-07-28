package com.example.controller;

import com.example.entity.Batch;
import com.example.entity.dto.response_entity.BatchesWIthPageInfo;
import com.example.utils.BusinessCodes;
import com.example.entity.dto.response_entity.BusinessException;
import com.example.entity.dto.response_entity.ResponseResult;
import com.example.service.impl.BatchServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 批次表 前端控制器
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */


@Tag(name = "批次表操作接口", description = "Batch")
@RestController
@RequestMapping("/batch")
public class BatchController {
    @Autowired
    BatchServiceImpl batchServiceImpl;

    @Operation(summary = "获取指定批次信息")
    @GetMapping("/{batchId}")
    public ResponseResult<Batch> getById(@PathVariable String batchId) throws BusinessException {
        Batch batch = batchServiceImpl.getById(batchId);
        if (batch == null) throw new BusinessException(BusinessCodes.Get_Batch_Failed);
        return ResponseResult.success(batch);
    }

    @Operation(summary = "创建新批次")
    @PostMapping
    public ResponseResult<Batch> add(@RequestBody Batch batch) throws BusinessException {
        if (batch == null) throw new BusinessException(BusinessCodes.Create_New_Batch_Failed);
        batchServiceImpl.save(batch);
        return ResponseResult.success(batch);
    }

    @Operation(summary = "分页模糊搜索批次列表",description = "如果keyword为no_search则不进行搜索，如果pageNum为-1则不进行分页")
    @GetMapping("/search/{keyword}/{pageNum}")
    public ResponseResult<BatchesWIthPageInfo> search(@PathVariable String keyword,@PathVariable int pageNum) throws BusinessException {
        return ResponseResult.success(batchServiceImpl.getBatches(keyword,pageNum));
    }
}
