package com.example.controller;

import com.example.entity.Personnel;
import com.example.entity.dto.response_entity.BusinessException;
import com.example.entity.dto.response_entity.ResponseResult;
import com.example.service.impl.FileServiceImpl;
import com.example.service.impl.PersonnelServiceImpl;
import com.example.utils.BusinessCodes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 * 人员表 前端控制器
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */

@Tag(name = "人员表操作接口", description = "Personnel")
@RestController
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    PersonnelServiceImpl personnelServiceImpl;
    @Autowired
    FileServiceImpl fileServiceImpl;

    @Operation(summary = "获取指定人员的详细信息")
    @GetMapping("/{personnelId}")
    public ResponseResult<Personnel> getPersonnel(@PathVariable("personnelId") String personnelId) throws BusinessException {
        Personnel personnel = personnelServiceImpl.getById(personnelId);
        if (personnel == null) throw new BusinessException(BusinessCodes.Get_Personnel_Failed);
        personnel.setPassword("");
        return ResponseResult.success(personnel);
    }

    @Operation(summary = "上传头像")
    @PostMapping("/upload/avatar")
    public ResponseResult<String> uploadAvatar(@RequestParam("avatar") MultipartFile file, @RequestParam("personnelId") String personnelId) throws BusinessException {
        Personnel personnel = personnelServiceImpl.getById(personnelId);
        try {
            String newPath = fileServiceImpl.upload(file);
            personnel.setPhoto(newPath);
            personnelServiceImpl.updateById(personnel);
            return ResponseResult.success(newPath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BusinessException(BusinessCodes.Upload_File_Failed);
        }
    }
}
