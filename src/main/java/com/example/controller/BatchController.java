package com.example.controller;

import com.example.entity.Batch;
import com.example.entity.response_entity.BusinessCodes;
import com.example.entity.response_entity.BusinessException;
import com.example.entity.response_entity.ResponseResult;
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



@Tag(name = "批次表操作接口" ,description = "Batch")
@RestController
@RequestMapping("/batch")
public class BatchController {
    @Autowired
    BatchServiceImpl batchServiceImpl;

    @Operation(summary = "获取全部批次")
    @GetMapping("all")
    public ResponseResult<List<Batch>> getAll() throws BusinessException {
        List<Batch> responseData =batchServiceImpl.list() ;
        if(responseData == null || responseData.isEmpty()) throw new BusinessException(BusinessCodes.Get_All_Batch_Failed);
        return ResponseResult.success(responseData);
    }

    @Operation(summary = "创建新批次")
    @PostMapping
    public ResponseResult<Batch> add(@RequestBody Batch batch) throws BusinessException {
        if(batch == null) throw new BusinessException(BusinessCodes.Create_New_Batch_Failed);
        batchServiceImpl.save(batch);
        return ResponseResult.success(batch);
    }
}
