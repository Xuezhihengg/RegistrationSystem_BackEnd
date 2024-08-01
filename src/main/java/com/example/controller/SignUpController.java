package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.SignUp;
import com.example.entity.dto.request_entity.NewSignupRequest;
import com.example.entity.dto.response_entity.BusinessException;
import com.example.entity.dto.response_entity.ResponseResult;
import com.example.entity.dto.response_entity.SignUpListWithPageInfo;
import com.example.service.impl.SignUpServiceImpl;
import com.example.utils.BusinessCodes;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 报名表 前端控制器
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */
@RestController
@RequestMapping("/signUp")
@Tag(name = "报名表操作接口", description = "Signup")
public class SignUpController {
    @Autowired
    SignUpServiceImpl signUpServiceImpl;

    @Operation(summary = "提交报名")
    @PostMapping("/new")
    public ResponseResult<SignUp> newSignUp(@RequestBody @Validated NewSignupRequest newSignUp) throws BusinessException {
        SignUp signUp = SignUp.builder()
                .personnelId(newSignUp.getPersonnelId())
                .examId(newSignUp.getExamId())
                .duty(newSignUp.getDuty())
                .isReject(false)
                .reason(null)
                .status(1)
                .invitedBy(newSignUp.getInvitedBy())
                .build();

        signUpServiceImpl.save(signUp);
        return ResponseResult.success(signUp);
    }

    @Operation(summary = "分页获取指定人员的报名信息")
    @GetMapping("/{personnelId}/{pageNum}")
    public ResponseResult<SignUpListWithPageInfo> getSignUpList(@PathVariable("personnelId") String personnelId, @PathVariable("pageNum") int pageNum) {
        return ResponseResult.success(signUpServiceImpl.getSignUpList(personnelId, pageNum));
    }
}
