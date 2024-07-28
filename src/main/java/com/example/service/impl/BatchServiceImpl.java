package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    public BatchesWIthPageInfo getBatches(String keyword, int pageNum) throws BusinessException {
        QueryWrapper<Batch> queryWrapper = new QueryWrapper<>();
        if (!keyword.equals("no_search")) {
            queryWrapper.like("batch_name", keyword)
                    .or().like("batch_id", keyword)
                    .or().like("start_date", keyword)
                    .or().like("end_date", keyword);
        }
        List<Batch> batches;
        int totalPages;
        if (pageNum == -1) {
            batches = batchMapper.selectList(queryWrapper);
            totalPages = -1;
        } else {
            PageHelper.startPage(pageNum, 10);
            batches = batchMapper.selectList(queryWrapper);
            if (batches == null || batches.isEmpty()) throw new BusinessException(BusinessCodes.Get_Batch_Failed);
            PageInfo<Batch> pageInfo = new PageInfo<>(batches);
            totalPages = pageInfo.getPages();
        }
        return BatchesWIthPageInfo.builder().batches(batches).totalPages(totalPages).build();
    }

}
