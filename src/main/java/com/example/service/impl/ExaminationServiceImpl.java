package com.example.service.impl;

import com.example.dao.PersonnelMapper;
import com.example.entity.Examination;
import com.example.dao.ExaminationMapper;
import com.example.entity.Personnel;
import com.example.entity.dto.response_entity.BusinessException;
import com.example.entity.dto.response_entity.NameListItem;
import com.example.service.IExaminationService;
import com.example.utils.BusinessCodes;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 考试表 服务实现类
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */
@Service
public class ExaminationServiceImpl extends MPJBaseServiceImpl<ExaminationMapper, Examination> implements IExaminationService {
    @Autowired
    private ExaminationMapper examinationMapper;

    @Autowired
    private PersonnelMapper personnelMapper;

    public List<NameListItem> getNameList(String examId) throws BusinessException {
        Examination exam = examinationMapper.selectById(examId);
        if (exam == null) throw new BusinessException(BusinessCodes.Get_Examination_Failed);
        String chiefId = exam.getChiefInvigilator();
        String minorId = exam.getMinorInvigilator();

        NameListItem chiefItem = NameListItem.builder()
                .personnelName(null)
                .personnelId(chiefId)
                .duty("chief").build();

        NameListItem minorItem = NameListItem.builder()
                .personnelName(null)
                .personnelId(minorId)
                .duty("minor").build();

        if (chiefId != null) {
            Personnel chief = personnelMapper.selectById(chiefId);
            if (chief == null) throw new BusinessException(BusinessCodes.Get_Personnel_Failed);
            chiefItem.setPersonnelName(chief.getPersonnelName());
        }
        if (minorId != null) {
            Personnel minor = personnelMapper.selectById(minorId);
            if (minor == null) throw new BusinessException(BusinessCodes.Get_Personnel_Failed);
            minorItem.setPersonnelName(minor.getPersonnelName());
        }
        List<NameListItem> nameList = new LinkedList<>();
        nameList.add(chiefItem);
        nameList.add(minorItem);

        return nameList;
    }
}
