package com.example.service.impl;

import com.example.entity.Examination;
import com.example.dao.ExaminationMapper;
import com.example.service.IExaminationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试表 服务实现类
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */
@Service
public class ExaminationServiceImpl extends ServiceImpl<ExaminationMapper, Examination> implements IExaminationService {

}
