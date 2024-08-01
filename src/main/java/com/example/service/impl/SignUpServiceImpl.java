package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Batch;
import com.example.entity.Examination;
import com.example.entity.SignUp;
import com.example.dao.SignUpMapper;
import com.example.entity.dto.response_entity.BusinessException;
import com.example.entity.dto.response_entity.ResponseResult;
import com.example.entity.dto.response_entity.SignUpListItem;
import com.example.entity.dto.response_entity.SignUpListWithPageInfo;
import com.example.service.ISignUpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.query.MPJLambdaQueryWrapper;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 报名表 服务实现类
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */
@Service
public class SignUpServiceImpl extends MPJBaseServiceImpl<SignUpMapper, SignUp> implements ISignUpService {
    @Autowired
    SignUpMapper signUpMapper;

    public SignUpListWithPageInfo getSignUpList(String personnelId, int pageNum) throws BusinessException{
        MPJLambdaWrapper<SignUp> queryWrapper = JoinWrappers.lambda(SignUp.class)
                .select(SignUp::getExamId)
                .select(Examination::getExamName)
                .select(Batch::getBatchName)
                .select(SignUp::getDuty)
                .select(SignUp::getStatus)
                .select(SignUp::getIsReject)
                .leftJoin(Examination.class, Examination::getExamId, SignUp::getExamId)
                .leftJoin(Batch.class, Batch::getBatchId, Examination::getBatchId)
                .eq(SignUp::getPersonnelId, personnelId);

        Page<SignUpListItem> listPage = signUpMapper.selectJoinPage(new Page<>(pageNum, 10), SignUpListItem.class, queryWrapper);

        return SignUpListWithPageInfo.builder()
                .signUpList(listPage.getRecords())
                .totalPages(listPage.getTotal())
                .build();
    }
}
