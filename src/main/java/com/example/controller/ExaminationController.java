package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.Examination;
import com.example.entity.dto.request_entity.NewExamRequest;
import com.example.entity.dto.response_entity.NameListItem;
import com.example.utils.BusinessCodes;
import com.example.entity.dto.response_entity.BusinessException;
import com.example.entity.dto.response_entity.ResponseResult;
import com.example.service.impl.ExaminationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 考试表 前端控制器
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */

@Tag(name = "考试表操作接口", description = "Examination")
@RestController
@RequestMapping("/examination")
public class ExaminationController {
    @Autowired
    ExaminationServiceImpl examinationServiceImpl;

    @Operation(summary = "获取指定批次的全部考试信息")
    @GetMapping("/examList/{batch_id}")
    public ResponseResult<List<Examination>> getExaminationByBatchId(@PathVariable("batch_id") String batchId) throws BusinessException {
        QueryWrapper<Examination> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.eq("batch_id", batchId);
        List<Examination> responseData = examinationServiceImpl.list(sectionQueryWrapper);
        if (responseData == null)
            throw new BusinessException(BusinessCodes.Fetch_Exams_By_BatchId_Failed);

        return ResponseResult.success(responseData);
    }

    @Operation(summary = "获取指定考试的监考名单")
    @GetMapping("nameList/{examId}")
    public ResponseResult<List<NameListItem>> getNameList(@PathVariable("examId") String examId) throws BusinessException {
        return ResponseResult.success(examinationServiceImpl.getNameList(examId));
    }

    @Operation(summary = "创建新考试")
    @PostMapping("/new")
    public ResponseResult<Examination> createExamination(@RequestBody NewExamRequest newExamRequest) throws BusinessException {
        Examination examination = Examination.builder()
                .examId(newExamRequest.getExamId())
                .batchId(newExamRequest.getBatchId())
                .examName(newExamRequest.getExamName())
                .address(newExamRequest.getAddress())
                .campus(newExamRequest.getCampus())
                .startTime(newExamRequest.getStartTime())
                .endTime(newExamRequest.getEndTime())
                .minorInvigilator(null)
                .chiefInvigilator(null)
                .build();
        examinationServiceImpl.save(examination);
        return ResponseResult.success(examination);
    }

    @Operation(summary = "获取指定考试的详细信息")
    @GetMapping("/{examId}")
    public ResponseResult<Examination> getExaminationById(@PathVariable("examId") String examId) throws BusinessException {
        Examination examination = examinationServiceImpl.getById(examId);
        if(examination == null) throw new BusinessException(BusinessCodes.Get_Examination_Failed);
        return ResponseResult.success(examination);
    }
}

