package com.example.service.impl;

import com.example.entity.Batch;
import com.example.dao.BatchMapper;
import com.example.entity.dto.response_entity.BatchesWIthPageInfo;
import com.example.utils.BusinessCodes;
import com.example.entity.dto.response_entity.BusinessException;
import com.example.service.IBatchService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 批次表 服务实现类
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */
@Service
public class BatchServiceImpl extends ServiceImpl<BatchMapper, Batch> implements IBatchService {
    @Autowired
    BatchMapper batchMapper;

    public BatchesWIthPageInfo getAllBatches(int pageNum) throws BusinessException {
        PageHelper.startPage(pageNum, 10);
        List<Batch> batches = batchMapper.selectList(null);
        if (batches == null || batches.isEmpty()) throw new BusinessException(BusinessCodes.Get_Batch_Failed);
        // 获取分页信息
        PageInfo<Batch> pageInfo = new PageInfo<>(batches);
        int totalPages = pageInfo.getPages();

        return BatchesWIthPageInfo.builder().batches(batches).totalPages(totalPages).build();
    }

}
