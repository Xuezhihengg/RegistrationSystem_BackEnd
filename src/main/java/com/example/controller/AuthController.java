package com.example.controller;

import com.example.entity.Personnel;
import com.example.entity.dto.response_entity.AuthInfoResponse;
import com.example.entity.dto.response_entity.BusinessException;
import com.example.entity.dto.response_entity.ResponseResult;
import com.example.service.impl.PersonnelServiceImpl;
import com.example.utils.BusinessCodes;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@Tag(name = "登录鉴权接口", description = "Auth")
public class AuthController {
    @Autowired
    PersonnelServiceImpl personnelServiceImpl;

    @GetMapping("/info")
    public ResponseResult<AuthInfoResponse> getUserId() throws BusinessException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String personnelId = null;

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = ((Authentication) authentication).getPrincipal();
            if (principal instanceof UserDetails) {
                personnelId = ((UserDetails) principal).getUsername();
            } else {
                personnelId = principal.toString();
            }
            Personnel personnel = personnelServiceImpl.getById(personnelId);
            String position = personnel.getPosition();
            return ResponseResult.success(AuthInfoResponse.builder()
                    .personnelId(personnelId)
                    .position(position)
                    .build());
        }
        throw new BusinessException(BusinessCodes.Auth_Info_Failed);
    }
}
