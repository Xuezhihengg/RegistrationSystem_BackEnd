package com.example.dao;

import com.example.entity.Batch;
import com.example.entity.Examination;
import com.example.entity.SignUp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.dto.response_entity.SignUpListItem;
import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.query.MPJLambdaQueryWrapper;
import com.github.yulichang.toolkit.JoinWrappers;

import java.util.List;

/**
 * <p>
 * 报名表 Mapper 接口
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */
public interface SignUpMapper extends MPJBaseMapper<SignUp> {
}
